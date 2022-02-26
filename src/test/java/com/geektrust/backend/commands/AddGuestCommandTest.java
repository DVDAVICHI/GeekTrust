package com.geektrust.backend.commands;

import java.util.ArrayList;
import java.util.List;

import com.geektrust.backend.entities.AppartmentType;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class AddGuestCommandTest {
    @Mock AppartmentType aType;
    @Mock AddGuestCommand addGuest;
    
    @Test
    public void testAddCommand_Execute_Function(){
        
         // Act
         List<String> tokens = new ArrayList<>();
         tokens.add("ADD Guest");
         tokens.add("5");
         aType = new AppartmentType(3 , "3:7") ;
         addGuest = new AddGuestCommand();

         //Arrange         
         addGuest.execute(tokens, aType);
         Integer expectedSequence = Integer.parseInt(tokens.get(1));

         //Assert
         Assertions.assertEquals(expectedSequence, aType.getNoOfPeople() );

    }
}