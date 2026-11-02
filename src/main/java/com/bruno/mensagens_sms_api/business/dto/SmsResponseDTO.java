package com.bruno.mensagens_sms_api.business.dto;

import com.bruno.mensagens_sms_api.infrastructure.enums.SmsStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SmsResponseDTO {

    private Long id;
    private String numeroTelefone;
    private String mensagem;
    private SmsStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataEnvio;
}
