package com.bingo.bd;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Pessoa extends JpaRepository<com.bingo.entidade.Pessoa, Long> {

}
