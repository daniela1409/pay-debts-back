package com.app.paydebt.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.paydebt.DTO.DebtDTO;
import com.app.paydebt.model.Bank;
import com.app.paydebt.model.Debt;
import com.app.paydebt.services.IBankService;
import com.app.paydebt.services.IDebtService;

@RestController
@RequestMapping("pay_debts")
public class PayDebtsController {
	
	@Autowired
	private IBankService iBankService;
	
	@Autowired
	private IDebtService iDebtService;

	@GetMapping("/")
	public boolean ensayo() {
		
		//List <Bank> banks = iBankService.findBanksByUsersId("psX5PbFyD2ecmchB2pbMnFIycHP2");
		
		//List<Debt> debts = iDebtService.findDebtByBankIdAndUserId(1, "psX5PbFyD2ecmchB2pbMnFIycHP2");
		DebtDTO debtDTO = new DebtDTO();
		debtDTO.setId(1);
		debtDTO.setQuotasNumber(1);
		
		boolean payDebts = iDebtService.payDebt(debtDTO);
		
		return payDebts;
	}
}
