package com.escortbookpaymentmethodconsumer.backgrounds;

import com.escortbookpaymentmethodconsumer.configs.KafkaTopic;
import com.escortbookpaymentmethodconsumer.models.PaymentMethod;
import com.escortbookpaymentmethodconsumer.models.UserPayments;
import com.escortbookpaymentmethodconsumer.repositories.PaymentMethodRepository;
import com.escortbookpaymentmethodconsumer.repositories.UserPaymentsRepository;
import com.escortbookpaymentmethodconsumer.types.CustomerCreated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class PaymentMethodConsumer {

    @Autowired
    private UserPaymentsRepository userPaymentsRepository;

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @KafkaListener(
        topics = KafkaTopic.PAYMENT_METHOD_CHANGES,
        groupId = "escort-book-payment-method-consumer"
    )
    public void consume(String message) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        CustomerCreated customerCreated = mapper.readValue(message, CustomerCreated.class);

        Mono<PaymentMethod> paymentMethodMono = paymentMethodRepository.findFirstByName(Mono.just("Cash"));
        PaymentMethod paymentMethod = paymentMethodMono.block();

        UserPayments userPayments = new UserPayments();
        userPayments.setUserId(customerCreated.getCustomerId());
        userPayments.setPaymentMethodId(paymentMethod.getId());

        userPaymentsRepository.save(userPayments).block();

        log.info("Cash payment method added for user: " + customerCreated.getEmail());
    }

}
