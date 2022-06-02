package com.bingo.controlador;

import java.util.ArrayList;
import java.util.List;

import com.bingo.dto.PessoaDTO;
import com.bingo.exception.PessoaExiste;
import com.bingo.exception.PessoaNaoExiste;
import com.bingo.servico.PessoaServico;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/bingo")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class Controlador {

    private final PessoaServico pessoaServico;
    public static List<PessoaDTO> pessoa = new ArrayList<>();

    @PostMapping("/")
    public PessoaDTO criarPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) throws PessoaExiste {
        pessoaDTO.setStatus_Pagamento(false);
        pessoaDTO.setPagamento("Aberto");
        pessoaDTO = pessoaServico.criarPessoa(pessoaDTO);
        this.pessoa = pessoaServico.listAll();
        return pessoaDTO;
    }

    @PostMapping()
    public void criarPessoa(@RequestParam("name") String name) throws PessoaExiste {
        if(pessoaServico.existe(name) == 1 || name.equals("")){
            return;
        }
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setName(name);
        pessoaDTO.setStatus_Pagamento(false);
        pessoaDTO.setPagamento("Aberto");
        pessoaServico.criarPessoa(pessoaDTO);
        this.pessoa = pessoaServico.listAll();
    }


    @GetMapping
    public List<PessoaDTO> listaPessoa(){
        this.pessoa = pessoaServico.listAll();
        return pessoaServico.listAll();
    }

    @GetMapping("/{id}")
    public PessoaDTO procruarPessoa(@PathVariable long id) throws PessoaNaoExiste {
       return pessoaServico.procurarID(id);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarId(@PathVariable Integer id) throws PessoaNaoExiste {
        pessoaServico.deletarId(id);
        this.pessoa = pessoaServico.listAll();
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaDTO atualizarId(@PathVariable Integer id, @RequestBody @Valid PessoaDTO pessoaDTO) throws PessoaNaoExiste {
        pessoaDTO = pessoaServico.atualizarId(id, pessoaDTO);
        this.pessoa = pessoaServico.listAll();
        return pessoaDTO;
    }

}