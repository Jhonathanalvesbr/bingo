package com.bingo.repositorio;

import com.bingo.entidade.Configuracoes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ConfiguracoesRepositorio extends JpaRepository<Configuracoes, Long> {

    Optional<Configuracoes> findByName(String name);

}
