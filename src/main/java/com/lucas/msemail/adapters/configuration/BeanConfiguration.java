package com.lucas.msemail.adapters.configuration;

import com.lucas.msemail.MsEmailApplication;
import com.lucas.msemail.adapters.outbound.persistence.SpringDataPostgresEmailRepository;
import com.lucas.msemail.application.service.EmailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
@ComponentScan(basePackageClasses = MsEmailApplication.class)
public class BeanConfiguration {

    @Bean
    EmailServiceImpl emailServiceImpl(SpringDataPostgresEmailRepository repository, JavaMailSender javaMailSender) {
        return new EmailServiceImpl(repository, javaMailSender);
    }
}
