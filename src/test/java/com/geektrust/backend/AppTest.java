package com.geektrust.backend;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("AppTest")
public class AppTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("Integration Test #1")
    void runTest1(){

        //Arrange
        List<String> arguments= new ArrayList<>(List.of("INPUT_FILE=sample_input/input1.txt"));

		String expectedOutput = "900"+" "+"1200";
        //Act
        App.run(arguments);

        //Assert
        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());
 
	}

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

}
