package com.example.EventClean.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.example.EventClean.core.entities.EventModel;
import com.example.EventClean.infrastructure.dtos.EventDto;

@Component
public class EventMapper {

  public EventDto toDto(EventModel eventModel) {
    return new EventDto(
        eventModel.id(),
        eventModel.nome(),
        eventModel.descricao(),
        eventModel.identificador(),
        eventModel.dataInicio(),
        eventModel.dataFim(),
        eventModel.localEvento(),
        eventModel.capacidade(),
        eventModel.imgUrl(),
        eventModel.organizador(),
        eventModel.tipo());
  }

  public EventModel toDomain(EventDto eventDto) {
    return new EventModel(
        eventDto.id(),
        eventDto.nome(),
        eventDto.descricao(),
        eventDto.identificador(),
        eventDto.dataInicio(),
        eventDto.dataFim(),
        eventDto.localEvento(),
        eventDto.capacidade(),
        eventDto.imgUrl(),
        eventDto.organizador(),
        eventDto.tipo());
  }
}
