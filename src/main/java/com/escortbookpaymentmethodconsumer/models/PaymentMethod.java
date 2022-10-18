package com.escortbookpaymentmethodconsumer.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.data.mongodb.core.mapping.FieldType;

import lombok.Data;

@Data
@Document(collection = "payment_methods")
public class PaymentMethod {

    @Id
    @MongoId(FieldType.OBJECT_ID)
    String id;

    @Field("name")
    String name;

    @Field("description")
    String description;

    @Field("deleted")
    boolean deleted;

    @Field("createdAt")
    LocalDateTime createdAt = LocalDateTime.now();

    @Field("updatedAt")
    LocalDateTime updatedAt = LocalDateTime.now();

    @Override
    public String toString() {
        return "OBJECT ID: " + id +
            "\n NAME: " + name +
            "\n DESCRIPTION: " + description +
            "\n DELETED: " + deleted;
    }

}
