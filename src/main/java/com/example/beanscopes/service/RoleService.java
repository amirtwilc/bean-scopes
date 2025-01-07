package com.example.beanscopes.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RoleService {

    private Integer currentStatus;

    public String checkRole(String status) {
        calculateStatus(stringToInt(status));
        if (Objects.nonNull(currentStatus) && currentStatus == 5) {
            return "ADMIN";
        }
        return "User";
    }

    public void calculateStatus(Integer inputStatus) {
        if (Objects.nonNull(inputStatus) && inputStatus > 0) {
            currentStatus = inputStatus;
        }
    }

    private Integer stringToInt(String status) {
        try {
            return Integer.valueOf(status);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
