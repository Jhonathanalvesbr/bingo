package com.bingo.controlador;


import com.bingo.dto.ConfiguracoesDTO;
import com.bingo.dto.PessoaDTO;
import com.bingo.exception.PessoaNaoExiste;
import com.bingo.servico.ConfiguracoesServico;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/conf")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ControlarConfiguracoes
{
    private final ConfiguracoesServico configuracoesServico;
    static ConfiguracoesDTO configuracoesDTO = new ConfiguracoesDTO();

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ConfiguracoesDTO criarConfiguracoes(@RequestBody @Valid ConfiguracoesDTO configuracoesDTO)  {
        configuracoesDTO =  configuracoesServico.criarConfiguracoes(configuracoesDTO);
        this.configuracoesDTO = configuracoesDTO;
        return configuracoesDTO;
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ConfiguracoesDTO atualizarId(@PathVariable Integer id, @RequestBody @Valid ConfiguracoesDTO configuracoesDTO) throws PessoaNaoExiste {
        configuracoesDTO =  configuracoesServico.criarConfiguracoes(configuracoesDTO);
        this.configuracoesDTO = configuracoesDTO;
        return configuracoesDTO;
    }

    @GetMapping("/{id}")
    public ConfiguracoesDTO procruarPessoa(@PathVariable long id) throws PessoaNaoExiste {
        this.configuracoesDTO =  configuracoesServico.procurarID(id);
        return this.configuracoesDTO;
    }
}
