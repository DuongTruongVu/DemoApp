package com.example.demo.service.impl;


import com.example.demo.model.dto.AccountDTO;
import com.example.demo.model.entity.Account;
import com.example.demo.model.entity.Role;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.AccountService;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleService roleService;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(long id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username).orElse(null);
    }

    @Override
    public Account findByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    @Override
    public Account findByPhone(String phone) {
        return accountRepository.findByPhone(phone);
    }

    @Override
    public Account save(AccountDTO accountDTO) {
        if (accountDTO == null) {
            return null;
        }

        Account account = findById(accountDTO.getId());
        if (account == null) {
            account = new Account();
        }

        if (accountDTO.getId() == 0) {
            String password = "123456";
            String encodedPassword = passwordEncoder.encode(password);
            account.setPassword(encodedPassword);
        }

        // role
        Role role = roleService.findById(Long.parseLong(accountDTO.getRole()));
        account.setRole(role);

        // account
        account.setId(accountDTO.getId());
        account.setUsername(accountDTO.getUsername().trim());
        if (accountDTO.getEmail() != null) {
            account.setEmail(accountDTO.getEmail().trim());
        }
        account.setStatus(accountDTO.isStatus());

        return accountRepository.save(account);
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account register(AccountDTO accountDTO) {
        if (accountDTO == null) {
            return null;
        }

        Account account = new Account();
        // role
        Role role = roleService.findByName(accountDTO.getRole());
        account.setRole(role);

        // account
        account.setId(accountDTO.getId());
        account.setUsername(accountDTO.getUsername().trim());
        String encodedPassword = passwordEncoder.encode(accountDTO.getPassword());
        account.setPassword(encodedPassword);
        account.setEmail(accountDTO.getUsername().trim());
        account.setStatus(true);

        return accountRepository.save(account);
    }

}
