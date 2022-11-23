package com.app.paydebt.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.paydebt.DTO.DebtDTO;
import com.app.paydebt.model.Debt;
import com.app.paydebt.services.IBankService;
import com.app.paydebt.services.IDebtService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("pay_debts")
public class PayDebtsController {
	
	@Autowired
	private IBankService iBankService;
	
	@Autowired
	private IDebtService iDebtService;

	@PutMapping("/")
	public @ResponseBody String payDebts(@Valid @RequestBody DebtDTO debtDTO, BindingResult result) {
		
		String response = "";
		
		try {
			if (result.hasErrors()) {
	            throw new RuntimeException("El valor minimo de cuotas es 1");
	        }
			
			boolean payDebts = iDebtService.payDebt(debtDTO);
						
			response = "Pago exitoso";
		}catch (RuntimeException e) {
            response = e.getMessage();
        }
		return response;
		
		
//		DebtDTO debtDTO = new DebtDTO();
//		debtDTO.setId(1);
//		debtDTO.setQuotasNumber(1);
//		
//		boolean payDebts = iDebtService.payDebt(debtDTO);
	}
	
}
