package com.neslo.cuentasbancarias.domain.customer;

import com.neslo.cuentasbancarias.domain.persistence.ICustomerRepository;
import com.neslo.cuentasbancarias.infrastructure.model.CustomerDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerMediatorDefault implements ICustomerMediator {

    private final ICustomerRepository iCustomerRepository;

    public CustomerMediatorDefault(ICustomerRepository iCustomerRepository) {
        this.iCustomerRepository = iCustomerRepository;
    }

    @Override
    public CustomerDTO create(CustomerDTO customerDTO) {
        return iCustomerRepository.save(customerDTO);
    }

    @Override
    public List<CustomerDTO> findAllCustomers() {
        return iCustomerRepository.findAll();
    }


}
