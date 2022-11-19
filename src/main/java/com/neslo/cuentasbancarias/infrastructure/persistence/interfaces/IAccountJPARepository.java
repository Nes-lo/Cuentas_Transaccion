package com.neslo.cuentasbancarias.infrastructure.persistence.interfaces;

import com.neslo.cuentasbancarias.infrastructure.model.AccountDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IAccountJPARepository extends JpaRepository<AccountDTO, UUID> {
}
