package com.deliveryboy.services;

import com.deliveryboy.config.AppConstant;
import com.deliveryboy.dto.Location;
import com.deliveryboy.entity.DeliverAddress;
import com.deliveryboy.repository.DeliveryAddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class KafkaServiceImpl implements KafkaServices{

    @Autowired
    public KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    public KafkaTemplate<String,Location> kafkaTemplate1;


    Logger logger= LoggerFactory.getLogger(KafkaServiceImpl.class);
    @Override
    public boolean updateLocation(String location) {
        // this will use to produce the message
         this.kafkaTemplate.send(AppConstant.LOCATION_TOPIC,location);
         logger.info("location updated "+location+" ," +"you are checking on the log console");
         return  true;
    }

    @Autowired
    DeliveryAddressRepository deliveryAddressRepository;
    @Override
    public boolean updateLocation(Location location) {
        String locationName=location.getLocationName();
        String deliverBoyName=location.getDeliveryBoyName();

        int count =100;
        while(count>0) {
            this.deliveryAddressRepository.save(DeliverAddress.builder().currentAddress(locationName).deliverBoyName(deliverBoyName).build());
            this.kafkaTemplate1.send(AppConstant.DELIVERY_LOCATION_UPDATE, location);
            count--;
        }
        return true;
    }
}
