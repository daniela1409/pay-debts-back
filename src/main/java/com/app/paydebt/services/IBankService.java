package com.app.paydebt.services;

import java.util.List;
import java.util.UUID;

import com.app.paydebt.model.Bank;

public interface IBankService {
	public  List<Bank> findBanksByUsersId(String userId);
}
