package com.example.demo.repository;

import com.example.demo.model.entity.Account;
import com.example.demo.model.entity.Tiem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface tiemRepository extends JpaRepository<Tiem, Long> {

    Tiem findByAccount(Account account);
}
