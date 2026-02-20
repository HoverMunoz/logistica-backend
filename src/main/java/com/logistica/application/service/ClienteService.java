package com.logistica.application.service;

import com.logistica.domain.model.Cliente;
import com.logistica.domain.port.in.ClienteUseCase;
import com.logistica.domain.port.out.ClienteRepositoryPort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

import com.logistica.domain.model.Cliente;
import com.logistica.domain.port.out.ClienteRepositoryPort;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepositoryPort repository;

    public Cliente crear(Cliente cliente) {
        return repository.guardar(cliente);
    }

    public List<Cliente> listar() {
        return repository.obtenerTodos();
    }

    public Cliente obtener(Long id) {
        return repository.obtenerPorId(id);
    }

    public Cliente actualizar(Long id, Cliente cliente) {
        Cliente existente = repository.obtenerPorId(id);

        existente.setNombre(cliente.getNombre());
        existente.setEmail(cliente.getEmail());
        existente.setTelefono(cliente.getTelefono());
        existente.setDireccion(cliente.getDireccion());

        return repository.guardar(existente);
    }

    public void eliminar(Long id) {
        repository.eliminar(id);
    }
}
