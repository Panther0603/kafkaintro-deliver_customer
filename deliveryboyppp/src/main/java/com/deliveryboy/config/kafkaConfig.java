package com.deliveryboy.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class kafkaConfig {

    @Bean
    public NewTopic createNewTopic(){
        return TopicBuilder.name(AppConstant.LOCATION_TOPIC).build();
    }


    @Bean
    public NewTopic createNewTopicNewTopic(){
        return TopicBuilder.name(AppConstant.DELIVERY_LOCATION_UPDATE).build();
    }
}
