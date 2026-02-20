package com.logistica.infrastructure.adapter.out.persistence.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import com.logistica.domain.model.Cliente;
import com.logistica.domain.port.out.ClienteRepositoryPort;
import com.logistica.infrastructure.adapter.out.persistence.entity.ClienteEntity;
import com.logistica.infrastructure.adapter.out.persistence.repository.ClienteJpaRepository;

@Component
@RequiredArgsConstructor
public class ClienteRepositoryAdapter implements ClienteRepositoryPort {

    private final ClienteJpaRepository repository;

    @Override
    public Cliente guardar(Cliente cliente) {

        ClienteEntity entity = toEntity(cliente);
        ClienteEntity saved = repository.save(entity);
        return toDomain(saved);
    }

    @Override
    public List<Cliente> obtenerTodos() {
        return repository.findAll()
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Cliente obtenerPorId(Long id) {
        return repository.findById(id)
                .map(this::toDomain)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    private Cliente toDomain(ClienteEntity entity) {
        return new Cliente(
                entity.getId(),
                entity.getNombre(),
                entity.getEmail(),
                entity.getTelefono(),
                entity.getDireccion()
        );
    }

    private ClienteEntity toEntity(Cliente cliente) {
        return new ClienteEntity(
                cliente.getId(),
                cliente.getNombre(),
                cliente.getEmail(),
                cliente.getTelefono(),
                cliente.getDireccion()
        );
    }
}
