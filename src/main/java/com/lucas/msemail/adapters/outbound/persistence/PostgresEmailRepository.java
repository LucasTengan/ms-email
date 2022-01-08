package com.lucas.msemail.adapters.outbound.persistence;

import com.lucas.msemail.application.entities.EmailModel;
import com.lucas.msemail.application.ports.EmailRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@Primary
public class PostgresEmailRepository implements EmailRepository {

    private final SpringDataPostgresEmailRepository springDataPostgresEmailRepository;

    public PostgresEmailRepository(SpringDataPostgresEmailRepository springDataPostgresEmailRepository) {
        this.springDataPostgresEmailRepository = springDataPostgresEmailRepository;
    }

    @Override
    public EmailModel sendEmail(EmailModel emailModel) {
        return springDataPostgresEmailRepository.save(emailModel);
    }

    @Override
    public Page<EmailModel> findAll(Pageable pageable) {
        return springDataPostgresEmailRepository.findAll(pageable);
    }

    @Override
    public Optional<EmailModel> findById(UUID emailId) {
        return springDataPostgresEmailRepository.findById(emailId);
    }
}
