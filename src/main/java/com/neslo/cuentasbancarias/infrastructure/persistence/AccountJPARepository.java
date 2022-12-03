package com.neslo.cuentasbancarias.infrastructure.persistence;

import com.neslo.cuentasbancarias.domain.persistence.IAccountRepository;
import com.neslo.cuentasbancarias.infrastructure.model.AccountDTO;
import com.neslo.cuentasbancarias.infrastructure.persistence.interfaces.IAccountJPARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountJPARepository implements IAccountRepository {

    private final IAccountJPARepository accountRepository;


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
    public AccountDTO findById(String accountNumber) {
        return accountRepository.findById(accountNumber).orElse(null);
    }
    public List<AccountDTO> findByIdentification(Integer identification){
       return accountRepository.findByIdentificationCustomer(identification);


    }
}
