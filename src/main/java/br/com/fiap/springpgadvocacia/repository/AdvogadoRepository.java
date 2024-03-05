package br.com.fiap.springpgadvocacia.repository;

import br.com.fiap.springpgadvocacia.entity.Advogado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvogadoRepository extends JpaRepository<Advogado, Long> {
}
