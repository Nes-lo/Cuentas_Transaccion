package com.neslo.cuentasbancarias.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountType {

    private Byte idTypeAccount;
    @NotEmpty
    @Size(min = 10, max = 30)
    private String nameType;
}
