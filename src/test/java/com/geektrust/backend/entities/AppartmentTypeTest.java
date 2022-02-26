package com.geektrust.backend.entities;

import com.geektrust.backend.exceptions.InvalidAppartmentTypeException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class AppartmentTypeTest {
  @Mock AppartmentType aType;

    @Test
    @DisplayName("#1 AppartmentType should throw InvalidAppartmentTypeException if appartment type is given invalid type")
    public void contest_ShouldThrowInvalidContestException_GivenInvalidQuestionList(){
        //Arrange
        aType = new AppartmentType(4,"3:7");
 
        //Act and Assert
        Assertions.assertThrows(InvalidAppartmentTypeException.class,() -> aType.getNoOfPeople());
    }

    @Test
    public void testTotalRatio(){
         
       aType = new AppartmentType(3,"3:7");
       
       Assertions.assertEquals(10, aType.getTotalRatio());
    }

   //  @Test
   //  public void testTotalNoOfGuests(){
         
   //     aType = new AppartmentType();
   //     aType.addToGuestList(10);

   //     Assertions.assertEquals(10, aType.findAll());
   //  }
}