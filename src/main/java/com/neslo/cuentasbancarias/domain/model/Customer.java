package com.neslo.cuentasbancarias.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private Integer identification;
    private String name;
    private String email;
    private Date createAt;




}
