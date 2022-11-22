package com.app.paydebt.services;

import java.util.List;

import com.app.paydebt.DTO.DebtDTO;
import com.app.paydebt.model.Debt;

public interface IDebtService {
	
	public List<Debt> findDebtByBankIdAndUserId(Integer bankId, String userId);
	public void saveDebt(Debt debt);
	public boolean payDebt(DebtDTO debtDTO);
	public Debt findDebtById(Integer id);

}
