package com.logistica.domain.port.out;

import java.util.List;
import com.logistica.domain.model.Cliente;

public interface ClienteRepositoryPort {

    Cliente guardar(Cliente cliente);
    List<Cliente> obtenerTodos();
    Cliente obtenerPorId(Long id);
    void eliminar(Long id);
}
