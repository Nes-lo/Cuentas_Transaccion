package com.neslo.cuentasbancarias.infrastructure.persistence;

import com.neslo.cuentasbancarias.domain.persistence.ICustomerRepository;
import com.neslo.cuentasbancarias.infrastructure.model.CustomerDTO;
import com.neslo.cuentasbancarias.infrastructure.persistence.interfaces.ICustomerJPARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerJPARepository implements ICustomerRepository {
    private final ICustomerJPARepository customerRepository;

    @Override
    @Transactional(readOnly=true)
    public List<CustomerDTO> findAll() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional()
    public CustomerDTO save(CustomerDTO customerDTO) {
        customerDTO.setCreateAt(prePersist());
     customerRepository.save(customerDTO);
        return customerDTO;
    }

    public Date prePersist() {
       return new Date();
          }


    @Override
    @Transactional(readOnly=true)
    public CustomerDTO findById(Integer identification) {
        return customerRepository.findById(identification).orElse(null);
    }
    @Transactional()
    public void delete(Integer identification){

        customerRepository.deleteById(identification);
    }
}
