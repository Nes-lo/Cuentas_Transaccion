package com.neslo.cuentasbancarias.infrastructure.persistence;

import com.neslo.cuentasbancarias.domain.persistence.IAccountTypeRepository;
import com.neslo.cuentasbancarias.infrastructure.model.AccountTypeDTO;
import com.neslo.cuentasbancarias.infrastructure.persistence.interfaces.IAccountTypeJPARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountTypeJPARespository implements IAccountTypeRepository {

    private final IAccountTypeJPARepository accountTypeRepository;

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
    public AccountTypeDTO findById(Long idTypeAccount) {
        return accountTypeRepository.findById(idTypeAccount).orElse(null);
    }

    @Override
    public void delete(Long idTypeAccount) {
      accountTypeRepository.deleteById(idTypeAccount);
    }
}
