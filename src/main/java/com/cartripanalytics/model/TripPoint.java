package com.cartripanalytics.model;


import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

@Container(containerName = "cont1", ru = "400")

public class TripPoint {
	
	@PartitionKey
    private String timestamp;
	private int vin;
	private String id;
	private String simulationid;
	private int speed;
	private long odometer;
	private double fuel;
	private long ts;
	private String simid;
	
	@Override
	public String toString() {
		return "TripPoint [timestamp=" + timestamp + ", vin=" + vin + ", id=" + id + ", simulationid=" + simulationid
				+ ", speed=" + speed + ", odometer=" + odometer + ", fuel=" + fuel + ", ts=" + ts + ", simid=" + simid
				+ "]";
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
		this.ts = Long.parseLong(timestamp);
	}
	public int getVin() {
		return vin;
	}
	public void setVin(int vin) {
		this.vin = vin;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSimulationid() {
		return simulationid;
	}
	public void setSimulationid(String simulationid) {
		this.simulationid = simulationid;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public long getOdometer() {
		return odometer;
	}
	public void setOdometer(long odometer) {
		this.odometer = odometer;
	}
	public double getFuel() {
		return fuel;
	}
	public void setFuel(double fuel) {
		this.fuel = fuel;
	}
	public long getTs() {
		return ts;
	}
	public void setTs(long ts) {
		this.ts = ts;
	}
	public String getSimid() {
		return simid;
	}
	public void setSimid(String simid) {
		this.simid = simid;
	}
	public TripPoint(String timestamp, int vin, String id, String simulationid, int speed, long odometer, double fuel,
			long ts, String simid) {
		super();
		this.timestamp = timestamp;
		this.vin = vin;
		this.id = id;
		this.simulationid = simulationid;
		this.speed = speed;
		this.odometer = odometer;
		this.fuel = fuel;
		this.ts = Long.parseLong(timestamp);
		this.simid = simid;
	}
	public TripPoint() {
		super();
	}
	
	
}
