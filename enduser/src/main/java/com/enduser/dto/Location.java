package com.enduser.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // data annotation is used marked for all the Getter setter or methods it includes
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    private String locationName;
    private  String deliveryBoyName;
}

