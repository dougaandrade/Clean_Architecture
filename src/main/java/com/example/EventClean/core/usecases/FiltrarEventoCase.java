package com.example.EventClean.core.usecases;

import java.util.List;

import com.example.EventClean.core.entities.EventModel;

public interface FiltrarEventoCase {

  public List<EventModel> execute();

}
