package com.neslo.cuentasbancarias.infrastructure.mappers;

import com.neslo.cuentasbancarias.domain.model.AccountType;
import com.neslo.cuentasbancarias.infrastructure.model.AccountTypeDTO;

public class AccountTypeMapper {



        public static AccountType accountType(AccountTypeDTO accountTypeDTO){

            AccountType accountType=new AccountType();
            accountType.setNameType(accountType.getNameType());

            return accountType;

        }

        public static AccountTypeDTO accountTypeDTO(AccountType accountType){


            return AccountTypeDTO.builder()
                    .nameType(accountType.getNameType())
                    .build();
        }


}
