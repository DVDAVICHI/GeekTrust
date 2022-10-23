package com.geektrust.backend.entities;

import com.geektrust.backend.services.BoreWellBillGenerationService;
import com.geektrust.backend.services.CorporationBillGenerationService;
import com.geektrust.backend.services.TankerBillGenerationService;

public class BillGeneration {

  private double boreWellBill;
  private double corporateBill;
  private double tankerBill;
  private int totalWater = 0;
  private static BillGeneration obj_BillGnrtn = null;

  public static BillGeneration getBillGnrtnObj() {
    if (obj_BillGnrtn == null) {
      obj_BillGnrtn = new BillGeneration();
    }

    return obj_BillGnrtn;
  }

  public void setBoreWellBill() {
    this.boreWellBill = (new BoreWellBillGenerationService().generateBill());
  }

  public double getBoreWellBill() {
    return boreWellBill;
  }

  public void setCorporateBill() {
    this.corporateBill =
      (new CorporationBillGenerationService().generateBill());
  }

  public double getCorporateBill() {
    return corporateBill;
  }

  public void setTankerBill() {
    this.tankerBill = (new TankerBillGenerationService().generateBill());
  }

  public double getTankerBill() {
    return tankerBill;
  }

  public void setTotalWater(int totalWater) {
    this.totalWater += totalWater;
  }

  public int getTotalWater() {
    return totalWater;
  }
}
