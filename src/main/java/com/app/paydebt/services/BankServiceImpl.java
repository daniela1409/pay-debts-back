package com.app.paydebt.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.paydebt.DAO.IBankDAO;
import com.app.paydebt.model.Bank;

@Service
public class BankServiceImpl implements IBankService{
	
	@Autowired
	private IBankDAO ibankDao;

	@Override
	public List<Bank> findBanksByUsersId(String userId) {
		
		return ibankDao.findBanksByUsersId(userId);
	}

	
}
