package com.example.EventClean.core.entities;

import java.time.LocalDateTime;

import com.example.EventClean.core.Enums.TipoEvento;

public record EventModel(Long id, String nome, String descricao, LocalDateTime inicio,
                LocalDateTime fim, String indetificador, String local, String organizador, TipoEvento tipo) {

}
