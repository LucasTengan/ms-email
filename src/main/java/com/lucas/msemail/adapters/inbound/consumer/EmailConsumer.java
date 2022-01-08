package com.lucas.msemail.adapters.inbound.consumer;

import com.lucas.msemail.adapters.inbound.dto.EmailDto;
import com.lucas.msemail.application.entities.EmailModel;
import com.lucas.msemail.application.service.EmailServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailConsumer {

    private final EmailServiceImpl emailServiceImpl;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDto emailDto) {
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto, emailModel);
        emailServiceImpl.sendEmail(emailModel);
        System.out.println("Email Status: " + emailModel.getStatusEmail().toString());
    }
}
