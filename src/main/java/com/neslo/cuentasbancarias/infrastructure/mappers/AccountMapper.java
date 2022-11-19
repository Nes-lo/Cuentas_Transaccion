package com.neslo.cuentasbancarias.infrastructure.mappers;

import com.neslo.cuentasbancarias.domain.model.Account;
import com.neslo.cuentasbancarias.infrastructure.model.AccountDTO;


public class AccountMapper {

    public static Account account(AccountDTO accountDTO){

        Account account=new Account();
        account.setAccountNumber(accountDTO.getAccountNumber());
        account.setIdTypeAccount(accountDTO.getIdTypeAccount());
        account.setIdentificationCustomer(accountDTO.getIdentificationCustomer());
        account.setCreateDateAccount(accountDTO.getCreateDateAccount());
        account.setBalanceAccount(accountDTO.getBalanceAccount());
        account.setActiveAccount(accountDTO.getActiveAccount());

        return account;

    }

    public static AccountDTO accountDTO(Account account){


        return AccountDTO.builder()
                .idTypeAccount(account.getIdTypeAccount())
                .identificationCustomer(account.getIdentificationCustomer())
                .balanceAccount(account.getBalanceAccount())
                .activeAccount(account.getActiveAccount())
                .build();
    }
}
