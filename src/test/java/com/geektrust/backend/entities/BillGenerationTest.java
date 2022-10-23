package com.geektrust.backend.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class BillGenerationTest {

  @Mock
  AppartmentType aType;

  BillGeneration bType;

  @Test
  public void setBoreWellBillTest() {
    aType = AppartmentType.getApartmentObj();
    aType.setAppartmentType(2);
    aType.calculateRatio("3:7");

    bType = BillGeneration.getBillGnrtnObj();
    bType.setBoreWellBill();

    assertEquals(945.0, bType.getBoreWellBill());
  }

  @Test
  public void setCorporateBillTest() {
    aType = AppartmentType.getApartmentObj();
    aType.setAppartmentType(2);
    aType.calculateRatio("3:7");

    bType = BillGeneration.getBillGnrtnObj();
    bType.setCorporateBill();

    assertEquals(270.0, bType.getCorporateBill());
  }

  @Test
  public void setTankerBillTest() {
    aType = AppartmentType.getApartmentObj();
    aType.setNoOfGuests(15);

    bType = BillGeneration.getBillGnrtnObj();
    bType.setTankerBill();

    assertEquals(23500.0, bType.getTankerBill());
  }
}
