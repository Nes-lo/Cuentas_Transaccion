package com.neslo.cuentasbancarias.infrastructure.persistence;

import com.neslo.cuentasbancarias.domain.persistence.IAccountTypeRepository;
import com.neslo.cuentasbancarias.infrastructure.model.AccountTypeDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountTypeJPARespository implements IAccountTypeRepository {

    private final IAccountTypeRepository accountTypeRepository;

    @Override
    public List<AccountTypeDTO> findAll() {
        return accountTypeRepository.findAll();
    }

    @Override
    public AccountTypeDTO save(AccountTypeDTO accountTypeDTO) {
        accountTypeRepository.save(accountTypeDTO);
        return accountTypeDTO;
    }

    @Override
    public AccountTypeDTO findById(Byte idTypeAccount) {
        return accountTypeRepository.findById(idTypeAccount);
    }

    @Override
    public void delete(Byte idTypeAccount) {
      accountTypeRepository.delete(idTypeAccount);
    }
}
