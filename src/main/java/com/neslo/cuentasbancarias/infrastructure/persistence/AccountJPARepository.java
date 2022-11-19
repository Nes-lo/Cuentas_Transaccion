package com.neslo.cuentasbancarias.infrastructure.persistence;

import com.neslo.cuentasbancarias.domain.persistence.IAccountRepository;
import com.neslo.cuentasbancarias.infrastructure.model.AccountDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AccountJPARepository implements IAccountRepository {

    private final IAccountRepository accountRepository;


    @Override
    public List<AccountDTO> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public AccountDTO save(AccountDTO accountDTO) {
        accountRepository.save(accountDTO);
        return accountDTO;
    }

    @Override
    public AccountDTO findById(UUID accountNumber) {
        return accountRepository.findById(accountNumber);
    }
}
