package com.escortbookpaymentmethodconsumer.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.escortbookpaymentmethodconsumer.models.UserPayments;

@Repository
public interface UserPaymentsRepository extends ReactiveCrudRepository<UserPayments, String> {}
