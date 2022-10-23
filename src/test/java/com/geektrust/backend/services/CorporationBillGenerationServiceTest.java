package com.geektrust.backend.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.geektrust.backend.entities.AppartmentType;
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class CorporationBillGenerationServiceTest {

  @Mock
  CorporationBillGenerationService service;

  @Mock
  AppartmentType aType;

  @Test
  public void testGenerateBill() {
    aType = AppartmentType.getApartmentObj();
    aType.setAppartmentType(2);
    aType.calculateRatio("3:7");

    service = new CorporationBillGenerationService(3, 10, 3);

    assertEquals(270.0, service.generateBill());
  }

  @Test
  public void testGenerateBillWithAppartmentObject() {
    //Act
    aType = AppartmentType.getApartmentObj();
    aType.setAppartmentType(2);
    aType.calculateRatio("3:7");

    //Arrange
    service = new CorporationBillGenerationService();

    //Assert
    assertEquals(270.0, service.generateBill());
  }

  @Test
  public void testGenerateBill_2() {
    aType = AppartmentType.getApartmentObj();
    aType.setAppartmentType(3);
    aType.calculateRatio("5:4");

    service = new CorporationBillGenerationService(5, 9, 5);

    assertEquals(833.3333333333334, service.generateBill());
  }
}
