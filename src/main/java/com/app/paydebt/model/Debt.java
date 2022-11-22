package com.app.paydebt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "debts")
public class Debt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "total_count")
	private Double totalCount;

	private Boolean status;

	@Column(name = "total_debt")
	private Double totalDebt;

	private Double QuotaValue;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@NotNull
	private Bank bank;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@NotNull
	private User user;

	@Column(name = "quotas_number")
	private Integer QuotasNumber;

	@Column(name = "create_at")
	private Date createAt;

	@Column(name = "update_at")
	private Date updateAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Double totalCount) {
		this.totalCount = totalCount;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Integer getQuotasNumber() {
		return QuotasNumber;
	}

	public void setQuotasNumber(Integer quotasNumber) {
		QuotasNumber = quotasNumber;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Double getTotalDebt() {
		return totalDebt;
	}

	public void setTotalDebt(Double totalDebt) {
		this.totalDebt = totalDebt;
	}

	public Double getQuotaValue() {
		return QuotaValue;
	}

	public void setQuotaValue(Double quotaValue) {
		QuotaValue = quotaValue;
	}

}
