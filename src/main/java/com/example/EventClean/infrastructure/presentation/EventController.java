package com.example.EventClean.infrastructure.presentation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EventClean.core.entities.EventModel;
import com.example.EventClean.core.usecases.CriarEventoCase;
import com.example.EventClean.infrastructure.dtos.EventDto;
import com.example.EventClean.infrastructure.mapper.EventMapper;

@RestController
@RequestMapping("api/event/")

public class EventController {

  private final CriarEventoCase criarEventoCase;
  private final EventMapper eventMapper;

  public EventController(CriarEventoCase criarEventoCase, EventMapper eventMapper) {
    this.criarEventoCase = criarEventoCase;
    this.eventMapper = eventMapper;
  }

  @PostMapping("/criar")
  public EventDto criarEvento(@RequestBody EventDto dto) {
    EventModel novoEvento = criarEventoCase.execute(eventMapper.toDomain(dto));
    return eventMapper.toDto(novoEvento);
  }

  @GetMapping("/buscar")
  public EventDto buscarEvento(@RequestBody EventDto dto) {
    EventModel novoEvento = criarEventoCase.execute(eventMapper.toDomain(dto));
    return eventMapper.toDto(novoEvento);
  }

}
