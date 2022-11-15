package com.neslo.cuentasbancarias.infrastructure.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customers")
public class CustomerDTO implements Serializable {
    @Id
    @NotEmpty
    private Integer identification;
    @NotEmpty
    private String name;
    private String email;
    @Column(name="create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;
}
