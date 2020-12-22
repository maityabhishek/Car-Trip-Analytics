package com.cartripanalytics.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;



public class Trip {
	@Id
	private int tripid;
	private String carno;
	private double distance;
	private double fuel;
	private double avgspeed;
	private double triptime;
	private String startpoint;
	private String endpoint;
	private Date tripdate;
	private List<TripSplits> splits;
	private int tripsplitkms;
	private int maxspeed;
	private double fuelefficiency;
	
	public Trip(int tripid, String carno, double distance, double fuel, double avgspeed, double triptime,
			String startpoint, String endpoint, Date tripdate, List<TripSplits> splits, int tripsplitkms, int maxspeed,
			double fuelefficiency) {
		super();
		this.tripid = tripid;
		this.carno = carno;
		this.distance = distance;
		this.fuel = fuel;
		this.avgspeed = avgspeed;
		this.triptime = triptime;
		this.startpoint = startpoint;
		this.endpoint = endpoint;
		this.tripdate = tripdate;
		this.splits = splits;
		this.tripsplitkms = tripsplitkms;
		this.maxspeed = maxspeed;
		this.fuelefficiency = fuelefficiency;
	}
	public double getFuelefficiency() {
		return fuelefficiency;
	}
	public void setFuelefficiency(double fuelefficiency) {
		this.fuelefficiency = ((int)fuelefficiency*100)/100.0;
	}
	public int getMaxspeed() {
		return maxspeed;
	}
	public void setMaxspeed(int maxspeed) {
		this.maxspeed = maxspeed;
	}
	public int getTripsplitkms() {
		return tripsplitkms;
	}
	public void setTripsplitkms(int tripsplitkms) {
		this.tripsplitkms = tripsplitkms;
	}
	public Trip() {
		super();
		
	}
	public int getTripid() {
		return tripid;
	}
	public void setTripid(int tripid) {
		this.tripid = tripid;
	}
	public String getCarno() {
		return carno;
	}
	public void setCarno(String carno) {
		this.carno = carno;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getFuel() {
		return fuel;
	}
	public void setFuel(double fuel) {
		this.fuel = fuel;
	}
	public double getAvgspeed() {
		return avgspeed;
	}
	public void setAvgspeed(double avgspeed) {
		this.avgspeed = avgspeed;
	}
	public double getTriptime() {
		return triptime;
	}
	public void setTriptime(double triptime) {
		this.triptime = triptime;
	}
	public String getStartpoint() {
		return startpoint;
	}
	public void setStartpoint(String startpoint) {
		this.startpoint = startpoint;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public Date getTripdate() {
		return tripdate;
	}
	public void setTripdate(Date tripdate) {
		this.tripdate = tripdate;
	}
	public List<TripSplits> getSplits() {
		return splits;
	}
	public void setSplits(List<TripSplits> splits) {
		this.splits = splits;
	}
	@Override
	public String toString() {
		return "Trip [tripid=" + tripid + ", carno=" + carno + ", distance=" + distance + ", fuel=" + fuel
				+ ", avgspeed=" + avgspeed + ", triptime=" + triptime + ", startpoint=" + startpoint + ", endpoint="
				+ endpoint + ", tripdate=" + tripdate + ", splits=" + splits + ", tripsplitkms=" + tripsplitkms
				+ ", maxspeed=" + maxspeed + ", fuelefficiency=" + fuelefficiency + "]";
	}
	
	
	

}
