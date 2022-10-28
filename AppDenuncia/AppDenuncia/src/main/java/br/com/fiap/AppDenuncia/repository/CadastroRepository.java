package br.com.fiap.AppDenuncia.repository;

import br.com.fiap.AppDenuncia.model.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {
    List<Cadastro> findByNovo(Boolean novo);
    List<Cadastro> findByUsuarioAndNovo(String usuario, boolean novo);



}
