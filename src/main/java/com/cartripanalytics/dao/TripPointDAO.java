package com.cartripanalytics.dao;

import com.azure.spring.data.cosmos.repository.CosmosRepository;

import com.cartripanalytics.model.TripPoint;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface TripPointDAO extends CosmosRepository<TripPoint, String> {
	
	//List<TripPoint> findAllBySimid(int SimulationId);
	List<TripPoint> findAllByVinOrderByTimestamp(int vin);
	
	
}