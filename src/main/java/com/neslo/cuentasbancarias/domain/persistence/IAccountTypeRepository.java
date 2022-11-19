package com.neslo.cuentasbancarias.domain.persistence;

import com.neslo.cuentasbancarias.infrastructure.model.AccountDTO;
import com.neslo.cuentasbancarias.infrastructure.model.AccountTypeDTO;

import java.util.List;

public interface IAccountTypeRepository {

    public List<AccountTypeDTO> findAll();
    public AccountTypeDTO save(AccountTypeDTO accountTypeDTO);
    public AccountTypeDTO findById(Byte idTypeAccount);
    public void delete(Byte idTypeAccount);

}
