package com.logistica.infrastructure.adapter.out.persistence.adapter;

import com.logistica.domain.model.Envio;
import com.logistica.domain.port.out.EnvioRepositoryPort;
import com.logistica.infrastructure.adapter.out.persistence.entity.EnvioEntity;
import com.logistica.infrastructure.adapter.out.persistence.repository.EnvioJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EnvioRepositoryAdapter implements EnvioRepositoryPort {

    private final EnvioJpaRepository repository;

    public EnvioRepositoryAdapter(EnvioJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Envio guardar(Envio envio) {
        EnvioEntity entity = EnvioEntity.fromDomain(envio);
        EnvioEntity saved = repository.save(entity);
        return saved.toDomain();
    }

    @Override
    public List<Envio> obtenerTodos() {
        return repository.findAll()
                .stream()
                .map(EnvioEntity::toDomain)
                .toList();
    }

    @Override
    public Optional<Envio> obtenerPorId(Long id) {
        return repository.findById(id)
                .map(EnvioEntity::toDomain);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}