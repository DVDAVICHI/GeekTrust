package com.geektrust.backend.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.geektrust.backend.entities.AppartmentType;

public class BoreBillGenerationServiceTest {
    @Mock BoreWellBillGenerationService service;
    @Mock AppartmentType aType;

  @BeforeEach
  void setUp() {
    service = new BoreWellBillGenerationService(7, 10, 3);    
  }

  @Test
  public void testGenerateBill() {
    assertEquals(945.0, service.generateBill());
  }
  
  @Test
  public void testGenerateBillWithAppartmentObject(){
      //Act
      aType = new AppartmentType(2, "3:7");
     
      //Arrange
      service = new BoreWellBillGenerationService(aType);
 
      //Assert
      assertEquals(945.0, service.generateBill());
  }
}