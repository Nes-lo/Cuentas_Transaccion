package com.neslo.cuentasbancarias.infrastructure.controllers;


import com.neslo.cuentasbancarias.domain.mediators.interfaces.IAccountMediator;
import com.neslo.cuentasbancarias.domain.mediators.interfaces.ICustomerMediator;
import com.neslo.cuentasbancarias.domain.model.Account;
import com.neslo.cuentasbancarias.domain.model.AccountType;
import com.neslo.cuentasbancarias.domain.model.Customer;
import com.neslo.cuentasbancarias.infrastructure.mappers.AccountMapper;
import com.neslo.cuentasbancarias.infrastructure.mappers.CustomerMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@Controller
@RequestMapping("/account")
@AllArgsConstructor
@SessionAttributes("account")
public class AccountController {

    @Autowired
    private final IAccountMediator iAccountMediator;
    @Autowired
    private  final ICustomerMediator iCustomerMediator;

    @GetMapping(value="/list/{id}")
    public String listarId(@PathVariable(value="id") Integer identification, Model model, RedirectAttributes flash) {

        model.addAttribute("title","Listado de Cuentas Cliente");
        model.addAttribute("title0","Informacion de Cliente");
        List<Account> accountsListId= iAccountMediator
                .findByIdentification(identification)
                .stream()
                .map(AccountMapper::account)
                .collect(toList());
        model.addAttribute("account",accountsListId);
        System.out.println("AQQQ");
        model.addAttribute("customer", CustomerMapper.customer(iCustomerMediator.findById(identification)));
        System.out.println("BBBBBB");
        System.out.println(accountsListId);
        return "views/account/listarAccount";
    }

    @RequestMapping(value="/create/{id}")
    public String create(@PathVariable(value="id") Integer identification, Map<String,Object> model, RedirectAttributes flash) {
       /* CustomerDTO customerDTO=null;
        if(identification>0) {
           final ICustomerMediator iCustomerMediator = null;
            customerDTO=iCustomerMediator.findById(identification);
            if(customerDTO==null) {

                flash.addFlashAttribute("error","El ID del cliente no existe en la BBDD");
                return "redirect:/customer/list";
            }

        }else {
            flash.addFlashAttribute("error","El ID del cliente no puede ser 0");
            return "redirect:/customer/list";
        }
        */
       model.put("account", AccountMapper.accountId(identification));
       model.put("title", "Crear Cuenta");

        return "views/account/frmCreateAccount";
    }

    @RequestMapping(value="/save", method= RequestMethod.POST)
    public String save(@Valid Account account, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
        if(result.hasErrors()) {


            model.addAttribute("title","Formulario de Cuenta");
            return "views/account/frmCreateAccount";
        }
        // String mensajeFlash=(customer.getIdentification()!=null)?"Cliente editado con exito":"Cliente creado con exito";
        String mensajeFlash="Cuenta guardada con exito";
        Customer customer=new Customer();
        customer.setIdentification(account.getIdentificationCustomer());

        AccountType accountType=new AccountType();
        accountType.setIdAccountType(account.getIdAccountType());

        account.setCustomer(customer);
        account.setAccountType(accountType);



        iAccountMediator.save(AccountMapper.accountDTO(account));
        status.setComplete();
        flash.addFlashAttribute("success",mensajeFlash);

        return "redirect:/customer/list";

    }

}
