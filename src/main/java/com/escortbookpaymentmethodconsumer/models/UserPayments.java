package com.escortbookpaymentmethodconsumer.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.data.mongodb.core.mapping.FieldType;

import lombok.Data;

@Data
@Document(collection = "user_payments")
public class UserPayments {

    @Id
    @MongoId(FieldType.OBJECT_ID)
    String id;

    @Field(targetType = FieldType.OBJECT_ID, name = "userId")
    String userId;

    @Field(targetType = FieldType.OBJECT_ID, name = "paymentMethodId")
    String paymentMethodId;

    @Field("createdAt")
    LocalDateTime createdAt = LocalDateTime.now();

    @Field("updatedAt")
    LocalDateTime updatedAt = LocalDateTime.now();

    @Override
    public String toString() {
        return "OBJECT ID: " + id
            + "\n USER ID: " + userId
            + "\n PAYMENT METHOD ID: " + paymentMethodId;
    }

}
