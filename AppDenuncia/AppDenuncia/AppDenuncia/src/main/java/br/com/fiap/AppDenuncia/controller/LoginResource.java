package br.com.fiap.AppDenuncia.controller;

import br.com.fiap.AppDenuncia.model.Login;
import br.com.fiap.AppDenuncia.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("login")
public class LoginResource {

    @Autowired
    private LoginRepository loginRepository;

    @GetMapping
    public List<Login> listar() {
        return loginRepository.findAll();
    }

    @GetMapping("{id}")
    public Login buscar(@PathVariable int id) {
        return loginRepository.findById(id).get();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Login login (@RequestBody Login login ) {
        return loginRepository.save(login);
    }

    @PutMapping("{id}")
    public Login atualizar(@RequestBody Login login, @PathVariable int id) {
        login.setId(id);
        return loginRepository.save(login);
    }

    @DeleteMapping("{id}")
    public void remover(@PathVariable int id) {
        loginRepository.deleteById(id);
    }

    @GetMapping("pesquisa")
    public List<Login> buscar(@RequestParam(required = false) String email, @RequestParam(defaultValue = "false") boolean novo) {
        return email !=null ? loginRepository.findByEmailAndNovo(email, novo) : loginRepository.findByNovo(novo);
    }
}

