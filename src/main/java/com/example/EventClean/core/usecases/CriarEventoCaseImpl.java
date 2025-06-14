package com.example.EventClean.core.usecases;

import com.example.EventClean.core.entities.EventModel;
import com.example.EventClean.core.gateway.EventGateway;

public class CriarEventoCaseImpl implements CriarEventoCase {

  private final EventGateway eventGateway;

  public CriarEventoCaseImpl(EventGateway eventGateway) {
    this.eventGateway = eventGateway;
  }

  @Override
  public EventModel execute(EventModel eventModel) {
    return eventGateway.criarEvento(eventModel);
  }

}
