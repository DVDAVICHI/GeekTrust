package com.geektrust.backend.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.geektrust.backend.entities.AppartmentType;

public class TankerBillGenerationTest {
 @Mock TankerBillGenerationService service;
 @Mock AppartmentType aType;
  

  @Test
  public void testGenerateBill() {
    service = new TankerBillGenerationService(15);

    assertEquals(23500.0, service.generateBill());
  }

  @Test
  public void testGenerateBillWithAppartmentObject(){

    //Act
      aType = new AppartmentType();
      aType.addToGuestList(15);

      //Arrange
      service = new TankerBillGenerationService(aType);

      //Assert
      assertEquals(23500.0, service.generateBill());
  }

  @Test 
  public void testGetSlabRates(){

     service = new TankerBillGenerationService();
      
     assertEquals(4000, service.getSlabRates(1500));
  }

  @Test
  public void testGenerateBill_2() {
    service = new TankerBillGenerationService(7);

    assertEquals(7000.0, service.generateBill());
  }

}