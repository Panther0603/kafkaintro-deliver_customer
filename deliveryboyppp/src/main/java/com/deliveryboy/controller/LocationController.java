package com.deliveryboy.controller;

import com.deliveryboy.dto.Location;
import com.deliveryboy.services.KafkaServiceImpl;
import com.deliveryboy.services.KafkaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    KafkaServiceImpl kafkaService;
    @PostMapping("/currentLocation")
    public ResponseEntity<?> sendLocationUpdate(@RequestBody Location location){
        kafkaService.updateLocation(location.getLocationName());
        return new ResponseEntity<>(Map.of("Message","Location Updated"), HttpStatus.OK);
    }

    @PostMapping("/currentLocationDeliveryBoy")
    public ResponseEntity<?> sendLocationUpdateDeliverBoy(@RequestBody Location location){
        kafkaService.updateLocation(location);
        return new ResponseEntity<>(Map.of("Message"," Updated location "+location.getLocationName()+" of deliver boy :-->"+location.getDeliveryBoyName()), HttpStatus.OK);
    }
}
