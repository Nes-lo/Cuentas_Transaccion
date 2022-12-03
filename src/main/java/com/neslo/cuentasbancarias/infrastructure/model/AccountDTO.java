package com.neslo.cuentasbancarias.infrastructure.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="accounts")
public class AccountDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
  //  @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(name="account_number")
    private String accountNumber;
    @Column(name="id_type_account")
    private Long idAccountType;
    @Column(name="identification_customer")
    private Integer identificationCustomer;
    @Column(name="create_date_account")
    @Temporal(TemporalType.DATE)
    private Date createDateAccount;
    @Column(name="balance_account")
    private Double balanceAccount;
    @Column(name="active_account")
    private Boolean activeAccount;
    @ManyToOne
    @JoinColumn(name="id_type_accounts")
    private AccountTypeDTO accountTypeDTO;
    @ManyToOne
    @JoinColumn(name="identification_customers")
    private CustomerDTO customerDTO;
    @PrePersist
    public void generateAccount(){
        this.accountNumber=UUID.randomUUID().toString().substring(24);
    }
}
