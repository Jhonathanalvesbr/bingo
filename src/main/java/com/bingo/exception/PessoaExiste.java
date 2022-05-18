package com.bingo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class PessoaExiste extends Exception {
        public PessoaExiste(String name) {

            super("Personagem já existe com esse nome: " + name);
        }
}


