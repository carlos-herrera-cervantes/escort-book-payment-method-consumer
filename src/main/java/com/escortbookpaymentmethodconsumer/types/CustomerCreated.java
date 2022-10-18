package com.escortbookpaymentmethodconsumer.types;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CustomerCreated {

    @JsonProperty("_id")
    String customerId;

    @JsonProperty("type")
    String type;

    @JsonProperty("email")
    String email;

}
