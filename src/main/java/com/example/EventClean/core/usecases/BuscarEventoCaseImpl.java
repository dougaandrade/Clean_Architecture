package com.example.EventClean.core.usecases;

import java.util.List;

import com.example.EventClean.core.entities.EventModel;
import com.example.EventClean.core.gateway.EventGateway;

public class BuscarEventoCaseImpl implements BuscarEventoCase {

  private final EventGateway eventGateway;

  public BuscarEventoCaseImpl(EventGateway eventGateway) {
    this.eventGateway = eventGateway;
  }

  @Override
  public List<EventModel> execute() {
    return eventGateway.buscarEvento();
  }

}
