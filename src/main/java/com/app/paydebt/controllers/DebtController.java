package com.app.paydebt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.paydebt.model.Debt;
import com.app.paydebt.services.IDebtService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("debt")
public class DebtController {
	
	@Autowired
	private IDebtService iDebtService;

	@GetMapping("/{userId}/{bankId}")
	public @ResponseBody List<Debt> listDebts(@PathVariable String userId,
			@PathVariable Integer bankId) {
		
		List<Debt> debts = iDebtService.findDebtByBankIdAndUserId(bankId, userId);

		return debts;
	}
}
