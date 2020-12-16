package com.cartripanalytics.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cartripanalytics.dao.TripPointDAO;
import com.cartripanalytics.model.Trip;
import com.cartripanalytics.model.TripPoint;
import com.cartripanalytics.model.TripSplits;

@Service
public class TripAnalyticsService {
	
	@Autowired
	private TripPointDAO tripdao;
	public boolean analyzedata(String simulationid) 
	{
		List<TripPoint> list =tripdao.findAllByVinOrderByTimestamp(Integer.parseInt(simulationid));
		int dataPointNos=list.size();
		double totalKmstraveled=(list.get(dataPointNos-1).getOdometer())-(list.get(0).getOdometer());
		double totalFuelConsumed=(list.get(0).getFuel())-(list.get(dataPointNos-1).getFuel());
		double triptime=(list.get(dataPointNos-1).getTs())-(list.get(0).getTs());
		double tripsplitkms=(totalKmstraveled/4.0);
		
		double nextsplit=tripsplitkms;
		int splitcount=1;
		int sfromKm=0;
		long initialTime=list.get(0).getTs();
		long splitTime=0; 
		int speed=0;
		int datacount=1;
		double initialfuel=list.get(0).getFuel();
		double splitfuel=0.0;
		
		List<TripSplits> splits=new ArrayList<TripSplits>();
		TripPoint tp=null;
		for(int counter=1;counter<=list.size();counter++)
		{
			tp=list.get(counter-1);
			System.out.println(tp);
			if(tp.getOdometer()>=nextsplit)
			{
				splitcount+=1;
				splits.add(new TripSplits(sfromKm,(int) nextsplit,splitTime,speed/datacount,splitfuel));
				sfromKm=(int) (nextsplit+1);
				nextsplit=tripsplitkms*splitcount;
				initialfuel=tp.getFuel();
				datacount=0;
				speed=0;
				System.out.println(splitcount+"\t\t"+nextsplit);
				System.out.println("\n\t\twe Split next on "+nextsplit+"\t\tcur:"+tp.getOdometer()+ "\n\n");
				
			}
			splitTime=tp.getTs()-initialTime;
			speed=speed+tp.getSpeed();
			splitfuel=initialfuel-tp.getFuel();
			datacount++;
		}
		double avgspeed = (splits.stream().mapToInt(t -> t.getAvgSpeed()).sum())/4.0;
		Trip trip=new Trip(1,"OD02F7497",totalKmstraveled,totalFuelConsumed,avgspeed,triptime,"A","B",new Date(list.get(0).getTs()),(int)Math.round(tripsplitkms),splits);
		System.out.println("\n\n\n\n\n\n"+trip+"\n\n\n\n\n\n");

		return true;
	}
	
	
	
}
