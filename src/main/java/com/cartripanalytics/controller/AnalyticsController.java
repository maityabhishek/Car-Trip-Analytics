package com.cartripanalytics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AnalyticsController {
	
	
	
	@RequestMapping(path="/analyze/{simid}",method=RequestMethod.GET)
	public String startAnalytics(@PathVariable("simid")String SimulationId)
	{
		return null;
		
	}

}
