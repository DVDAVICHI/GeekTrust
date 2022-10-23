package com.geektrust.backend.commands;

import com.geektrust.backend.entities.AppartmentType;
import com.geektrust.backend.entities.BillGeneration;
import com.geektrust.backend.services.IBillGenerationService;
import com.geektrust.backend.services.TankerBillGenerationService;
import java.util.List;

public class AddGuestCommand implements ICommand {

  private IBillGenerationService tankerBillGeneration;
  private Integer noOfGuests = 0;
  private double Bill = 0;
  private Integer waterConsumed = 0;
  private AppartmentType aType;

  public AddGuestCommand() {}

  public AddGuestCommand(IBillGenerationService tankerBillGeneration) {
    this.tankerBillGeneration = tankerBillGeneration;
  }

  @Override
  public void execute(List<String> tokens) {
    noOfGuests = Integer.parseInt(tokens.get(1));
    AppartmentType.getApartmentObj().addToGuestList(noOfGuests);
    // TankerBillGenerationService tankerBillGeneration = new TankerBillGenerationService(
    //   aType
    // );
    // this.Bill = tankerBillGeneration.generateBill();
    // this.waterConsumed = tankerBillGeneration.getTotalWaterConsumed();

    // BillCommand billCommand = new BillCommand(Bill, waterConsumed);

  }
}
