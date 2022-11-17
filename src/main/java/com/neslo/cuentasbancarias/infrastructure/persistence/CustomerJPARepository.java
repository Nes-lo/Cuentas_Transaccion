package com.neslo.cuentasbancarias.infrastructure.persistence;

import com.neslo.cuentasbancarias.domain.persistence.ICustomerRepository;
import com.neslo.cuentasbancarias.infrastructure.model.CustomerDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@AllArgsConstructor
public class CustomerJPARepository implements ICustomerRepository {
    private final ICustomerJPARepository clienteRepository;

    @Override
    @Transactional(readOnly=true)
    public List<CustomerDTO> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    @Transactional()
    public CustomerDTO save(CustomerDTO customerDTO) {
     clienteRepository.save(customerDTO);
        return customerDTO;
    }

    @Override
    @Transactional(readOnly=true)
    public CustomerDTO findById(Integer identification) {
        return clienteRepository.findById(identification).orElse(null);
    }
    @Transactional()
    public void delete(Integer identification){

        clienteRepository.deleteById(identification);
    }
}
