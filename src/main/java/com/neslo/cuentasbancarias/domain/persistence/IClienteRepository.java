package com.neslo.cuentasbancarias.domain.persistence;

import com.neslo.cuentasbancarias.domain.model.Cliente;

import java.util.List;

public interface IClienteRepository {
    public List<Cliente> findAll();

    public void save(Cliente cliente);
}
