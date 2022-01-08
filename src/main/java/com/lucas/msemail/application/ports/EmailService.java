package com.lucas.msemail.application.ports;

import com.lucas.msemail.application.entities.EmailModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface EmailService {

    EmailModel sendEmail(EmailModel emailModel);
    Page<EmailModel> findAll(Pageable pageable);
    Optional<EmailModel> findById(UUID emailId);
}
