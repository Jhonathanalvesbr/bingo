package com.bingo.mapear;

import com.bingo.dto.PessoaDTO;
import com.bingo.entidade.Pessoa;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-16T16:32:22-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
public class PessoaMapearImpl implements PessoaMapear {

    @Override
    public Pessoa toModel(PessoaDTO pessoaDTO) {
        if ( pessoaDTO == null ) {
            return null;
        }

        Pessoa pessoa = new Pessoa();

        pessoa.setId( pessoaDTO.getId() );
        pessoa.setName( pessoaDTO.getName() );
        pessoa.setPagamento( pessoaDTO.getPagamento() );
        pessoa.setValor( pessoaDTO.getValor() );
        pessoa.setStatusPagamento( pessoaDTO.isStatusPagamento() );
        pessoa.setJogos( pessoaDTO.getJogos() );

        return pessoa;
    }

    @Override
    public PessoaDTO toDTO(Pessoa pessoa) {
        if ( pessoa == null ) {
            return null;
        }

        PessoaDTO pessoaDTO = new PessoaDTO();

        pessoaDTO.setId( pessoa.getId() );
        pessoaDTO.setName( pessoa.getName() );
        pessoaDTO.setPagamento( pessoa.getPagamento() );
        pessoaDTO.setValor( pessoa.getValor() );
        pessoaDTO.setStatusPagamento( pessoa.isStatusPagamento() );
        pessoaDTO.setJogos( pessoa.getJogos() );

        return pessoaDTO;
    }
}
