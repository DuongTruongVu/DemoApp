package com.example.demo.service;

import com.example.demo.model.dto.AccountDTO;
import com.example.demo.model.entity.Account;


import java.util.List;

public interface AccountService {

    List<Account> findAll();

    Account findById(long id);

    Account findByUsername(String username);

    Account findByEmail(String email);

    Account findByPhone(String phone);

    Account save(AccountDTO accountDTO);

    Account save(Account account);

    Account register(AccountDTO accountDTO);

}
