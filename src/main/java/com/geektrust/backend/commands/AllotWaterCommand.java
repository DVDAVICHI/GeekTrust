package com.geektrust.backend.commands;

import java.util.List;

import com.geektrust.backend.entities.AppartmentType;
import com.geektrust.backend.services.BoreWellBillGenerationService;
import com.geektrust.backend.services.CorporationBillGenerationService;
import com.geektrust.backend.services.IBillGenerationService;

public class AllotWaterCommand implements ICommand {

    private IBillGenerationService boreBillGeneration;
    private IBillGenerationService corpoBillGeneration;
    private double Bill;
    private Integer waterConsumed;

    public AllotWaterCommand(){}
    
    public AllotWaterCommand(IBillGenerationService boreBillGeneration, IBillGenerationService corpoBillGeneration) {
        this.boreBillGeneration = boreBillGeneration;
        this.corpoBillGeneration = corpoBillGeneration;
	}

	@Override
    public void execute(List<String> tokens, AppartmentType aType) {
        
        Integer apartmentType = Integer.parseInt(tokens.get(1));
        String ratio = tokens.get(2);
        aType = new AppartmentType(apartmentType, ratio);

        BoreWellBillGenerationService boreBillGeneration = new BoreWellBillGenerationService(aType);
        Bill = boreBillGeneration.generateBill();
        waterConsumed = boreBillGeneration.getTotalWaterConsumed();

        CorporationBillGenerationService corpoBillGeneration = new CorporationBillGenerationService(aType);
        Bill += corpoBillGeneration.generateBill();

        BillCommand billCommand = new BillCommand(Bill, waterConsumed);
       
    }

    
    
}