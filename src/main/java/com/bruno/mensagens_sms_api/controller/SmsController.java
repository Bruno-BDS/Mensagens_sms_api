package com.bruno.mensagens_sms_api.controller;

import com.bruno.mensagens_sms_api.business.converter.SmsConverter;
import com.bruno.mensagens_sms_api.business.dto.SmsRequestDTO;
import com.bruno.mensagens_sms_api.business.dto.SmsResponseDTO;
import com.bruno.mensagens_sms_api.business.service.SmsService;
import com.bruno.mensagens_sms_api.infrastructure.enums.SmsStatus;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sms")
@RequiredArgsConstructor
public class SmsController {

    public final SmsService service;
    public final SmsConverter smsConverter;

    @PostMapping
    public ResponseEntity<SmsResponseDTO> enviaMensagem(@Valid @RequestBody SmsRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.enviaMensagem(dto));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<SmsResponseDTO> atualizarStatus(@PathVariable Long id, @RequestParam SmsStatus status) {
        return ResponseEntity.ok(service.atualizarStatus(id, status));
    }

    @GetMapping("/relatorio")
    public ResponseEntity<List<SmsResponseDTO>> gerarRelatorio(@RequestParam SmsStatus status) {
        return ResponseEntity.ok(service.gerarRelatorio(status));
    }
}
