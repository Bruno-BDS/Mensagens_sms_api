package com.bruno.mensagens_sms_api.business.dto;

import com.bruno.mensagens_sms_api.infrastructure.enums.SmsStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SmsRequestDTO {

    @NotBlank(message = "o número de telefone é obrigatório")
    private String numeroTelefone;

    private String mensagem;

    @NotNull(message = "O status é obrigatório")
    private SmsStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    @NotBlank(message = "Data e hora são obrigatórios")
    private LocalDateTime dataEnvio;
}
