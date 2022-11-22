package com.app.paydebt.DTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DebtDTO {

	@Min(1)
	private Integer id;

	@Min(1)
	private Integer quotasNumber;

	public Integer getQuotasNumber() {
		return quotasNumber;
	}

	public void setQuotasNumber(Integer quotasNumber) {
		this.quotasNumber = quotasNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
