package com.example.EventClean.infrastructure.presentation;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EventClean.core.entities.EventModel;
import com.example.EventClean.core.usecases.BuscarEventoCase;
import com.example.EventClean.core.usecases.CriarEventoCase;
import com.example.EventClean.core.usecases.FiltrarEventoCase;
import com.example.EventClean.infrastructure.config.exceptions.ErrorResponse;
import com.example.EventClean.infrastructure.dtos.EventDto;
import com.example.EventClean.infrastructure.mapper.EventMapper;
import com.example.EventClean.infrastructure.persistence.EventRepository;

@RestController
@RequestMapping("api/event/")

public class EventController {

  private final CriarEventoCase criarEventoCase;
  private final BuscarEventoCase buscarEventoCase;
  private final FiltrarEventoCase filtrarEventoCase;
  private final EventMapper eventMapper;
  private final EventRepository eventRepository;

  public EventController(CriarEventoCase criarEventoCase, EventMapper eventMapper, BuscarEventoCase buscarEventoCase,
      FiltrarEventoCase filtrarEventoCase, EventRepository eventRepository) {
    this.criarEventoCase = criarEventoCase;
    this.eventMapper = eventMapper;
    this.buscarEventoCase = buscarEventoCase;
    this.filtrarEventoCase = filtrarEventoCase;
    this.eventRepository = eventRepository;
  }

  @PostMapping("/criar")
  public ResponseEntity<EventDto> criarEvento(@RequestBody EventDto eventoDto) {
    eventRepository.findByIdentificador(eventoDto.identificador()).ifPresent(e -> {
      throw new ErrorResponse("Já existe um evento com esse identificador, verifique o identificador");
    });

    EventModel eventModel = criarEventoCase.execute(eventMapper.toDomain(eventoDto));
    return ResponseEntity.ok(eventMapper.toDto(eventModel));

  }

  @GetMapping("/listar")
  public List<EventDto> buscarEventos() {
    return buscarEventoCase.execute().stream().map(eventMapper::toDto).toList();
  }

  @GetMapping("/filtrar/{id}")
  public ResponseEntity<EventDto> filtrarEventos(@PathVariable Long id) {
    return filtrarEventoCase.execute().stream().map(eventMapper::toDto).filter(e -> e.id().equals(id))
        .findFirst().map(ResponseEntity::ok)
        .orElseThrow(() -> new ErrorResponse("Evento não encontrado, verifique o id"));

  }

}
