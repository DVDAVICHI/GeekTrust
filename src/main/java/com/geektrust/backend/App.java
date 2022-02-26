package com.geektrust.backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


import com.geektrust.backend.commands.CommandInvoker;
import com.geektrust.backend.configs.AppConfig;

public class App {	
  
  // To run the application  ./gradlew run --args="INPUT_FILE=sample_input/input1.txt"
	public static void main(String[] args) {

    //args = new String[]{"INPUT_FILE=sample_input/input1.txt"};   
    
		List<String> commandLineArgs = new LinkedList<>(Arrays.asList(args));
        // String expectedSequence = "INPUT_FILE";
        // String actualSequence = commandLineArgs.stream()
        //         .map(a -> a.split("=")[0])
        //         .collect(Collectors.joining("$")).trim();

        // if(expectedSequence.equals(actualSequence)){
            run(commandLineArgs);
        //}


	}

    public static void run(List<String> commandLineArgs) {
    // Complete the final logic to run the complete program.
      String filename = commandLineArgs.get(0);//.split("=")[1];
      File file = Paths.get(filename).toFile();
      AppConfig appConfig = new AppConfig();
      CommandInvoker commandInvoker = appConfig.getCommandInvoker();

      try(BufferedReader br = new BufferedReader(new FileReader(file))){

        String line;
        while((line = br.readLine()) != null){

          List<String> tokens = Arrays.stream(line.split(" ")).collect(Collectors.toList());
          commandInvoker.executeCommand(tokens.get(0), tokens);
        }

      } catch (Exception e) {
        e.printStackTrace();
      }

    }

}
