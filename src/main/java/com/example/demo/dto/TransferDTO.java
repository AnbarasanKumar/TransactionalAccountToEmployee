package com.example.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TransferDTO {
	
	@NotNull(message = "From account ID is required")
    private Long fromId;

    @NotNull(message = "To account ID is required")
    private Long toId;

    @NotNull(message = "Amount is required")
    @Min(value = 1, message = "Transfer amount must be at least 1")
    private Double amount;

	public Long getFromId() {
		return fromId;
	}

	public void setFromId(Long fromId) {
		this.fromId = fromId;
	}

	public Long getToId() {
		return toId;
	}

	public void setToId(Long toId) {
		this.toId = toId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
    
    

}
