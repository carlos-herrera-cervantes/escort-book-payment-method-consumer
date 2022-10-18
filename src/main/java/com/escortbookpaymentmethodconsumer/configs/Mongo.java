package com.escortbookpaymentmethodconsumer.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

@EnableReactiveMongoRepositories
public class Mongo {

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create();
    }

}
