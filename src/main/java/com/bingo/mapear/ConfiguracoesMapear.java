package com.bingo.mapear;

import com.bingo.dto.ConfiguracoesDTO;
import com.bingo.entidade.Configuracoes;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConfiguracoesMapear {

    ConfiguracoesMapear INSTANCIA = Mappers.getMapper(ConfiguracoesMapear.class);

    Configuracoes toModel(ConfiguracoesDTO configuracoesDTO);

    ConfiguracoesDTO toDTO(Configuracoes configuracoes);
}
