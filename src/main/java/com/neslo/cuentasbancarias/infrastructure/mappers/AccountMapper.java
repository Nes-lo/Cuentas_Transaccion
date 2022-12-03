package com.neslo.cuentasbancarias.infrastructure.mappers;

import com.neslo.cuentasbancarias.domain.model.Account;
import com.neslo.cuentasbancarias.infrastructure.model.AccountDTO;

import java.util.Date;


public class AccountMapper {

    public static Account account(AccountDTO accountDTO){

        Account account=new Account();
        account.setAccountNumber(accountDTO.getAccountNumber());
        account.setIdAccountType(accountDTO.getIdAccountType());
        account.setIdentificationCustomer(accountDTO.getIdentificationCustomer());
        account.setCreateDateAccount(accountDTO.getCreateDateAccount());
        account.setBalanceAccount(accountDTO.getBalanceAccount());
        account.setActiveAccount(accountDTO.getActiveAccount());
       // account.setCustomer(CustomerMapper.customer(accountDTO.getCustomerDTO()));
       // account.setAccountType(AccountTypeMapper.accountType(accountDTO.getAccountTypeDTO()));


        return account;

    }

    public  static Account accountId(Integer identification){
        Account account=new Account();
        account.setIdentificationCustomer(identification);
        return account;
    }

    public static AccountDTO accountDTO(Account account){


        return AccountDTO.builder()
                .idAccountType(account.getIdAccountType())
                .identificationCustomer(account.getIdentificationCustomer())
                .balanceAccount(account.getBalanceAccount())
                .activeAccount(account.getActiveAccount())
                .createDateAccount(new Date())
               // .customerDTO(CustomerMapper.customerDTO(account.getCustomer()))
                //.accountTypeDTO(AccountTypeMapper.accountTypeDTO(account.getAccountType()))
                .build();
    }
}
