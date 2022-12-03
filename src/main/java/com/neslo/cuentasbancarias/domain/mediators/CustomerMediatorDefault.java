package com.neslo.cuentasbancarias.domain.mediators;

import com.neslo.cuentasbancarias.domain.mediators.interfaces.ICustomerMediator;
import com.neslo.cuentasbancarias.domain.persistence.ICustomerRepository;
import com.neslo.cuentasbancarias.infrastructure.model.CustomerDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
//@NoArgsConstructor(force = true)
@Component
public class CustomerMediatorDefault implements ICustomerMediator {

    private final ICustomerRepository iCustomerRepository;




    @Override
    public CustomerDTO create(CustomerDTO customerDTO) {
        return iCustomerRepository.save(customerDTO);
    }

    @Override
    public CustomerDTO findById(Integer idetification) {
        return iCustomerRepository.findById(idetification);
    }
    public void delete(Integer identification){
        iCustomerRepository.delete(identification);
    }
    @Override
    public List<CustomerDTO> findAllCustomers() {
        return iCustomerRepository.findAll();
    }


}
