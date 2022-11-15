package com.neslo.cuentasbancarias.domain.persistence;

import com.neslo.cuentasbancarias.domain.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    public List<Customer> findAll();

    public void save(Customer customer);
}
