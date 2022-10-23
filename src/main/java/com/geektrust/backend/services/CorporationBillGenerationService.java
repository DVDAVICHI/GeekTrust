package com.geektrust.backend.services;

import com.geektrust.backend.entities.AppartmentType;

public class CorporationBillGenerationService extends IBillGenerationService {

  private final double FLAT_RATE = 1.0;
  private AppartmentType aType;
  private Integer waterConsumed;
  private Integer corpRatio;
  private double totalRatio;
  private Integer people;

  public CorporationBillGenerationService() {}

  public CorporationBillGenerationService(
    Integer corpRatio,
    double totalRatio,
    Integer people
  ) {
    this.corpRatio = corpRatio;
    this.totalRatio = totalRatio;
    this.people = people;
  }

  @Override
  public double generateBill() {
    corpRatio = AppartmentType.getApartmentObj().getCorporationRatio();
    totalRatio = AppartmentType.getApartmentObj().getTotalRatio();
    int appType = AppartmentType.getApartmentObj().getAppartmentType();
    people = AppartmentType.getApartmentObj().getNoOfPeople(appType);

    waterConsumed =
      people * ALLOCATED_WATER_PER_PERSON * BILLABLE_DAYS_IN_MONTH;
    double result = (corpRatio / totalRatio) * waterConsumed * FLAT_RATE;
    return result;
  }
  // public Integer getTotalWaterConsumed(){
  //     return waterConsumed;
  // }

}
