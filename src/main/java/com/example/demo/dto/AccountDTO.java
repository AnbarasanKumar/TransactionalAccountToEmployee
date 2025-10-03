package com.example.demo.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AccountDTO {
	
	@NotBlank(message = "Account name is required")
    private String accountName;

    @Min(value = 0, message = "Balance must be zero or positive")
    private Double balance;

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
    
    


}
