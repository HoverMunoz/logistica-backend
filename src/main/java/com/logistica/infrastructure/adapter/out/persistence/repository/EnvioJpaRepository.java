package com.logistica.infrastructure.adapter.out.persistence.repository;

import com.logistica.infrastructure.adapter.out.persistence.entity.EnvioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnvioJpaRepository extends JpaRepository<EnvioEntity, Long> {
}


