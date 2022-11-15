package com.neslo.cuentasbancarias.infrastructure.persistence;

import com.neslo.cuentasbancarias.domain.model.Cliente;
import com.neslo.cuentasbancarias.domain.persistence.IClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteJPARepository implements IClienteRepository {
    private final IClienteJPARepository clienteRepository;

    public ClienteJPARepository(IClienteJPARepository clienteRepository) {
       this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> findAll() {
        return null;
    }

    @Override
    public void save(Cliente cliente) {

    }
}
