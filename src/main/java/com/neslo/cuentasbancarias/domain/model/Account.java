package com.neslo.cuentasbancarias.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {


    private UUID accountNumber;
    private Long idTypeAccount;
    private Integer identificationCustomer;
    private Date createDateAccount;
    @NotNull
    @Min(value = 0)
    private Double balanceAccount;
    private Boolean activeAccount;
}
