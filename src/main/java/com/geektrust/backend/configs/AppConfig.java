package com.geektrust.backend.configs;

import com.geektrust.backend.commands.AddGuestCommand;
import com.geektrust.backend.commands.AllotWaterCommand;
import com.geektrust.backend.commands.BillCommand;
import com.geektrust.backend.commands.CommandInvoker;
import com.geektrust.backend.commands.ICommand;
import com.geektrust.backend.entities.AppartmentType;
import com.geektrust.backend.services.BoreWellBillGenerationService;
import com.geektrust.backend.services.CorporationBillGenerationService;
import com.geektrust.backend.services.IBillGenerationService;
import com.geektrust.backend.services.TankerBillGenerationService;

public class AppConfig {
  

  private final IBillGenerationService boreBillGeneration = new BoreWellBillGenerationService();
  private final IBillGenerationService corpoBillGeneration = new CorporationBillGenerationService();
  private final IBillGenerationService tankerBillGeneration = new TankerBillGenerationService();

  private final AllotWaterCommand allotWater = new AllotWaterCommand(boreBillGeneration,corpoBillGeneration);
  private final AddGuestCommand addGuests = new AddGuestCommand(tankerBillGeneration);
  private final BillCommand bill = new BillCommand();

 // private final AllotWaterCommand allot = new AllotWaterCommand(boreBillGeneration,corpoBillGeneration);  

  private final CommandInvoker commandInvoker = new CommandInvoker();

  public CommandInvoker getCommandInvoker(){
    commandInvoker.registerCommand("ALLOT_WATER", allotWater);
    commandInvoker.registerCommand("ADD_GUESTS", addGuests);
    commandInvoker.registerCommand("BILL", bill);
   
    return commandInvoker;
  }
}