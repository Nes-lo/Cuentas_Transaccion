package com.neslo.cuentasbancarias.domain.customer;


import com.neslo.cuentasbancarias.infrastructure.model.CustomerDTO;

import java.util.List;

public interface ICustomerMediator {

  CustomerDTO create(CustomerDTO customerDTO);
  public List<CustomerDTO> findAllCustomers();

}
