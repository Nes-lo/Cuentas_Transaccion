package com.neslo.cuentasbancarias.domain.customer.interfaces;

import com.neslo.cuentasbancarias.infrastructure.model.AccountDTO;

import java.util.List;
import java.util.UUID;

public interface IAccountMediator {

    public List<AccountDTO> findAll();
    public AccountDTO save(AccountDTO accountDTO);
    public AccountDTO findById(UUID accountNumber);
}
