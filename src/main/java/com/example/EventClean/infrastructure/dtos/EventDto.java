package com.example.EventClean.infrastructure.dtos;

import java.time.LocalDateTime;

import com.example.EventClean.core.Enums.TipoEvento;

public record EventDto(
        Long id,
        String nome,
        String descricao,
        String identificador,
        LocalDateTime dataInicio,
        LocalDateTime dataFim,
        String localEvento,
        Integer capacidade,
        String imgUrl,
        String organizador,
        TipoEvento tipo) {
}
