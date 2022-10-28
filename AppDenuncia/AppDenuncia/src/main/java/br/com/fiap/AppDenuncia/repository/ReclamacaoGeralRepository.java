package br.com.fiap.AppDenuncia.repository;

import br.com.fiap.AppDenuncia.model.Denuncia;
import br.com.fiap.AppDenuncia.model.ReclamacaoGeral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReclamacaoGeralRepository extends JpaRepository<ReclamacaoGeral, Integer> {

    List<ReclamacaoGeral> findByNovo(Boolean novo);

    List<ReclamacaoGeral> findByReclamacaoAndNovo(String reclamacao, boolean novo);
}
