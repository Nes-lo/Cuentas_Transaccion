package com.neslo.cuentasbancarias.domain.customer.interfaces;

import com.neslo.cuentasbancarias.infrastructure.model.AccountTypeDTO;

import java.util.List;

public interface IAccountTypeMediator {

    public List<AccountTypeDTO> findAll();
    public AccountTypeDTO save(AccountTypeDTO accountTypeDTO);
    public AccountTypeDTO findById(Byte idTypeAccount);
    public void delete(Byte idTypeAccount);
}
