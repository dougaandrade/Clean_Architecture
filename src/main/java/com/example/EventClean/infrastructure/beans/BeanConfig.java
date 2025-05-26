package com.example.EventClean.infrastructure.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.EventClean.core.gateway.EventGateway;
import com.example.EventClean.core.usecases.BuscarEventoCase;
import com.example.EventClean.core.usecases.BuscarEventoCaseImpl;
import com.example.EventClean.core.usecases.CriarEventoCase;
import com.example.EventClean.core.usecases.CriarEventoCaseImpl;
import com.example.EventClean.core.usecases.FiltrarEventoCase;
import com.example.EventClean.core.usecases.FiltrarEventoCaseImpl;

@Configuration
public class BeanConfig {

  @Bean
  public CriarEventoCase criarEventoCase(EventGateway eventGateway) {
    return new CriarEventoCaseImpl(eventGateway);
  }

  @Bean
  public BuscarEventoCase buscarEventoCase(EventGateway eventGateway) {
    return new BuscarEventoCaseImpl(eventGateway);
  }

  @Bean
  public FiltrarEventoCase filtrarEventoCase(EventGateway eventGateway) {
    return new FiltrarEventoCaseImpl(eventGateway);
  }

}
