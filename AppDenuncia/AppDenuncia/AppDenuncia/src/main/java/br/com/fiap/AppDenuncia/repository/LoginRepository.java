package br.com.fiap.AppDenuncia.repository;


import br.com.fiap.AppDenuncia.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {

        List<Login> findByNovo(Boolean novo);
        List<Login> findByEmailAndNovo(String email, boolean novo);
}

