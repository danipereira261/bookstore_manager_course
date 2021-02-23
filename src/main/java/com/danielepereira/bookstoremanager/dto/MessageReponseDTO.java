package com.danielepereira.bookstoremanager.dto;

import lombok.Builder;
import lombok.Data;

import java.security.cert.CertPathBuilder;

@Data
@Builder

public class MessageReponseDTO {
    private String message;

}

