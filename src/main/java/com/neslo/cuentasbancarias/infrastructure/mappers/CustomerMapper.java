package com.neslo.cuentasbancarias.infrastructure.mappers;

import com.neslo.cuentasbancarias.domain.model.Customer;
import com.neslo.cuentasbancarias.infrastructure.model.CustomerDTO;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class CustomerMapper {



    public static Customer customer(CustomerDTO customerDTO){

        Customer customer=new Customer();
        customer.setIdentification(customerDTO.getIdentification());
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setCreateAt(customerDTO.getCreateAt());

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
