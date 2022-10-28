package br.com.fiap.AppDenuncia.repository;

import br.com.fiap.AppDenuncia.model.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DenunciaRepository extends JpaRepository<Denuncia, Integer> {

    List<Denuncia> findByNovo(Boolean novo);
    List<Denuncia> findByTituloAndNovo(String titulo, boolean novo);

}
