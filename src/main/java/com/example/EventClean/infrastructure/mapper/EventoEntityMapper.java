package com.example.EventClean.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.example.EventClean.core.entities.EventModel;
import com.example.EventClean.infrastructure.persistence.EventEntity;

@Component
public class EventoEntityMapper {

  public EventEntity toEntity(EventModel eventModel) {
    return new EventEntity(
        eventModel.id(),
        eventModel.nome(),
        eventModel.descricao(),
        eventModel.identificador(),
        eventModel.dataInicio(),
        eventModel.dataFim(),
        eventModel.localEvento(),
        eventModel.capacidade(),
        eventModel.imgUrl(),
        eventModel.tipo());
  }

  public EventModel toDomain(EventEntity eventEntity) {
    return new EventModel(
        eventEntity.getId(),
        eventEntity.getNome(),
        eventEntity.getDescricao(),
        eventEntity.getIdentificador(),
        eventEntity.getDataInicio(),
        eventEntity.getDataFim(),
        eventEntity.getLocalEvento(),
        eventEntity.getCapacidade(),
        eventEntity.getImgUrl(),
        eventEntity.getTipo());
  }
}