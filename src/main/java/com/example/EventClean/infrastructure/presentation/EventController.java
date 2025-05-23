package com.example.EventClean.infrastructure.presentation;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EventClean.core.entities.EventModel;
import com.example.EventClean.core.usecases.BuscarEventoCase;
import com.example.EventClean.core.usecases.CriarEventoCase;
import com.example.EventClean.infrastructure.dtos.EventDto;
import com.example.EventClean.infrastructure.mapper.EventMapper;

@RestController
@RequestMapping("api/event/")

public class EventController {

  private final CriarEventoCase criarEventoCase;
  private final BuscarEventoCase buscarEventoCase;
  private final EventMapper eventMapper;

  public EventController(CriarEventoCase criarEventoCase, EventMapper eventMapper, BuscarEventoCase buscarEventoCase) {
    this.criarEventoCase = criarEventoCase;
    this.eventMapper = eventMapper;
    this.buscarEventoCase = buscarEventoCase;
  }

  @PostMapping("/criar")
  public EventDto criarEvento(@RequestBody EventDto dto) {
    EventModel novoEvento = criarEventoCase.execute(eventMapper.toDomain(dto));
    return eventMapper.toDto(novoEvento);
  }

  @GetMapping("/buscar")
  public List<EventDto> buscarEventos() {
    return buscarEventoCase.execute().stream().map(eventMapper::toDto).toList();
  }

}
