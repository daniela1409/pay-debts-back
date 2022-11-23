package com.app.paydebt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.paydebt.model.Bank;
import com.app.paydebt.services.IBankService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("bank")
public class BankController {

	@Autowired
	private IBankService iBankService;

	@GetMapping("/{userId}")
	public @ResponseBody List<Bank> listBanks(@PathVariable String userId) {
		
		List<Bank> banks = iBankService.findBanksByUsersId(userId);

		return banks;
	}
}
