package com.geektrust.backend.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.geektrust.backend.entities.AppartmentType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class CorporationBillGenerationServiceTest {
    @Mock CorporationBillGenerationService service;
    @Mock AppartmentType aType;
    
  @BeforeEach
  void setUp() {
    service = new CorporationBillGenerationService(3, 10, 3);
  }

  @Test
  public void testGenerateBill() {
    assertEquals(270.0, service.generateBill());
  }

  @Test
  public void testGenerateBillWithAppartmentObject(){
     
      //Act
      aType = new AppartmentType(2, "3:7");

      //Arrange
      service = new CorporationBillGenerationService(aType);

      //Assert
      assertEquals(270.0, service.generateBill());
  }
}