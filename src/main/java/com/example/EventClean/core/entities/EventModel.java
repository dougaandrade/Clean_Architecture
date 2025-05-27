package com.example.EventClean.core.entities;

import java.time.LocalDateTime;

import com.example.EventClean.core.Enums.TipoEvento;

public record EventModel(
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
