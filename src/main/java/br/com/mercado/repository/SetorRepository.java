package br.com.mercado.repository;

import br.com.mercado.model.Setor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SetorRepository extends JpaRepository<Setor, Long> {
}
