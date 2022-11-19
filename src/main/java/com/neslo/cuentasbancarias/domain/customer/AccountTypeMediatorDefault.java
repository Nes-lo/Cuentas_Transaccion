package com.neslo.cuentasbancarias.domain.customer;

import com.neslo.cuentasbancarias.domain.customer.interfaces.IAccountTypeMediator;
import com.neslo.cuentasbancarias.domain.persistence.IAccountTypeRepository;
import com.neslo.cuentasbancarias.infrastructure.model.AccountTypeDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@AllArgsConstructor
@Component
public class AccountTypeMediatorDefault implements IAccountTypeMediator {
    private final IAccountTypeRepository iAccountTypeRepository;

    @Override
    public List<AccountTypeDTO> findAll() {
        return iAccountTypeRepository.findAll();
    }

    @Override
    public AccountTypeDTO save(AccountTypeDTO accountTypeDTO) {
        return iAccountTypeRepository.save(accountTypeDTO);
    }

    @Override
    public AccountTypeDTO findById(Byte idTypeAccount) {
        return iAccountTypeRepository.findById(idTypeAccount);
    }

    @Override
    public void delete(Byte idTypeAccount) {
        iAccountTypeRepository.delete(idTypeAccount);

    }
}
