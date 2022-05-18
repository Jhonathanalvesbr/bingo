package com.bingo.repositorio;

import com.bingo.entidade.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PessoaRepositorio extends JpaRepository<Pessoa, Long> {

    Optional<Pessoa> findByName(String name);

}
