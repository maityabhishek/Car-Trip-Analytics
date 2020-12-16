package com.cartripanalytics.model;

public class TripSplits {
	
	private int fromKms;
	private int toKms;
	private double time;
	private int avgSpeed;
	private double fuelconsumed;

	public int getFromKms() {
		return fromKms;
	}
	public void setFromKms(int fromKms) {
		this.fromKms = fromKms;
	}
	public int getToKms() {
		return toKms;
	}
	public void setToKms(int toKms) {
		this.toKms = toKms;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public int getAvgSpeed() {
		return avgSpeed;
	}
	public void setAvgSpeed(int avgSpeed) {
		this.avgSpeed = avgSpeed;
	}
	public double getFuelconsumed() {
		return fuelconsumed;
	}
	public void setFuelconsumed(double fuelconsumed) {
		this.fuelconsumed = fuelconsumed;
	}
	public TripSplits(int fromKms, int toKms, double time, int avgSpeed, double fuelconsumed) {
		super();
		
		this.fromKms = fromKms;
		this.toKms = toKms;
		this.time = time;
		this.avgSpeed = avgSpeed;
		this.fuelconsumed = fuelconsumed;
	}
	public TripSplits() {
		super();
	}
	
}
