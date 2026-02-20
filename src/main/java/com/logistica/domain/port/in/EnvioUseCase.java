package com.logistica.domain.port.in;

import java.util.List;
import com.logistica.domain.model.Envio;

public interface EnvioUseCase {

    Envio crear(Envio envio);
    List<Envio> listar();
    Envio obtener(Long id);
    void eliminar(Long id);
}
