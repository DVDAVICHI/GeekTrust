package com.geektrust.backend.services;

import java.util.HashMap;
import java.util.LinkedHashMap;

import com.geektrust.backend.entities.AppartmentType;


public class TankerBillGenerationService extends IBillGenerationService{
    
    public static AppartmentType aType;
    private Integer waterConsumed = 0;
    private static Integer noOfGuests = 0;
    private Integer rWater = 0;

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
        double result = getSlabRates(waterConsumed);
        return result;
    }

    public Integer getSlabRates(Integer waterConsumed){
          
       int res = 0;
       int slab = 500;
       LinkedHashMap<Integer,Integer> slabRates = new LinkedHashMap<>();
       slabRates.put(500,2);
       slabRates.put(1000,3);
       slabRates.put(1500,5);
       slabRates.put(Integer.MAX_VALUE,8);

       while(waterConsumed > 0)
       {
           if(!slabRates.containsKey(slab))
           {
               res += waterConsumed * slabRates.entrySet().iterator().next().getValue();
               waterConsumed = -1;
           }
        else{
          waterConsumed -= slab;
          res += slab * slabRates.get(slab);
          slabRates.remove(slab);
          if(waterConsumed > slab)
             slab += 500;
        }

       }
       return res;
    }

    public Integer getTotalWaterConsumed(){
        return waterConsumed;
    }
    
}