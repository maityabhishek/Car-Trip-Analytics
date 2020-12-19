package com.cartripanalytics.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cartripanalytics.dao.TripPointDAO;
import com.cartripanalytics.service.TripAnalyticsService;



@RestController
@CrossOrigin(origins = "*")
public class AnalyticsController {
	
	@Autowired
	private TripAnalyticsService tripservice;
	@Autowired
	private TripPointDAO tp;
	@RequestMapping(path="/analyze/{simulationId}",method=RequestMethod.GET)
	public boolean startAnalytics(@PathVariable("simulationId") String simulationId)
	{
		return tripservice.analyzedata(simulationId);	
	}

}
