package br.com.fiap.AppDenuncia.repository;

import br.com.fiap.AppDenuncia.model.ElogioCidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElogioCidadeRepository extends JpaRepository<ElogioCidade, Integer> {

    List<ElogioCidade> findByNovo(Boolean novo);

    List<ElogioCidade> findByCidadeAndNovo(String cidade, boolean novo);
}
