package com.example.EventClean.infrastructure.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EventClean.core.entities.EventModel;

public interface EventRepository extends JpaRepository<EventEntity, Long> {

  public EventModel save(EventModel eventModel);

  Optional<EventModel> findByIdentificador(String identificador);

}
