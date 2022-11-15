package com.neslo.cuentasbancarias.domain.customer;

import com.neslo.cuentasbancarias.domain.model.Customer;

public interface ICustomerMediator {

  Customer create(Customer customer);
  Customer getCustomerByIdentification(Integer identificatio);

}
