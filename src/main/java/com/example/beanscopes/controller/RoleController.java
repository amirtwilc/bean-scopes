package com.example.beanscopes.controller;

import com.example.beanscopes.service.FixedRoleService;
import com.example.beanscopes.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RoleController {

    private final FixedRoleService roleService;

    @GetMapping("/role/{status}")
    public String getRole(@PathVariable String status) {
        return roleService.checkRole(status);
    }
}
