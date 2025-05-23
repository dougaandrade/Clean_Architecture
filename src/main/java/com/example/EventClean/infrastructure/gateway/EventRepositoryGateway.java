package com.example.EventClean.infrastructure.gateway;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.EventClean.core.entities.EventModel;
import com.example.EventClean.core.gateway.EventGateway;
import com.example.EventClean.infrastructure.mapper.EventoEntityMapper;
import com.example.EventClean.infrastructure.persistence.EventEntity;
import com.example.EventClean.infrastructure.persistence.EventRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EventRepositoryGateway implements EventGateway {

  private final EventRepository eventRepository;
  private final EventoEntityMapper eventoEntityMapper;

  @Override
  public EventModel criarEvento(EventModel eventModel) {
    EventEntity entity = eventoEntityMapper.toEntity(eventModel);
    EventEntity novoEvento = eventRepository.save(entity);
    return eventoEntityMapper.toDomain(novoEvento);
  }

  @Override
  public List<EventModel> buscarEvento() {
    return eventRepository.findAll().stream().map(eventoEntityMapper::toDomain).toList();
  }

}