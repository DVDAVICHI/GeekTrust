package com.geektrust.backend.entities;

import com.geektrust.backend.exceptions.InvalidAppartmentTypeException;

public class AppartmentType extends BaseEntity{
    
    private double Bill = 0;
    private Integer appartmentType = 0;
    private Integer corporation = 0;
    private Integer bore = 0;
    private static Integer noOfGuests = 0;
    private Integer waterConsumed = 0;

    public AppartmentType(){}

    public AppartmentType(Integer appartmentType, String ratio)
    {
        this.appartmentType = appartmentType;
        String corpToBore[] = ratio.split(":");
        this.corporation = Integer.parseInt(corpToBore[0]);
        this.bore = Integer.parseInt(corpToBore[1]);
    }
    
    public Integer getNoOfPeople()
    {
        switch(appartmentType){
            case 2 :
               return 3;
            case 3 :
               return 5;
            default : 
               throw new InvalidAppartmentTypeException();
        }       
           
    }

    public Integer getAppartmentType(){
        return this.appartmentType;
    }

    public Integer getCorporationRatio(){
        return this.corporation;
    }

    public Integer getBoreRatio(){
        return this.bore;
    }

    public void addToGuestList(Integer noOfGuests) {
        AppartmentType.noOfGuests += noOfGuests;
    }

    public Integer findAll(){
        return AppartmentType.noOfGuests;
    }

    public double getBill(){
        return this.Bill;
    }

    public Integer getWaterConsumed(){
        return this.waterConsumed;
    }

    public Integer getTotalRatio(){
        return this.bore + this.corporation;
    }

      
      
}