package com.bruno.mensagens_sms_api.business.service;

import com.bruno.mensagens_sms_api.business.converter.SmsConverter;
import com.bruno.mensagens_sms_api.business.dto.SmsRequestDTO;
import com.bruno.mensagens_sms_api.business.dto.SmsResponseDTO;
import com.bruno.mensagens_sms_api.infrastructure.entity.SmsEntity;
import com.bruno.mensagens_sms_api.infrastructure.enums.SmsStatus;
import com.bruno.mensagens_sms_api.infrastructure.exceptions.SmsNaoEncontradoException;
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

    public SmsResponseDTO enviaMensagem(SmsRequestDTO dto) {

        if (dto == null) {
            throw new IllegalArgumentException(
                    "Os dados do SMS são obrigatórios"
            );
        }

        SmsEntity entity = converter.paraEntity(dto);

        entity.setSmsStatus(SmsStatus.ENVIADO)
        ;
        SmsEntity mensagemSalva = repository.save(entity);

        return converter.paraDto(mensagemSalva);

    }

    public SmsResponseDTO atualizarStatus(Long id, SmsStatus status) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }

        if (status == null) {
            throw new IllegalArgumentException("Status é obrigatório");
        }

        SmsEntity mensagem = repository.findById(id)
                .orElseThrow(() ->
                        new SmsNaoEncontradoException("Mensagem SMS não encontrada"));

        mensagem.setSmsStatus(status);
        SmsEntity mensagemAtualizada = repository.save(mensagem);
        return converter.paraDto(mensagemAtualizada);
    }

    public List<SmsResponseDTO> gerarRelatorio(SmsStatus status) {

        if (status == null) {
            throw new IllegalArgumentException("Status é obrigatório");
        }
        LocalDateTime dataAgora = LocalDateTime.now();
        LocalDateTime dataMenos24Horas = dataAgora.minusDays(1);

        return repository
                .findBySmsStatusAndDataEnvioBetween(status, dataMenos24Horas, dataAgora)
                .stream()
                .map(converter::paraDto)
                .toList();

    }
}
