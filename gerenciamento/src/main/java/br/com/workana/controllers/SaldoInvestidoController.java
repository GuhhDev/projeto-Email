package br.com.workana.controllers;

import br.com.workana.Entities.Investimento;
import br.com.workana.services.InvestimentoService;
import br.com.workana.services.SaldoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/investimento")
public class SaldoInvestidoController {

        @Autowired
        InvestimentoService investimentoService;

//        @GetMapping
//        public Page<InvestimentoDTO> findAll(Pageable pageable) {
//            Investimento investimento = new Investimento();
//            investimento.setInvestimento(123);
//            return investimentoService.findAll(pageable);
//        }

//        @GetMapping(value = "/{id}")
//        public InvestimentoDTO findById(@PathVariable Long id) {
//            return investimentoService.findById(id);
//        }

    @GetMapping
    public List<Investimento> findAll() {
        return investimentoService.findInvestimento();
    }

    @PostMapping
    public void saveAll(Investimento investimento) {
        investimentoService.saveInvestimento(investimento);
    }
}
