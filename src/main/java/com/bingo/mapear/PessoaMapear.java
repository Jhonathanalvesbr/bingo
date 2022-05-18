package com.bingo.mapear;

import com.bingo.dto.PessoaDTO;
import com.bingo.entidade.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PessoaMapear {

    PessoaMapear INSTANCE = Mappers.getMapper(PessoaMapear.class);

    Pessoa toModel(PessoaDTO pessoaDTO);

    PessoaDTO toDTO(Pessoa pessoa);
}
