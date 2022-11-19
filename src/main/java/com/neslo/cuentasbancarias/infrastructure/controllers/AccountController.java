package com.neslo.cuentasbancarias.infrastructure.controllers;


import com.neslo.cuentasbancarias.domain.mediators.interfaces.IAccountMediator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/account")
@AllArgsConstructor
@SessionAttributes("account")
public class AccountController {

    @Autowired
    private final IAccountMediator iAccountMediator;

}
