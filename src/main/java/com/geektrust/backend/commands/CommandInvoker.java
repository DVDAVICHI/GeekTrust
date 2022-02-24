package com.geektrust.backend.commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.geektrust.backend.entities.AppartmentType;
import com.geektrust.backend.exceptions.CommandNotFoundException;

public class CommandInvoker {

    private Map<String, ICommand> commandMap = new HashMap<>();
  
    public void registerCommand(String commandName, ICommand command){
      commandMap.put(commandName, command);
    }
  
    public void executeCommand(String commandName, List<String> tokens){
      ICommand command = commandMap.get(commandName);
      AppartmentType aType = new AppartmentType();
      if(command == null){
        throw new CommandNotFoundException();
      }
  
      command.execute(tokens,aType);
    }
  
  }