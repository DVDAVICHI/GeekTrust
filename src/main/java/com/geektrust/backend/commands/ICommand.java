package com.geektrust.backend.commands;

import com.geektrust.backend.entities.AppartmentType;
import java.util.List;

public interface ICommand {
  public void execute(List<String> tokens);
}
