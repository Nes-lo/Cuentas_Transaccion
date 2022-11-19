package com.neslo.cuentasbancarias.infrastructure.persistence.interfaces;

import com.neslo.cuentasbancarias.infrastructure.model.AccountTypeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountTypeJPARepository extends JpaRepository<AccountTypeDTO,Byte>{

}
