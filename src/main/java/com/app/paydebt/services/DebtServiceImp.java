package com.app.paydebt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.paydebt.DAO.IDebtDAO;
import com.app.paydebt.DTO.DebtDTO;
import com.app.paydebt.model.Debt;

@Service
public class DebtServiceImp implements IDebtService {

	@Autowired
	private IDebtDAO iDebDao;

	@Override
	public List<Debt> findDebtByBankIdAndUserId(Integer bankId, String userId) {
		return iDebDao.findDebtByBankIdAndUserId(bankId, userId);
	}

	@Override
	public void saveDebt(Debt debt) {
		iDebDao.save(debt);
	}

	@SuppressWarnings("unused")
	@Override
	public boolean payDebt(DebtDTO debtDTO) {

		Debt debt = this.findDebtById(debtDTO.getId());

		if (debt == null) {
			return false;
		}

		if (debt.getQuotasNumber() == 0) {
			debt.setQuotasNumber(debtDTO.getQuotasNumber());
		}

		Double totalCount = debt.getTotalCount();
		Double totalDebt = debt.getTotalDebt();
		Integer QuotasNumber = debt.getQuotasNumber();

		Double quota = totalCount / QuotasNumber;
		totalDebt = totalDebt - quota;
		debt.setTotalDebt(totalDebt);

		if (totalDebt == 0) {
			debt.setStatus(false);

		}

		this.saveDebt(debt);
		
		return true;
			
	}

	@Override
	public Debt findDebtById(Integer id) {

		return iDebDao.findById(id).orElse(null);
	}

}
