package com.geektrust.backend.commands;

import java.util.List;

import com.geektrust.backend.entities.AppartmentType;

public class BillCommand implements ICommand {

    private static double bill = 0;
    private static Integer waterConsumed = 0;

    public BillCommand(){}

    public BillCommand(double bill, Integer waterConsumed){
            BillCommand.bill += bill;
            BillCommand.waterConsumed += waterConsumed;
    }

    @Override
    public void execute(List<String> tokens, AppartmentType aType) {       
       
        System.out.println(waterConsumed + " " + Math.round(bill) );

    }

    
    
}