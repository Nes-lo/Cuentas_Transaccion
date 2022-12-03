package com.neslo.cuentasbancarias.domain.mediators.interfaces;

import com.neslo.cuentasbancarias.infrastructure.model.AccountDTO;

import java.util.List;


public interface IAccountMediator {

    public List<AccountDTO> findAll();
    public AccountDTO save(AccountDTO accountDTO);
    public AccountDTO findById(String accountNumber);

    public List<AccountDTO> findByIdentification(Integer identificationCustomer);
}
