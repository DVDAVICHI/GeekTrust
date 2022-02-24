package com.geektrust.backend.services;

import com.geektrust.backend.entities.AppartmentType;

public class BoreWellBillGenerationService implements IBillGenerationService {

    private final double FLAT_RATE = 1.5;
    private AppartmentType aType;    
    private Integer waterConsumed;
    private Integer boreRatio;
    private double totalRatio;
    private Integer people;

    public BoreWellBillGenerationService(AppartmentType aType){
        this.aType = aType;    
        this.boreRatio = aType.getBoreRatio();
        this.totalRatio = boreRatio + aType.getCorporationRatio();
        this.people = aType.getNoOfPeople(); 
    }

    public BoreWellBillGenerationService() {
	}
    
    public BoreWellBillGenerationService(Integer boreRatio, double totalRatio, Integer people) {
        this.boreRatio = boreRatio;
        this.totalRatio = totalRatio;
        this.people = people;
    }
    
	@Override
    public double generateBill() {        
        
        waterConsumed = people *ALLOCATED_WATER_PER_PERSON *BILLABLE_DAYS_IN_MONTH;
        double result = (boreRatio / totalRatio) * waterConsumed *FLAT_RATE;
        return result;
    }

    public Integer getTotalWaterConsumed(){
        return waterConsumed;
    }
    
}