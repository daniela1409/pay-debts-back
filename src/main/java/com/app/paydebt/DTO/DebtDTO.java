package com.app.paydebt.DTO;

import javax.validation.constraints.NotEmpty;

public class DebtDTO {

	@NotEmpty
	private Integer id;

	@NotEmpty
	private Integer QuotasNumber;

	public Integer getQuotasNumber() {
		return QuotasNumber;
	}

	public void setQuotasNumber(Integer quotasNumber) {
		QuotasNumber = quotasNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
