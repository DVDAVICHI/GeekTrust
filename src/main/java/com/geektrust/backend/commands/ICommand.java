package com.geektrust.backend.commands;

import java.util.List;

import com.geektrust.backend.entities.AppartmentType;

public interface ICommand {
    public void execute(List<String> tokens, AppartmentType aType);
  }