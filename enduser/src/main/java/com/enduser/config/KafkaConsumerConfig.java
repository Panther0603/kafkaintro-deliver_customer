package com.enduser.config;

import com.enduser.dto.Location;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;
@Configuration
@EnableKafka
public class KafkaConsumerConfig {


    private static final String GROUP_ID = "group-1";
    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerConfig.class);
    @Bean
    public ConsumerFactory<String, Location> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        logger.debug(GROUP_ID);
        // Configure key deserializer with ErrorHandlingDeserializer
        ErrorHandlingDeserializer<String> keyDeserializer = new ErrorHandlingDeserializer<>(new StringDeserializer());

        // Configure value deserializer with ErrorHandlingDeserializer
        ErrorHandlingDeserializer<Location> valueDeserializer = new ErrorHandlingDeserializer<>(new JsonDeserializer<>(Location.class));

        return new DefaultKafkaConsumerFactory<>(props, keyDeserializer, valueDeserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Location> kafkaListenerContainerFactory() {

        ConcurrentKafkaListenerContainerFactory<String, Location> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
