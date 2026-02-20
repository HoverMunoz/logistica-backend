package com.logistica.infrastructure.adapter.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.logistica.infrastructure.adapter.out.persistence.entity.ClienteEntity;

public interface ClienteJpaRepository
        extends JpaRepository<ClienteEntity, Long> {
}
