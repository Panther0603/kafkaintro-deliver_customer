package com.deliveryboy.services;

import com.deliveryboy.dto.Location;
import org.springframework.stereotype.Service;

public interface KafkaServices {

    public  boolean updateLocation(String location);
    public  boolean updateLocation(Location location);



}
