package com.neslo.cuentasbancarias.infrastructure.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@AllArgsConstructor
public class HomeController {
    @GetMapping({"/index","/home","/"})

    public String index() {

        return "home";

    }
}
