package com.neslo.cuentasbancarias.domain.persistence;

import com.neslo.cuentasbancarias.domain.model.Customer;
import com.neslo.cuentasbancarias.infrastructure.model.CustomerDTO;

import java.util.List;

public interface ICustomerRepository {
    public List<CustomerDTO> findAll();

    public CustomerDTO save(CustomerDTO  customerDTO);

    public CustomerDTO findById(Integer identification);

    public void delete(Integer identification);
}
