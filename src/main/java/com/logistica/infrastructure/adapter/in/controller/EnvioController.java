package com.logistica.infrastructure.adapter.in.controller;

import com.logistica.application.service.EnvioService;
import com.logistica.domain.model.Envio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/envios")
@CrossOrigin("*")
public class EnvioController {

    private final EnvioService service;

    public EnvioController(EnvioService service) {
        this.service = service;
    }

    @PostMapping
    public Envio crear(@RequestBody Envio envio) {
        return service.crear(envio);
    }

    @GetMapping
    public List<Envio> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Envio obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}