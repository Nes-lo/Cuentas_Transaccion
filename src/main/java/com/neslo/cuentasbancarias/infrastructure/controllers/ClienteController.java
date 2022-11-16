package com.neslo.cuentasbancarias.infrastructure.controllers;

import com.neslo.cuentasbancarias.domain.customer.ICustomerMediator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/")
@AllArgsConstructor
public class ClienteController {

    @Autowired
    private final ICustomerMediator iCustomerMediator;

    @GetMapping(value="/listars")
    public String listar(Model model) {

           model.addAttribute("titulo","Listado de Clientes");
           model.addAttribute("clientes",iCustomerMediator.findAllCustomers());
           System.out.println("f");
           return "listar";



    }


}
