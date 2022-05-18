package com.bingo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PessoaNaoExiste extends Exception {
    public PessoaNaoExiste(long id) {
        super("Personagem não encontrado com esse id: " + id);
    }
}
