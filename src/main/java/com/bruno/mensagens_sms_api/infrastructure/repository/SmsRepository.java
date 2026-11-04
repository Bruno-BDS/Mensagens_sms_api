package com.bruno.mensagens_sms_api.infrastructure.repository;

import com.bruno.mensagens_sms_api.infrastructure.entity.SmsEntity;
import com.bruno.mensagens_sms_api.infrastructure.enums.SmsStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SmsRepository extends JpaRepository<SmsEntity, Long> {

    List<SmsEntity> findBySmsStatusAndDataEnvioBetween(SmsStatus smsStatus, LocalDateTime inicio, LocalDateTime fim );
}
