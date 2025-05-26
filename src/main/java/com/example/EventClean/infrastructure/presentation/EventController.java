package com.example.EventClean.infrastructure.presentation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.example.EventClean.infrastructure.dtos.EventDto;
import com.example.EventClean.infrastructure.mapper.EventMapper;

@RestController
@RequestMapping("api/event/")

public class EventController {

  private final CriarEventoCase criarEventoCase;
  private final BuscarEventoCase buscarEventoCase;
  private final FiltrarEventoCase filtrarEventoCase;
  private final EventMapper eventMapper;

  public EventController(CriarEventoCase criarEventoCase, EventMapper eventMapper, BuscarEventoCase buscarEventoCase,
      FiltrarEventoCase filtrarEventoCase) {
    this.criarEventoCase = criarEventoCase;
    this.eventMapper = eventMapper;
    this.buscarEventoCase = buscarEventoCase;
    this.filtrarEventoCase = filtrarEventoCase;
  }

  @PostMapping("/criar")
  public ResponseEntity<Map<String, Object>> criarEvento(@RequestBody EventDto eventoDto) {
    EventModel novoEvento = criarEventoCase.execute(eventMapper.toDomain(eventoDto));
    Map<String, Object> response = new HashMap<>();
    response.put("Mensagem: ", "Evento cadastrado com sucesso no nosso banco de dados");
    response.put("Dados do evento: ", eventMapper.toDto(novoEvento));
    return ResponseEntity.ok(response);
  }

  @GetMapping("/buscar")
  public List<EventDto> buscarEventos() {
    return buscarEventoCase.execute().stream().map(eventMapper::toDto).toList();
  }

  @GetMapping("/filtrar/{id}")
  public ResponseEntity<EventDto> filtrarEventos(@PathVariable Long id) {
    return filtrarEventoCase.execute().stream().map(eventMapper::toDto).filter(e -> e.id().equals(id))
        .findFirst().map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

}
