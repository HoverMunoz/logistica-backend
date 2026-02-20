package com.logistica.domain.port.out;

import com.logistica.domain.model.Envio;
import java.util.List;
import java.util.Optional;

public interface EnvioRepositoryPort {

    Envio guardar(Envio envio);

    List<Envio> obtenerTodos();

    Optional<Envio> obtenerPorId(Long id);

    void eliminar(Long id);
}
