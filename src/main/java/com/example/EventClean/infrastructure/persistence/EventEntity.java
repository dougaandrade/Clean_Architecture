package com.example.EventClean.infrastructure.persistence;

import java.time.LocalDateTime;

import com.example.EventClean.core.Enums.TipoEvento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "event_tb")

public class EventEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private String descricao;
  private String identificador;
  private LocalDateTime dataInicio;
  private LocalDateTime dataFim;
  private String localEvento;
  private Integer capacidade;
  @Column(name = "img_url")
  private String imgUrl;
  @Enumerated(EnumType.STRING)
  private TipoEvento tipo;

  public EventEntity(Long id, String nome, String descricao, String identificador, LocalDateTime dataInicio,
      LocalDateTime dataFim, String localEvento, Integer capacidade, String imgUrl, TipoEvento tipo) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.identificador = identificador;
    this.dataInicio = dataInicio;
    this.dataFim = dataFim;
    this.localEvento = localEvento;
    this.capacidade = capacidade;
    this.imgUrl = imgUrl;
    this.tipo = tipo;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getIdentificador() {
    return identificador;
  }

  public void setIdentificador(String identificador) {
    this.identificador = identificador;
  }

  public LocalDateTime getDataInicio() {
    return dataInicio;
  }

  public void setDataInicio(LocalDateTime dataInicio) {
    this.dataInicio = dataInicio;
  }

  public LocalDateTime getDataFim() {
    return dataFim;
  }

  public void setDataFim(LocalDateTime dataFim) {
    this.dataFim = dataFim;
  }

  public String getLocalEvento() {
    return localEvento;
  }

  public void setLocalEvento(String localEvento) {
    this.localEvento = localEvento;
  }

  public Integer getCapacidade() {
    return capacidade;
  }

  public void setCapacidade(Integer capacidade) {
    this.capacidade = capacidade;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  public TipoEvento getTipo() {
    return tipo;
  }

  public void setTipo(TipoEvento tipo) {
    this.tipo = tipo;
  }
}
