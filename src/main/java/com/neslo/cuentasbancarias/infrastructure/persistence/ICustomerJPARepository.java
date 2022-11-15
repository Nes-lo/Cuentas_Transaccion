package com.neslo.cuentasbancarias.infrastructure.persistence;


import com.neslo.cuentasbancarias.infrastructure.model.CustomerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerJPARepository extends JpaRepository<CustomerDTO,Integer> {
}
