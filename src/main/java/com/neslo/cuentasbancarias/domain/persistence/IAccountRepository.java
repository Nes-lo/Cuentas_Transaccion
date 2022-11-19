package com.neslo.cuentasbancarias.domain.persistence;

import com.neslo.cuentasbancarias.infrastructure.model.AccountDTO;

import java.util.List;
import java.util.UUID;

public interface IAccountRepository {

    public List<AccountDTO> findAll();
    public AccountDTO save(AccountDTO accountDTO);
    public AccountDTO findById(UUID accountNumber);

}
