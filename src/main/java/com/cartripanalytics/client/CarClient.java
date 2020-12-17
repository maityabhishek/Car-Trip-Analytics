package com.cartripanalytics.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cartripanalytics.model.Trip;



@FeignClient(url="localhost:8888",name="user-car-service")
public interface CarClient {
	
	@RequestMapping(method=RequestMethod.GET,path="/viewlasttrip/{carno}")
	public ResponseEntity<?> viewLastTrip(@PathVariable("carno")String carno, @RequestHeader(name="Authorization")String token);

	@RequestMapping(method=RequestMethod.POST,path="/addtrip/{carno}")
	public ResponseEntity<?> addTrip(@PathVariable("carno")String carno,@RequestHeader(name="Authorization")String token,@RequestBody Trip carTrip);
	
}
