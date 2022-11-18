package com.neslo.cuentasbancarias.infrastructure.controllers;


import com.neslo.cuentasbancarias.domain.customer.ICustomerMediator;
import com.neslo.cuentasbancarias.domain.model.Customer;
import com.neslo.cuentasbancarias.infrastructure.mappers.CustomerMapper;
import com.neslo.cuentasbancarias.infrastructure.model.CustomerDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/customer")
@AllArgsConstructor
@SessionAttributes("customer")
public class CustomerController {

    @Autowired
    private final ICustomerMediator iCustomerMediator;


    @GetMapping("/list")
    public String listar(Model model) {

        model.addAttribute("title","Listado de Clientes");
                 List<Customer> customerList= iCustomerMediator
                  .findAllCustomers()
                 .stream()
                 .map(CustomerMapper::customer)
                 .collect(toList());
        model.addAttribute("customers",customerList);
        System.out.println("lis");
        return "views/customer/listar";
    }

    @RequestMapping(value="/create",method = RequestMethod.GET)
    public String create(Map<String,Object> model) {

        Customer customer=new Customer();
        model.put("customer", customer);
        model.put("title", "Formulario de Cliente");
        return "views/customer/frmCreate";

    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String save(@Valid Customer customer, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
        System.out.println("F"+result.hasErrors());
        if(result.hasErrors()) {
           /*
           una opcion manual para enviar los mensajes de error
           model.addAttribute("title","Formulario de Cliente");
            Map<String,String> errores=new HashMap<>();
            result.getFieldErrors().forEach(err->{
                errores.put(err.getField(),"El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
            });
            model.addAttribute("error",errores);*/
            return "views/customer/frmCreate";
        }
       // String mensajeFlash=(customer.getIdentification()!=null)?"Cliente editado con exito":"Cliente creado con exito";
        String mensajeFlash="Cliente guardado con exito";
        iCustomerMediator.create(CustomerMapper.customerDTO(customer));
        status.setComplete();
        flash.addFlashAttribute("success",mensajeFlash);
        return "redirect:/customer/list";

    }

    @RequestMapping(value="/edit/{id}")
    public String edit(@PathVariable(value="id") Integer identification, Map<String,Object> model, RedirectAttributes flash) {
        CustomerDTO customerDTO=null;
        if(identification>0) {
            customerDTO=iCustomerMediator.findById(identification);
            if(customerDTO==null) {


                flash.addFlashAttribute("error","El ID del cliente no existe en la BBDD");
                return "redirect:/customer/list";
            }

        }else {
            flash.addFlashAttribute("error","El ID del cliente no puede ser 0");
            return "redirect:/customer/list";
        }
        model.put("customer",CustomerMapper.customer(customerDTO));
        model.put("title", "Editar Cliente");

        return "views/customer/frmCreate";
    }

    @RequestMapping(value="/delete/{id}")
    public String eliminar(@PathVariable(value="id") Integer identification, RedirectAttributes flash) {
        if(identification>0) {
            iCustomerMediator.delete(identification);
            flash.addFlashAttribute("success","Cliente Eliminado Con Exito");
        }
        return "redirect:/customer/list";
    }
    @RequestMapping(value="/customer", method= RequestMethod.POST)
    public ResponseEntity<Customer> saved(@RequestBody Customer customer){

        CustomerDTO customerDTOToCreate= CustomerMapper.customerDTO(customer);
        CustomerDTO customerDTOCreate=iCustomerMediator.create(customerDTOToCreate);
        Customer customerCreated=CustomerMapper.customer(customerDTOCreate);
        return new ResponseEntity<>(customerCreated, HttpStatus.CREATED);
    }
}
