package com.cartripanalytics.dao;

import com.azure.spring.data.cosmos.repository.CosmosRepository;

import com.cartripanalytics.model.TripPoint;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface TripPointDAO extends CosmosRepository<TripPoint, String> {
	
	List<TripPoint> findAllBySimulationidOrderByTimestamp(int SimulationId);
	//List<TripPoint> findAllByVin(int vin);
	
	
}