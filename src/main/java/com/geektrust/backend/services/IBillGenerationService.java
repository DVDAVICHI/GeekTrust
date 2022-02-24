package com.geektrust.backend.services;

public interface IBillGenerationService {
    
    public static final Integer ALLOCATED_WATER_PER_PERSON = 10;
    public static final Integer BILLABLE_DAYS_IN_MONTH = 30;
    
    public double generateBill();
    public Integer getTotalWaterConsumed();
}