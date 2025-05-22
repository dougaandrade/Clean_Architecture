package com.example.EventClean.core.usecases;

import com.example.EventClean.core.entities.EventModel;

public interface BucarEventoCase {

  public EventModel execute(EventModel evento);
}
