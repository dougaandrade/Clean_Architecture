package com.example.EventClean.core.gateway;

import java.util.List;

import com.example.EventClean.core.entities.EventModel;

public interface EventGateway {

  EventModel criarEvento(EventModel eventModel);

  List<EventModel> buscarEvento();
}
