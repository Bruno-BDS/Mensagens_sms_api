package com.bruno.mensagens_sms_api.business.dto;

import com.bruno.mensagens_sms_api.infrastructure.enums.SmsStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SmsRequestDTO {

    @NotBlank(message = "o número de telefone é obrigatório")
    @Pattern( regexp = "\\d{10,11}", message = "O telefone deve conter 10 ou 11 digitos")
    private String numeroTelefone;

    @NotBlank(message = "A mensagem é obrigatório")
    private String mensagem;

    @NotNull(message = "Data e hora são obrigatórios")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")

    private LocalDateTime dataEnvio;
}
