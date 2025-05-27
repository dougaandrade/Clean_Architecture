package com.example.EventClean.infrastructure.config.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorResponse extends RuntimeException {

  private final String messagem;

  public String getMessagem() {
    return messagem;
  }

}
