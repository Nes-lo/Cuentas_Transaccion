package com.neslo.cuentasbancarias.domain.model;

import com.neslo.cuentasbancarias.infrastructure.model.AccountTypeDTO;
import com.neslo.cuentasbancarias.infrastructure.model.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {


    private String accountNumber;
    private Long idAccountType;
    private Integer identificationCustomer;
    private Date createDateAccount;
    @NotNull
    @Min(value = 0)
    private Double balanceAccount;
    private Boolean activeAccount;
    private AccountType accountType;
    private Customer customer;
}
