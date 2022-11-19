package com.neslo.cuentasbancarias.domain.mediators;

import com.neslo.cuentasbancarias.domain.mediators.interfaces.IAccountTypeMediator;
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
    public AccountTypeDTO findById(Long idTypeAccount) {
        return iAccountTypeRepository.findById(idTypeAccount);
    }

    @Override
    public void delete(Long idTypeAccount) {
        iAccountTypeRepository.delete(idTypeAccount);

    }
}
