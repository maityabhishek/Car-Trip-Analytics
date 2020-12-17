// Copyright (c) Microsoft Corporation. All rights reserved.
package com.cartripanalytics;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class CarTripAnalyticsApplication  {

    private final Logger logger = LoggerFactory.getLogger(CarTripAnalyticsApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(CarTripAnalyticsApplication.class, args);
    }

    
}
