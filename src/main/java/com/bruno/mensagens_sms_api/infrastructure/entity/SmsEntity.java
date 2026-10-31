package com.bruno.mensagens_sms_api.infrastructure.entity;

import com.bruno.mensagens_sms_api.infrastructure.enums.SmsStatus;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "Mensagens_SMS_Status")
public class SmsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NUMERO_TELEFONE", nullable = false)
    private String NumeroTelefone;

    @Column(name = "Status_SMS", nullable = false)
    @Enumerated(EnumType.STRING)
    private SmsStatus smsStatus;

    @Column(name = "DATA_ENVIO", nullable = false)
    private LocalDateTime dataEnvio;
}
