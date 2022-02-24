package com.geektrust.backend.services;

import com.geektrust.backend.commands.AddGuestCommand;
import com.geektrust.backend.entities.AppartmentType;


public class TankerBillGenerationService implements IBillGenerationService{
    
    private AppartmentType aType;
    private Integer waterConsumed;
    private Integer noOfGuests;

    public TankerBillGenerationService(AppartmentType aType){       
        this.aType = aType;
        this.noOfGuests = aType.findAll();
    }

    public TankerBillGenerationService() {
  }
  
  public TankerBillGenerationService(Integer noOfGuests) {
    this.noOfGuests = noOfGuests;
	}

	@Override
    public double generateBill() {
        
        waterConsumed = noOfGuests *ALLOCATED_WATER_PER_PERSON *BILLABLE_DAYS_IN_MONTH;
        double result = getSlabRates(waterConsumed) * waterConsumed;
        return result;
    }

    public Integer getSlabRates(Integer waterConsumed){
          
       if(waterConsumed >= 0 && waterConsumed <=500)
          return 2;
        else if(waterConsumed >=501 && waterConsumed <= 1500)
          return 3;
        else if(waterConsumed >= 1501 && waterConsumed <= 3000)
          return 5;
        else
          return 8;
    }

    public Integer getTotalWaterConsumed(){
        return waterConsumed;
    }
    
}