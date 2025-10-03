package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.dto.AccountDTO;
import com.example.demo.dto.TransferDTO;
import com.example.demo.entity.Account;
import com.example.demo.entity.Transaction;

@Mapper(componentModel = "spring")
public interface AccountMapper {
	
    Account toAccount(AccountDTO dto);

    @Mapping(target = "fromAccountId", source = "dto.fromId")
    @Mapping(target = "toAccountId", source = "dto.toId")
    @Mapping(target = "amount", source = "dto.amount")
    Transaction toTransaction(TransferDTO dto);

}
