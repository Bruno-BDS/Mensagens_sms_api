package com.bruno.mensagens_sms_api.business.service;

import com.bruno.mensagens_sms_api.business.converter.SmsConverter;
import com.bruno.mensagens_sms_api.business.dto.SmsRequestDTO;
import com.bruno.mensagens_sms_api.business.dto.SmsResponseDTO;
import com.bruno.mensagens_sms_api.infrastructure.entity.SmsEntity;
import com.bruno.mensagens_sms_api.infrastructure.enums.SmsStatus;
import com.bruno.mensagens_sms_api.infrastructure.repository.SmsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SmsService {
    private final SmsRepository repository;
    private final SmsConverter converter;

    public SmsResponseDTO enviaMensagem(SmsRequestDTO dto){

        SmsEntity entity = converter.paraEntity(dto);

        SmsEntity mensagemSalva = repository.save(entity);

        return converter.paraDto(mensagemSalva);

    }
    public SmsResponseDTO atualizarStatus(Long id, SmsStatus status) {
        SmsEntity mensagem = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Mensagem SMS não encontrada"));

        if (status == null) {
            throw new IllegalArgumentException("Status é obrigatório");
        }

        mensagem.setSmsStatus(status);
        SmsEntity mensagemAtualizada = repository.save(mensagem);
        return converter.paraDto(mensagemAtualizada);
    }

    public List<SmsResponseDTO> gerarRelatorio(SmsStatus status) {
        LocalDateTime dataAgora = LocalDateTime.now();
        LocalDateTime dataMenos24Horas = dataAgora.minusDays(1);

        return repository
                .findByStatusAndDataEnvioBetween(status, dataAgora, dataMenos24Horas)
                .stream()
                .map(converter::paraDto)
                .toList();

    }
}
