package com.neslo.cuentasbancarias.infrastructure.persistence;

import com.neslo.cuentasbancarias.domain.model.Customer;
import com.neslo.cuentasbancarias.domain.persistence.ICustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerJPARepository implements ICustomerRepository {
    private final ICustomerJPARepository clienteRepository;

    public CustomerJPARepository(ICustomerJPARepository clienteRepository) {
       this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Customer save(Customer customer) {
     clienteRepository.save(customer);
        return customer;
    }
}
