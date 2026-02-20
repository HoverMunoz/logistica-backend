package com.logistica.application.service;

import com.logistica.domain.model.Envio;
import com.logistica.domain.port.out.EnvioRepositoryPort;

import java.util.List;

public class EnvioService {

    private final EnvioRepositoryPort repository;

    public EnvioService(EnvioRepositoryPort repository) {
        this.repository = repository;
    }

    // ✅ CREAR
    public Envio crear(Envio envio) {
        return repository.guardar(envio);
    }

    // ✅ LISTAR
    public List<Envio> listar() {
        return repository.obtenerTodos();
    }

    // ✅ OBTENER
    public Envio obtener(Long id) {
        return repository.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Envio no encontrado"));
    }

    // ✅ ELIMINAR
    public void eliminar(Long id) {
        repository.eliminar(id);
    }
}