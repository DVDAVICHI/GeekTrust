package com.geektrust.backend.commands;

import com.geektrust.backend.entities.AppartmentType;
import com.geektrust.backend.entities.BillGeneration;
import com.geektrust.backend.services.BoreWellBillGenerationService;
import com.geektrust.backend.services.CorporationBillGenerationService;
import com.geektrust.backend.services.IBillGenerationService;
import java.util.List;

public class AllotWaterCommand implements ICommand {

  private IBillGenerationService boreBillGeneration;
  private IBillGenerationService corpoBillGeneration;
  private double Bill;
  private Integer waterConsumed;

  public AllotWaterCommand() {}

  public AllotWaterCommand(
    IBillGenerationService boreBillGeneration,
    IBillGenerationService corpoBillGeneration
  ) {
    this.boreBillGeneration = boreBillGeneration;
    this.corpoBillGeneration = corpoBillGeneration;
  }

  @Override
  public void execute(List<String> tokens) {
    Integer apartmentType = Integer.parseInt(tokens.get(1));
    String ratio = tokens.get(2);
    //aType = new AppartmentType(apartmentType, ratio);

    AppartmentType.getApartmentObj().calculateRatio(ratio);
    AppartmentType.getApartmentObj().setAppartmentType(apartmentType);

    BillGeneration.getBillGnrtnObj().setBoreWellBill();
    BillGeneration.getBillGnrtnObj().setCorporateBill();
    // BoreWellBillGenerationService boreBillGeneration = new BoreWellBillGenerationService(
    //   aType
    // );
    // Bill = boreBillGeneration.generateBill();
    // waterConsumed = boreBillGeneration.getTotalWaterConsumed();

    // CorporationBillGenerationService corpoBillGeneration = new CorporationBillGenerationService(
    //   aType
    // );
    // Bill += corpoBillGeneration.generateBill();

    // BillCommand billCommand = new BillCommand(Bill, waterConsumed);
  }
}
