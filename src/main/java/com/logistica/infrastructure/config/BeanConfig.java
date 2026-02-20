package com.logistica.infrastructure.config;

import com.logistica.application.service.EnvioService;
import com.logistica.domain.port.out.EnvioRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public EnvioService envioService(EnvioRepositoryPort repository) {
        return new EnvioService(repository);
    }
}
