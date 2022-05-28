package br.com.workana.repositories;

import br.com.workana.Entities.Email;
import br.com.workana.Entities.Investimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {

}