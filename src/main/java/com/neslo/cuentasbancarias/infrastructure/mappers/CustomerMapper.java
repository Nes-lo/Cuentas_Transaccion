package com.neslo.cuentasbancarias.infrastructure.mappers;

import com.neslo.cuentasbancarias.domain.model.Account;
import com.neslo.cuentasbancarias.domain.model.Customer;
import com.neslo.cuentasbancarias.infrastructure.model.CustomerDTO;

public class CustomerMapper {



    public static Customer customer(CustomerDTO customerDTO){

        Customer customer=new Customer();
        customer.setIdentification(customerDTO.getIdentification());
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setCreateAt(customerDTO.getCreateAt());

        return customer;

    }

    public  static Customer customerId(Integer identification){
        Customer customer=new Customer();
        customer.setIdentification(identification);

        return customer;
    }
    public static CustomerDTO customerDTO(Customer customer){


        return CustomerDTO.builder()
                .identification(customer.getIdentification())
                .name(customer.getName())
                .email(customer.getEmail())
                .createAt(customer.getCreateAt())
                .build();
    }

}
