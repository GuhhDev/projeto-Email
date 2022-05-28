package br.com.workana.repositories;

import br.com.workana.Entities.Saldo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SaldoRepository extends JpaRepository<Saldo, Double> {
}