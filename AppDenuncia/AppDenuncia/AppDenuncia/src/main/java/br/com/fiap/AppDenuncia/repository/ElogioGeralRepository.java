package br.com.fiap.AppDenuncia.repository;

import br.com.fiap.AppDenuncia.model.Denuncia;
import br.com.fiap.AppDenuncia.model.ElogioGeral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElogioGeralRepository extends JpaRepository<ElogioGeral, Integer> {

    List<ElogioGeral> findByNovo(Boolean novo);

    List<ElogioGeral> findByDescricaoAndNovo(String descricao, boolean novo);
}
