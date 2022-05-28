package br.com.workana.repositories;

import br.com.workana.Entities.Investimento;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InvestimentoRepository extends JpaRepository<Investimento, Long> {
}