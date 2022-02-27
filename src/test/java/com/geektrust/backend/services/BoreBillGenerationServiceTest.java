package com.geektrust.backend.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.geektrust.backend.entities.AppartmentType;

public class BoreBillGenerationServiceTest {
    @Mock BoreWellBillGenerationService service;
    @Mock AppartmentType aType;

 
  @Test
  public void testGenerateBill() {
    service = new BoreWellBillGenerationService(7, 10, 3);    
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

  @Test
  public void testGenerateBill_2() {
    service = new BoreWellBillGenerationService(4, 9, 5);    
    assertEquals(1000.0, service.generateBill());
  }
}