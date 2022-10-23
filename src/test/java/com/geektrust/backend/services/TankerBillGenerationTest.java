package com.geektrust.backend.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.geektrust.backend.entities.AppartmentType;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class TankerBillGenerationTest {

  @Mock
  TankerBillGenerationService service;

  @Mock
  AppartmentType aType;

  @Test
  public void testGenerateBill() {
    aType = AppartmentType.getApartmentObj();
    aType.addToGuestList(15);

    service = new TankerBillGenerationService();

    assertEquals(23500.0, service.generateBill());
  }

  @Test
  public void testGenerateBillWithAppartmentObject() {
    //Act
    aType = AppartmentType.getApartmentObj();
    aType.setNoOfGuests(15);

    //Arrange
    service = new TankerBillGenerationService();

    //Assert
    assertEquals(23500.0, service.generateBill());
  }

  @Test
  public void testGetSlabRates() {
    service = new TankerBillGenerationService();

    assertEquals(4000, service.getSlabRates(1500));
  }

  @Test
  public void testGenerateBill_2() {
    aType = AppartmentType.getApartmentObj();
    aType.setNoOfGuests(7);

    service = new TankerBillGenerationService();

    assertEquals(7000.0, service.generateBill());
  }
}
