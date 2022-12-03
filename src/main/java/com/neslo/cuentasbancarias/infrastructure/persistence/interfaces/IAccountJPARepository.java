package com.neslo.cuentasbancarias.infrastructure.persistence.interfaces;

import com.neslo.cuentasbancarias.infrastructure.model.AccountDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Repository
public interface IAccountJPARepository extends JpaRepository<AccountDTO, String> {

    @Transactional(readOnly=true)
 List<AccountDTO> findByIdentificationCustomer(Integer identificationCustomer);

}

