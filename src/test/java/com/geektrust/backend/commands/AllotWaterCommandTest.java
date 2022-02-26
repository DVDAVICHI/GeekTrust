package com.geektrust.backend.commands;

import java.util.ArrayList;
import java.util.List;

import com.geektrust.backend.entities.AppartmentType;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class AllotWaterCommandTest {
    @Mock AppartmentType aType;
    @Mock AllotWaterCommand allotWater;

    @Test
    public void testAddCommand_Execute_Function(){
        
         // Act
         List<String> tokens = new ArrayList<>();
         tokens.add("ALLOT WATER");
         tokens.add("3");
         tokens.add("3:7");
         aType = new AppartmentType(Integer.parseInt(tokens.get(1)) , tokens.get(2)) ;
         allotWater = new AllotWaterCommand();

         //Arrange         
         allotWater.execute(tokens, aType);         

         //Assert
         Assertions.assertEquals(5, aType.getNoOfPeople() );

    }
}