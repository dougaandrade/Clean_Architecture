package com.example.EventClean.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EventClean.core.entities.EventModel;

public interface EventRepository extends JpaRepository<EventEntity, Long> {

  public EventModel save(EventModel eventModel);

}
