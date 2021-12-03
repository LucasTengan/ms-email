package com.lucas.msemail.service;

import com.lucas.msemail.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailRepository emailRepository;
}
