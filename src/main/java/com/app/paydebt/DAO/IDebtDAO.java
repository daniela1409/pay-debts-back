package com.app.paydebt.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.app.paydebt.model.Debt;

public interface IDebtDAO extends CrudRepository<Debt, Integer> {

	 public List<Debt> findDebtByBankIdAndUserId(Integer bankId, String userId);
}
