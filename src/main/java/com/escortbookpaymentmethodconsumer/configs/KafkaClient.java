package com.escortbookpaymentmethodconsumer.configs;

public class KafkaClient {

    private KafkaClient() {}

    public static final String GROUP_ID = System.getenv("KAFKA_GROUP_ID");

    public static final String KAFKA_BROKERS = System.getenv("KAFKA_BROKERS");

}
