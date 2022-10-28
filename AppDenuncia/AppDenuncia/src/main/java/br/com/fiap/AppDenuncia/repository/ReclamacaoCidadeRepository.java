package br.com.fiap.AppDenuncia.repository;

import br.com.fiap.AppDenuncia.model.Denuncia;
import br.com.fiap.AppDenuncia.model.ReclamacaoCidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReclamacaoCidadeRepository extends JpaRepository<ReclamacaoCidade, Integer> {

    List<ReclamacaoCidade> findByNovo(Boolean novo);

    List<ReclamacaoCidade> findByReclamacaoAndNovo(String Reclamacao, boolean novo);
}
