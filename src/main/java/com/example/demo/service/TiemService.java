package com.example.demo.service;

import com.example.demo.model.dto.TiemDTO;
import com.example.demo.model.entity.Account;
import com.example.demo.model.entity.Tiem;

import java.util.List;

public interface TiemService {
    Tiem findByAccount(Account account);

    List<Tiem> findAll();

    Tiem findById(long id);

    Tiem save(Tiem tiem);

    Tiem registerAccount(Tiem tiem, TiemDTO tiemDTO);
}
