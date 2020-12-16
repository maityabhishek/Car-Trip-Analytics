package com.cartripanalytics.model;


import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

@Container(containerName = "cont1", ru = "400")

public class TripPoint {
	
	@PartitionKey
    private String timestamp;
	private int vin;
	private String id;
	private int simulationid;
	private int speed;
	private long odometer;
	private double fuel;
	
	
	
	
	

	

}
