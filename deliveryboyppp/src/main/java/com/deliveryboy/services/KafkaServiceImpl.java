package com.deliveryboy.services;

import com.deliveryboy.config.AppConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaServiceImpl implements KafkaServices{

    @Autowired
    public KafkaTemplate<String,String> kafkaTemplate;

    Logger logger= LoggerFactory.getLogger(KafkaServiceImpl.class);
    @Override
    public boolean updateLocation(String location) {
        // this will use to produce the message
         this.kafkaTemplate.send(AppConstant.LOCATION_TOPIC,location);
         logger.info("location updated "+location+" ," +"you are checking on the log console");
         return  true;
    }
}
