package com.geektrust.backend.commands;

import java.util.List;

import com.geektrust.backend.entities.AppartmentType;
import com.geektrust.backend.services.TankerBillGenerationService;

public class BillCommand implements ICommand {

    private static double bill = 0;
    private static Integer waterConsumed = 0;

    public BillCommand() {
    }

    public BillCommand(double bill, Integer waterConsumed) {
        BillCommand.bill += bill;
        BillCommand.waterConsumed += waterConsumed;
    }

    @Override
    public void execute(List<String> tokens, AppartmentType aType) {

        TankerBillGenerationService tankerBillGeneration = new TankerBillGenerationService();
        if (tankerBillGeneration.aType != null) {

            bill += tankerBillGeneration.generateBill();
            waterConsumed += tankerBillGeneration.getTotalWaterConsumed();
        }

        System.out.println(waterConsumed + " " + (int) Math.ceil(bill));

    }

}