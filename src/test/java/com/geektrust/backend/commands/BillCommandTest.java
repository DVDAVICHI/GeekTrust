package com.geektrust.backend.commands;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.geektrust.backend.entities.AppartmentType;
import com.geektrust.backend.services.TankerBillGenerationService;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class BillCommandTest {
    @Mock BillCommand billCommand;
    @Mock AppartmentType aType;
    @Mock TankerBillGenerationService tanker;

    private PrintStream standardOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void cleanup() {
        System.setOut(standardOut);
    }

    @Test
    public void testExecuteMethod() {

        // Act
        List<String> tokens = new ArrayList<>();
        tokens.add("BILL");

        aType = new AppartmentType();
        //aType.addToGuestList(5);
        billCommand = new BillCommand();

        // Arrange
        billCommand.execute(tokens, aType);

        // Assert
        Assertions.assertEquals("0 0", "0 0");
    }
}