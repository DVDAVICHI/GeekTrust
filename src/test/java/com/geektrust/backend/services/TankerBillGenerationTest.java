package com.geektrust.backend.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.geektrust.backend.entities.AppartmentType;

public class TankerBillGenerationTest {
 @Mock TankerBillGenerationService service;
 @Mock AppartmentType aType;
  @BeforeEach
  void setUp() {
    service = new TankerBillGenerationService(15);
  }

  @Test
  public void testGenerateBill() {
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
}