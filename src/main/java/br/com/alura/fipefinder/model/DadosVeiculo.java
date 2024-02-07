package br.com.alura.fipefinder.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosVeiculo(
    @JsonAlias("Marca") String marca,
    @JsonAlias("Modelo") String modelo,
    @JsonAlias("AnoModelo") String ano,
    @JsonAlias("Combustivel") String tipoCombustivel,
    @JsonAlias("Valor") String valor
) {
    
}
