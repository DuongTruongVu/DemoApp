package com.example.demo.model.mapper;

import com.example.demo.model.dto.AccountDTO;
import com.example.demo.model.entity.Account;


import java.util.List;

public interface AccountMapper {

    AccountDTO toDTO(Account account);

    List<AccountDTO> toListDTO(List<Account> accounts);

    Account toEntity(Account account, AccountDTO accountDTO);

}
