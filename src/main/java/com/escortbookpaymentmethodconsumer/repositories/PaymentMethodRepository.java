package com.escortbookpaymentmethodconsumer.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.escortbookpaymentmethodconsumer.models.PaymentMethod;

import reactor.core.publisher.Mono;

@Repository
public interface PaymentMethodRepository extends ReactiveCrudRepository<PaymentMethod, String> {
    Mono<PaymentMethod> findFirstByName(Mono<String> name);
}
