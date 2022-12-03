package com.neslo.cuentasbancarias.infrastructure.controllers;

import com.neslo.cuentasbancarias.domain.mediators.interfaces.IAccountTypeMediator;
import com.neslo.cuentasbancarias.domain.model.AccountType;
import com.neslo.cuentasbancarias.domain.model.Customer;
import com.neslo.cuentasbancarias.infrastructure.mappers.AccountTypeMapper;
import com.neslo.cuentasbancarias.infrastructure.mappers.CustomerMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@Controller
@RequestMapping("/accounttype")
@AllArgsConstructor
@SessionAttributes("accounttype")
public class AccountTypeController {

    @Autowired
    private final IAccountTypeMediator iAccountTypeMediator;
    @GetMapping("/list")
    public String listar(Model model) {

        model.addAttribute("title","Listado de Tipo Cuentas");
        List<AccountType> accountTypeList= iAccountTypeMediator
                .findAll()
                .stream()
                .map(AccountTypeMapper::accountType)
                .collect(toList());
        System.out.println(accountTypeList);




        model.addAttribute("accounttype",accountTypeList);
        return "views/accounttype/listarTipeAccount";
    }

    @RequestMapping(value="/create",method = RequestMethod.GET)
    public String create(Model model) {

        AccountType accountType=new AccountType();
        model.addAttribute("accounttype", accountType);
        model.addAttribute("title", "Formulario Tipo de Cuentas");
        return "views/accounttype/frmCreateType";

    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String save(@Valid AccountType accountType, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
        System.out.println("Esto es "+result.hasErrors());
        if(result.hasErrors()) {
            Map<String,String> errores=new HashMap<>();
            result.getFieldErrors().forEach(err->{
                errores.put(err.getField(),"El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
            });
            model.addAttribute("error",errores);
            model.addAttribute("title", "Formulario Tipo de Cuentas");
            return "views/accounttype/frmCreateType";
        }

        String mensajeFlash="Tipo de cuenta guardada con exito";

        iAccountTypeMediator.save(AccountTypeMapper.accountTypeDTO(accountType));
        status.setComplete();
        flash.addFlashAttribute("success",mensajeFlash);
        return "redirect:/accounttype/list";

    }
}
