package com.example.demo.Handler;

import com.example.demo.model.entity.Account;
import com.example.demo.service.impl.CustomAccountDetails;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        String redirectURL = "/login";
        try {
            CustomAccountDetails customUserDetails = (CustomAccountDetails) authentication.getPrincipal();
            Account account = customUserDetails.getAccount();

            if (account != null) {
                switch (account.getRole().getName().toUpperCase()) {
                    case "ADMIN":
                        redirectURL = "/manager/home";
                        break;
                    case "USER":
                        redirectURL = "/home";
                        break;
                    default:
                        redirectURL = "/login";
                        break;
                }
            }
                response.sendRedirect(redirectURL);
            } catch (Exception ex) {
                response.sendRedirect(redirectURL);
            }
        }

}