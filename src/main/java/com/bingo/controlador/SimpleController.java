package com.bingo.controlador;


import com.bingo.dto.ConfiguracoesDTO;
import com.bingo.dto.PessoaDTO;
import com.bingo.servico.ConfiguracoesServico;
import com.bingo.servico.PessoaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

@Controller
public class SimpleController {
    @Autowired
    private PessoaServico pessoaServico;
    @Autowired
    private ConfiguracoesServico configuracoesServico;

    @RequestMapping("/")
    public String home(Model model) throws InterruptedException {
        List<PessoaDTO> pessoa = pessoaServico.listAll();
        pessoa.sort(Comparator.comparing(PessoaDTO::getName));
        ConfiguracoesDTO configuracoesDTO = configuracoesServico.getConfig();
        System.out.println(pessoa);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //System.out.println(pessoa);
        int pagamentos = 0;
        for (int i =0; i < pessoa.size(); i++){
            if(pessoa.get(i).getPagamento().equals("Pago")){
                pagamentos += 1;
            }
            if(configuracoesDTO.getValorFixo() == 1){
                pessoa.get(i).setValor(configuracoesDTO.getValor());
            }
            else{
                double valor = (configuracoesDTO.getValor()*configuracoesDTO.getQuantidadeJogos())/pessoa.size();
                BigDecimal bd = BigDecimal.valueOf(valor).setScale(2, RoundingMode.HALF_EVEN);
                pessoa.get(i).setValor(bd.doubleValue());
            }
        }

        model.addAttribute("data", configuracoesDTO.getData().format(formatter));

        LocalDate agora = LocalDate.now();


        model.addAttribute("pagamentos", pagamentos);

        model.addAttribute("jogos", "Quantidade de jogos: "+configuracoesDTO.getQuantidadeJogos());

        int dataAgora = 0;
        if(agora.compareTo(configuracoesDTO.getData()) <= 0){
            dataAgora = 1;
        }
        model.addAttribute("dataAgora", dataAgora);
        model.addAttribute("name", pessoa.size());
        model.addAttribute("dia", configuracoesDTO.getData().compareTo(agora));
        model.addAttribute("name", pessoa.size());
        model.addAttribute("users", pessoa);
        model.addAttribute("permitirJogos", configuracoesDTO.getJogos());

        return "index";
    }
    @RequestMapping("/config")
    public String conf(Model model) throws InterruptedException {
        List<PessoaDTO> pessoa = pessoaServico.listAll();
        pessoa.sort(Comparator.comparing(PessoaDTO::getName));
        ConfiguracoesDTO configuracoesDTO = configuracoesServico.getConfig();
        //System.out.println(pessoa);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (int i =0; i < pessoa.size(); i++){

            if(configuracoesDTO.getValorFixo() == 1){
                pessoa.get(i).setValor(configuracoesDTO.getValor());
            }
            else{
                double valor = (configuracoesDTO.getValor()*configuracoesDTO.getQuantidadeJogos())/pessoa.size();
                BigDecimal bd = BigDecimal.valueOf(valor).setScale(2, RoundingMode.HALF_EVEN);
                pessoa.get(i).setValor(bd.doubleValue());
            }
        }

        model.addAttribute("data", configuracoesDTO.getData().format(formatter));
        if(configuracoesDTO.getJogos() != 1){
            model.addAttribute("jogos", "Quantidade de jogos: "+configuracoesDTO.getQuantidadeJogos());
        }

        LocalDate agora = LocalDate.now();

        int dataAgora = 0;
        if(agora.compareTo(configuracoesDTO.getData()) <= 0){
            dataAgora = 1;
        }
        model.addAttribute("dataAgora", dataAgora);
        model.addAttribute("name", pessoa.size());
        model.addAttribute("dia", configuracoesDTO.getData().compareTo(agora));
        model.addAttribute("name", pessoa.size());
        model.addAttribute("users", pessoa);

        model.addAttribute("configValor", configuracoesDTO.getValor());
        model.addAttribute("configData", configuracoesDTO.getData());
        model.addAttribute("configJogos", configuracoesDTO.getQuantidadeJogos());
        model.addAttribute("configValorFixo", configuracoesDTO.getValorFixo());
        model.addAttribute("permitirJogos", configuracoesDTO.getJogos());

        return "config";
    }
}