package com.neslo.cuentasbancarias.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @NotNull
    @Min(value = 10000)
    private Integer identification;
    @NotEmpty
    @Size(min=3, max = 30)
    private String name;
    @Email
    private String email;
    private Date createAt;




}
