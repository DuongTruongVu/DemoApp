package com.example.demo.Handler;

import com.example.demo.model.dto.AccountDTO;
import com.example.demo.model.entity.Account;

import com.example.demo.service.impl.CustomAccountDetails;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice(annotations = Controller.class)
public class UserLoginHandler {

    @ModelAttribute("userLogin")
    public AccountDTO getCurrentUser(Authentication authentication) {
        if (authentication != null) {
            CustomAccountDetails customUserDetails = (CustomAccountDetails) authentication.getPrincipal();

            Account account = null;
            if (customUserDetails != null) {
                account = customUserDetails.getAccount();
            }

            AccountDTO accountDTO = null;

            if (account != null) {
                accountDTO = new AccountDTO();
                accountDTO.setFullName(account.getFullName());
                accountDTO.setUsername(account.getUsername());
                accountDTO.setEmail(account.getEmail());
                accountDTO.setRole(account.getRole().getName());
            }

            return accountDTO;
        }

        return null;
    }
}
