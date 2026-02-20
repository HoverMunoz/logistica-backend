package com.logistica.domain.port.in;

import com.logistica.domain.model.Cliente;
import java.util.List;

public interface ClienteUseCase {

    Cliente crearCliente(Cliente cliente);
    List<Cliente> listarClientes();
}
