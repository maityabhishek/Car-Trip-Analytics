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
		double avgspeed=0.0;
		
		int fromKms=0;
		double nextSplitpoint = tripsplitkms;
		long odometerinitial=list.get(0).getOdometer();
		int speed=0;
		int splitDist=0;
		
		int dataCounter=0;
		double initialfuel=list.get(0).getFuel();
		double splitfuel=0.0;
		long initialTime=list.get(0).getTs();
		long splitTime=0; 
		List<TripSplits> splits=new ArrayList<TripSplits>();
		
		TripPoint tp=null;
		for(int counter=1;counter<=list.size();counter++)
		{
			//System.out.println(list.get(counter-1));
			tp=list.get(counter-1);
			System.out.println(tp.getOdometer()-odometerinitial);
			if(tp.getOdometer()>=nextSplitpoint|| tp.getOdometer()==list.get(dataPointNos-1).getOdometer())
			{
				
				splits.add(new TripSplits(fromKms,splitDist,splitTime,speed/(dataCounter),splitfuel));
				fromKms=splits.get(splits.size()-1).getToKms()+1;
				dataCounter=0;
				initialfuel=tp.getFuel();
				initialTime=tp.getTs();
				speed=0;
				System.out.println(splits.get(splits.size()-1));
				nextSplitpoint=tripsplitkms*(splits.size()+1);
				System.out.println(counter+"next on "+nextSplitpoint);
				
				
			}
			dataCounter++;
			speed=speed+tp.getSpeed();
			splitDist=(int) (tp.getOdometer()-odometerinitial);
			splitfuel=initialfuel-tp.getFuel();
			splitTime=tp.getTs()-initialTime;
			//test
		}
		avgspeed = (splits.stream().mapToInt(t -> t.getAvgSpeed()).sum())/4.0;
		Trip trip=new Trip(1,"OD02F7497",totalKmstraveled,totalFuelConsumed,avgspeed,triptime,"A","B",new Date(list.get(0).getTs()),(int)Math.round(tripsplitkms),splits);
		System.out.println("\n\n\n\n\n\n"+trip+"\n\n\n\n\n\n");

		return true;
	}
	
	
	
}
