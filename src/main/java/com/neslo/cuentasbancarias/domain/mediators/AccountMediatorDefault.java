package com.neslo.cuentasbancarias.domain.mediators;

import com.neslo.cuentasbancarias.domain.mediators.interfaces.IAccountMediator;
import com.neslo.cuentasbancarias.domain.persistence.IAccountRepository;
import com.neslo.cuentasbancarias.infrastructure.model.AccountDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Component
public class AccountMediatorDefault implements IAccountMediator {
    private final IAccountRepository iAccountRepository;

    @Override
    public List<AccountDTO> findAll() {
        return iAccountRepository.findAll();
    }

    @Override
    public AccountDTO save(AccountDTO accountDTO) {
        return iAccountRepository.save(accountDTO);
    }

    @Override
    public AccountDTO findById(UUID accountNumber) {
        return iAccountRepository.findById(accountNumber);
    }
}
