package com.bruno.mensagens_sms_api.business.converter;

import com.bruno.mensagens_sms_api.business.dto.SmsRequestDTO;
import com.bruno.mensagens_sms_api.business.dto.SmsResponseDTO;
import com.bruno.mensagens_sms_api.infrastructure.entity.SmsEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class SmsConverter {

    public SmsEntity paraEntity(SmsRequestDTO dto) {
        return SmsEntity.builder()
                .NumeroTelefone(dto.getNumeroTelefone())
                .smsStatus(dto.getStatus())
                .mensagem(dto.getMensagem())
                .dataEnvio(dto.getDataEnvio())
                .build();
    }

    public SmsResponseDTO paraDto(SmsEntity entity) {
        return SmsResponseDTO.builder()
                .numeroTelefone(entity.getNumeroTelefone())
                .mensagem(entity.getMensagem())
                .status(entity.getSmsStatus())
                .dataEnvio(entity.getDataEnvio())
                .build();
    }
}
