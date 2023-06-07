package com.example.demo.service.impl;


import com.example.demo.model.dto.AccountDTO;
import com.example.demo.model.dto.TiemDTO;
import com.example.demo.model.entity.Account;
import com.example.demo.model.entity.Tiem;
import com.example.demo.service.AccountService;
import com.example.demo.service.RoleService;
import com.example.demo.service.TiemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TiemServiceImpl implements TiemService {

    @Autowired
    private TiemService tiemRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<Tiem> findAll() {
        return tiemRepository.findAll();
    }

    @Override
    public Tiem findById(long id) {
        return tiemRepository.findById(id).orElse(null);
    }

    @Override
    public Tiem save(Tiem tiem) {
        return tiemRepository.save(tiem);
    }

    @Override
    public Tiem findByAccount(Account account) {
        return tiemRepository.findByAccount(account);
    }

    @Override
    public Tiem registerAccount(Tiem tiem, TiemDTO tiemDTO) {
        Account account = new Account();
        AccountDTO accountDTO = tiemDTO.getAccountDTO();
        account.setFullName(accountDTO.getFullName());
        account.setUsername(accountDTO.getEmail());
        account.setPassword(passwordEncoder.encode(accountDTO.getPassword()));
        account.setEmail(accountDTO.getEmail());
        account.setPhone(tiemDTO.getPhone());
        account.setStatus(true);
        account.setRole(roleService.findByName("TIEM"));
        tiem.setAccount(account);
        tiem.setStatus(false);

        accountService.save(account);
        return save(tiem);
    }
}
