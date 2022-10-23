package com.geektrust.backend.entities;

import com.geektrust.backend.exceptions.InvalidAppartmentTypeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class AppartmentTypeTest {

  @Mock
  AppartmentType aType;

  @Test
  @DisplayName(
    "#1 AppartmentType should throw InvalidAppartmentTypeException if appartment type is given invalid type"
  )
  public void ShouldThrowInvalidAppartmentTypeException_GivenInvalidAppartmentType() {
    //Arrange
    aType = AppartmentType.getApartmentObj();

    //Act and Assert
    Assertions.assertThrows(
      InvalidAppartmentTypeException.class,
      () -> aType.getNoOfPeople(4)
    );
  }

  @Test
  public void testTotalRatio() {
    aType = AppartmentType.getApartmentObj();
    aType.calculateRatio("3:7");

    Assertions.assertEquals(10, aType.getTotalRatio());
  }

  @Test
  public void testTotalNoOfPeople() {
    aType = AppartmentType.getApartmentObj();

    Assertions.assertEquals(3, aType.getNoOfPeople(2));
  }
}
