package com.example.EventClean.core.usecases;

import java.util.List;

import com.example.EventClean.core.entities.EventModel;

public interface BuscarEventoCase {

  public List<EventModel> execute();

}
