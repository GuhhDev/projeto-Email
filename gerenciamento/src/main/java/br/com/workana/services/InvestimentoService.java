package br.com.workana.services;

import br.com.workana.Entities.Investimento;
import br.com.workana.repositories.InvestimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
public class InvestimentoService {

    @Autowired
    InvestimentoRepository investimentoRepository;

    public List<Investimento> findInvestimento() {
        return investimentoRepository.findAll();
    }

    public void saveInvestimento(Investimento investimento) {
        investimentoRepository.save(investimento);

    }
}