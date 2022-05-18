package com.bingo.servico;


import com.bingo.dto.ConfiguracoesDTO;
import com.bingo.dto.PessoaDTO;
import com.bingo.entidade.Pessoa;
import com.bingo.exception.PessoaNaoExiste;
import com.bingo.mapear.ConfiguracoesMapear;
import com.bingo.repositorio.ConfiguracoesRepositorio;
import com.bingo.entidade.Configuracoes;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ConfiguracoesServico {
    private final ConfiguracoesRepositorio configuracoesRepositorio;
    private final ConfiguracoesMapear configuracoesMapear = ConfiguracoesMapear.INSTANCIA;

    public ConfiguracoesDTO criarConfiguracoes(ConfiguracoesDTO configuracoesDTO) {
        Configuracoes pokemon = configuracoesMapear.toModel(configuracoesDTO);

        Configuracoes salvar = configuracoesRepositorio.save(pokemon);
        return configuracoesMapear.toDTO(salvar);
    }

    public void procurarNome(String name){
        Optional<Configuracoes> achou = configuracoesRepositorio.findByName(name);
    }


    public ConfiguracoesDTO procurarID(long id) throws PessoaNaoExiste {
        Configuracoes achou = configuracoesRepositorio.findById(id)
                .orElseThrow(() -> new PessoaNaoExiste(id));
        return configuracoesMapear.toDTO(achou);
    }

    public ConfiguracoesDTO atualizarId(Integer id, ConfiguracoesDTO configuracoesDTO) throws PessoaNaoExiste {
        ConfiguracoesDTO achou = procurarID(id);
        configuracoesRepositorio.save(configuracoesMapear.toModel(achou));
        return configuracoesDTO;
    }

    public ConfiguracoesDTO getConfig(){
        return configuracoesMapear.toDTO(configuracoesRepositorio.getOne(1L));
    }

}
