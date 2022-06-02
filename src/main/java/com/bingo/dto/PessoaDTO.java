package com.bingo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {
    private long id;

    @NotNull
    @Size(min = 1, max = 200)
    private String name;
    private String pagamento;
    private double valor;
    private boolean status_Pagamento;
    private String jogos;
}
