package com.bingo.mapear;

import com.bingo.dto.ConfiguracoesDTO;
import com.bingo.entidade.Configuracoes;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-16T16:32:22-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
public class ConfiguracoesMapearImpl implements ConfiguracoesMapear {

    @Override
    public Configuracoes toModel(ConfiguracoesDTO configuracoesDTO) {
        if ( configuracoesDTO == null ) {
            return null;
        }

        Configuracoes configuracoes = new Configuracoes();

        configuracoes.setId( configuracoesDTO.getId() );
        configuracoes.setData( configuracoesDTO.getData() );
        configuracoes.setQuantidadeJogos( configuracoesDTO.getQuantidadeJogos() );
        configuracoes.setName( configuracoesDTO.getName() );
        configuracoes.setValor( configuracoesDTO.getValor() );
        configuracoes.setValorFixo( configuracoesDTO.getValorFixo() );
        configuracoes.setJogos( configuracoesDTO.getJogos() );

        return configuracoes;
    }

    @Override
    public ConfiguracoesDTO toDTO(Configuracoes configuracoes) {
        if ( configuracoes == null ) {
            return null;
        }

        ConfiguracoesDTO configuracoesDTO = new ConfiguracoesDTO();

        configuracoesDTO.setId( configuracoes.getId() );
        configuracoesDTO.setData( configuracoes.getData() );
        configuracoesDTO.setQuantidadeJogos( configuracoes.getQuantidadeJogos() );
        configuracoesDTO.setName( configuracoes.getName() );
        configuracoesDTO.setValor( configuracoes.getValor() );
        configuracoesDTO.setValorFixo( configuracoes.getValorFixo() );
        configuracoesDTO.setJogos( configuracoes.getJogos() );

        return configuracoesDTO;
    }
}
