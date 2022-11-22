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

	@Autowired
	private IUserService iUserService;

	@Autowired
	private IBankService iBankService;

	@Override
	public List<Debt> findDebtByBankIdAndUserId(Integer bankId, String userId) {

		if (iUserService.findUserById(userId) != null && iBankService.findBankById(bankId) != null) {
			return iDebDao.findDebtByBankIdAndUserId(bankId, userId);
		}

		return null;

	}

	@Override
	public void saveDebt(Debt debt) {
		iDebDao.save(debt);
	}

	@SuppressWarnings("unused")
	@Override
	public boolean payDebt(DebtDTO debtDTO) {

		Debt debt = this.findDebtById(debtDTO.getId());

		if (debt == null || debtDTO.getQuotasNumber() == null) {
			throw new RuntimeException("Deuda no existente o número de cuotas invalido");
		}

		if (debt.getQuotasNumber() == 0 && debt.getStatus() == true) {
			debt.setQuotasNumber(debtDTO.getQuotasNumber());
		}

		if (debt.getStatus() == false) {
			throw new RuntimeException("La deuda ya está saldada");
		}

		Double totalCount = debt.getTotalCount();
		Double totalDebt = debt.getTotalDebt();
		Integer QuotasNumber = debt.getQuotasNumber();

		Double quota = debt.getQuotaValue();

		if (quota == 0) {
			quota = totalCount / QuotasNumber;
			debt.setQuotaValue(totalCount / QuotasNumber);
		}

		totalDebt = totalDebt - quota;
		debt.setTotalDebt(totalDebt);
		debt.setQuotasNumber(debt.getQuotasNumber() - 1);

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
