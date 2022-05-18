package com.bingo.servico;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.bingo.dto.PessoaDTO;
import com.bingo.entidade.Pessoa;
import com.bingo.exception.PessoaExiste;
import com.bingo.exception.PessoaNaoExiste;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bingo.repositorio.PessoaRepositorio;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaServico {

    private final PessoaRepositorio PessoaRepositorio;
    private final com.bingo.mapear.PessoaMapear PessoaMapear = com.bingo.mapear.PessoaMapear.INSTANCE;


    public PessoaDTO criarPessoa(PessoaDTO PessoaDTO) throws PessoaExiste {
        procurarNome(PessoaDTO.getName());
        Pessoa Pessoa = PessoaMapear.toModel(PessoaDTO);

        Pessoa salvar = PessoaRepositorio.save(Pessoa);
        return PessoaMapear.toDTO(salvar);
    }

    public List<PessoaDTO> listAll(){
        return PessoaRepositorio.findAll()
                .stream()
                .map(PessoaMapear::toDTO)
                .collect(Collectors.toList());
    }

    public void procurarNome(String name) throws PessoaExiste {
        Optional<Pessoa> achou = PessoaRepositorio.findByName(name);
        if(achou.isPresent()){
            throw new PessoaExiste(name);
        }
    }

    public PessoaDTO procurarID(long id) throws PessoaNaoExiste {
        Pessoa achou = PessoaRepositorio.findById(id)
                .orElseThrow(() -> new PessoaNaoExiste(id));
        return PessoaMapear.toDTO(achou);
    }

    public void deletarId(long id) throws PessoaNaoExiste {
        procurarID(id);
        PessoaRepositorio.deleteById(id);
    }

    public PessoaDTO atualizarId(long id, PessoaDTO PessoaDTO) throws PessoaNaoExiste {
        PessoaDTO achou = procurarID(id);
        achou = PessoaDTO;
        PessoaRepositorio.save(PessoaMapear.toModel(achou));
        return PessoaDTO;
    }

    public int existe(String name) {
        Optional<Pessoa> achou = PessoaRepositorio.findByName(name);
        if(achou.isPresent()){
            return 1;
        }
        else{
            return 0;
        }
    }
}
