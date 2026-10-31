package com.bruno.mensagens_sms_api.infrastructure.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SmsStatus {
    ENVIADO,
    RECEBIDO,
    ERRO_DE_ENVIO
}
