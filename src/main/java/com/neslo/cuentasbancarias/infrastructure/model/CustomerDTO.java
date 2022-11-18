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
public class CustomerDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    private Integer identification;
    private String name;
    private String email;
    @Column(name="create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @PrePersist
    public void prePersist() {
        createAt=new Date();
    }
}
