package com.bingo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfiguracoesDTO {
    private long id;
    private LocalDate data;
    private int quantidadeJogos;
    private String name;
    private double valor;
    private int valorFixo;
    private int jogos;
}
