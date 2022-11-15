package com.neslo.cuentasbancarias.domain.customer;

import com.neslo.cuentasbancarias.domain.model.Customer;
import com.neslo.cuentasbancarias.domain.persistence.ICustomerRepository;

public class CustomerMediatorDefault implements ICustomerMediator {

    private final ICustomerRepository iCustomerRepository;

    public CustomerMediatorDefault(ICustomerRepository iCustomerRepository) {
        this.iCustomerRepository = iCustomerRepository;
    }

    @Override
    public Customer create(Customer customer) {
        return iCustomerRepository.save(customer);
    }

    @Override
    public Customer getCustomerByIdentification(Integer identificatio) {
        return null;
    }
}
