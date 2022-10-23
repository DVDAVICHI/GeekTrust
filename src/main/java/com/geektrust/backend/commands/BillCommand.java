package com.geektrust.backend.commands;

import com.geektrust.backend.entities.AppartmentType;
import com.geektrust.backend.entities.BillGeneration;
import com.geektrust.backend.services.TankerBillGenerationService;
import java.util.List;

public class BillCommand implements ICommand {

  private double bill = 0;
  private Integer waterConsumed = 0;

  public BillCommand() {}

  //   public BillCommand(double bill, Integer waterConsumed) {
  //     BillCommand.bill += bill;
  //     BillCommand.waterConsumed += waterConsumed;
  //   }

  @Override
  public void execute(List<String> tokens) {
    BillGeneration.getBillGnrtnObj().setTankerBill();

    // TankerBillGenerationService tankerBillGeneration = new TankerBillGenerationService();
    // if (tankerBillGeneration.aType != null) {
    //   bill += tankerBillGeneration.generateBill();
    //   waterConsumed += tankerBillGeneration.getTotalWaterConsumed();
    // }
    bill =
      BillGeneration.getBillGnrtnObj().getBoreWellBill() +
      BillGeneration.getBillGnrtnObj().getCorporateBill() +
      BillGeneration.getBillGnrtnObj().getTankerBill();

    waterConsumed = BillGeneration.getBillGnrtnObj().getTotalWater();

    System.out.println(waterConsumed + " " + (int) Math.ceil(bill));
  }
}
