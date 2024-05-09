package com.enduser.config;

import com.enduser.dto.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.HashMap;

@Configuration
public class KafkaConsumerConfig {


    Logger logger= LoggerFactory.getLogger(KafkaConsumerConfig.class);

    @KafkaListener(topics = AppConstant.LOCATION_TOPIC,groupId = AppConstant.GROUP_ID)
    public void updatedLocation(String value){

        logger.info("Now the data are coming the realtime from the kafaka listener  "+value);
    }

    @KafkaListener(topics = AppConstant.DELIVERY_LOCATION_UPDATE,groupId = AppConstant.GROUP_ID)
    public void updatedLocation(Location value){
        logger.info("Now the data are coming the realtime from the kafaka listener  "+value.toString());
    }
}
