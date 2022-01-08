package com.lucas.msemail.application.service;

import com.lucas.msemail.application.ports.EmailService;
import com.lucas.msemail.application.entities.enums.StatusEmail;
import com.lucas.msemail.application.entities.EmailModel;
import com.lucas.msemail.adapters.outbound.persistence.SpringDataPostgresEmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final SpringDataPostgresEmailRepository springDataPostgresEmailRepository;
    private final JavaMailSender emailSender;

    @Override
    public EmailModel sendEmail(EmailModel emailModel) {
        emailModel.setSendDateEmail(LocalDateTime.now());
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailFrom());
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            emailSender.send(message);

            emailModel.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e){
            emailModel.setStatusEmail(StatusEmail.ERROR);
        } finally {
            return springDataPostgresEmailRepository.save(emailModel);
        }
    }

    @Override
    public Page<EmailModel> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<EmailModel> findById(UUID emailId) {
        return Optional.empty();
    }
}
