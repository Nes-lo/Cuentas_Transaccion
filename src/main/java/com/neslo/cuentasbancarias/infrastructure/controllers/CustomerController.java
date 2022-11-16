package com.neslo.cuentasbancarias.infrastructure.controllers;


import com.neslo.cuentasbancarias.domain.customer.ICustomerMediator;
import com.neslo.cuentasbancarias.domain.model.Customer;
import com.neslo.cuentasbancarias.infrastructure.mappers.CustomerMapper;
import com.neslo.cuentasbancarias.infrastructure.model.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@SessionAttributes("cliente")
public class CustomerController {

    @Autowired
    private final ICustomerMediator iCustomerMediator;

    public CustomerController(ICustomerMediator iCustomerMediator) {
        this.iCustomerMediator = iCustomerMediator;
    }

    @GetMapping(value="/customerlist")
    public String listar(Model model) {

        model.addAttribute("titulo","Listado de Clientes");
        model.addAttribute("clientes",iCustomerMediator.findAllCustomers());
        return "listar";

    }

    @RequestMapping(value="/customercreate")
    public String create(Map<String,Object> model) {

        Customer customer=new Customer();
        model.put("customer", customer);
        model.put("titulo", "Formulario de Cliente");
        return "customer";

    }

    @RequestMapping(value="/customer", method= RequestMethod.POST)
    public ResponseEntity<Customer> save(@RequestBody Customer customer, Model model){

        CustomerDTO customerDTOToCreate= CustomerMapper.customerDTO(customer);

        CustomerDTO customerDTOCreate=iCustomerMediator.create(customerDTOToCreate);

        Customer customerCreated=CustomerMapper.customer(customerDTOCreate);

        return new ResponseEntity<>(customerCreated, HttpStatus.CREATED);
    }
}
