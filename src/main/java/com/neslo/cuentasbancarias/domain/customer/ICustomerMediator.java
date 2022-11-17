package com.neslo.cuentasbancarias.domain.customer;


import com.neslo.cuentasbancarias.infrastructure.model.CustomerDTO;

import java.util.List;

public interface ICustomerMediator {

  public CustomerDTO create(CustomerDTO customerDTO);

  public CustomerDTO findById(Integer idetification);

  public void delete(Integer identification);
  public List<CustomerDTO> findAllCustomers();

}
