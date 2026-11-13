package com.bruno.mensagens_sms_api.infrastructure.exceptions;

public class SmsNaoEncontradoException extends RuntimeException {
    public SmsNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
