package com.deliveryboy.services;

import org.springframework.stereotype.Service;

public interface KafkaServices {

    public  boolean updateLocation(String location);
    public  boolean updateLocation(String locationName,String deliverBoyName);



}
