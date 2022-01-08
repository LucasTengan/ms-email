package com.lucas.msemail.adapters.outbound.persistence;

import com.lucas.msemail.application.entities.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataPostgresEmailRepository extends JpaRepository<EmailModel, UUID> {
}
