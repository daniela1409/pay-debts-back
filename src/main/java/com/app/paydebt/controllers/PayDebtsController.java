package com.app.paydebt.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pay_debts")
public class PayDebtsController {

	@GetMapping("/")
	public String ensayo() {
		return "Holi";
	}
}
