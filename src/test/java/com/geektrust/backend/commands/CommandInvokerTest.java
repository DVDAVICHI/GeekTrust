package com.geektrust.backend.commands;

import java.util.ArrayList;

import com.geektrust.backend.exceptions.CommandNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class CommandInvokerTest {
    
    @Mock CommandInvoker commandInvoker;
    
    @BeforeEach
    void setup(){
        commandInvoker = new CommandInvoker();
        
    }

    @Test
    @DisplayName("executeCommand method Should Throw Exception Given Incorrect CommandName and List of tokens")
    public void executeCommand_GivenIncorrectNameAndTokens_ShouldThrowException() {
        //Act and Assert
        Assertions.assertThrows(CommandNotFoundException.class,() -> commandInvoker.executeCommand("RANDOM-COMMAND",new ArrayList<String>()));

    }
}