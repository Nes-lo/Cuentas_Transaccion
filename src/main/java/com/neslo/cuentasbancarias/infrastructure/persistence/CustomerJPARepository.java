package com.neslo.cuentasbancarias.infrastructure.persistence;

import com.neslo.cuentasbancarias.domain.model.Customer;
import com.neslo.cuentasbancarias.domain.persistence.ICustomerRepository;
import com.neslo.cuentasbancarias.infrastructure.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerJPARepository implements ICustomerRepository {
    private final ICustomerJPARepository clienteRepository;

    public CustomerJPARepository(ICustomerJPARepository clienteRepository) {
       this.clienteRepository = clienteRepository;
    }

    @Override
    public List<CustomerDTO> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
     clienteRepository.save(customerDTO);
        return customerDTO;
    }
}
