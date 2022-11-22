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
	private IBankDAO iBankDao;
	
	@Autowired
	private IUserService iUserService;

	@Override
	public List<Bank> findBanksByUsersId(String userId) {
		
		if(iUserService.findUserById(userId) != null) {
			return iBankDao.findBanksByUsersId(userId);
		}
		
		return null;
	}

	@Override
	public Bank findBankById(Integer bankId) {
		
		return iBankDao.findById(bankId).orElse(null);
	}

	
}
