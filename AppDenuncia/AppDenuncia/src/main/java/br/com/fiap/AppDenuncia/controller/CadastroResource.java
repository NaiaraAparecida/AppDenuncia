package br.com.fiap.AppDenuncia.controller;

import br.com.fiap.AppDenuncia.model.Cadastro;
import br.com.fiap.AppDenuncia.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cadastro")
public class CadastroResource {
    @Autowired
    private CadastroRepository cadastroRepository;

    @GetMapping
    public List<Cadastro> listar() {
        return cadastroRepository.findAll();
    }

    @GetMapping("{id}")
    public Cadastro buscar(@PathVariable int id) {
        return cadastroRepository.findById(id).get();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Cadastro cadastrar(@RequestBody Cadastro cadastro) {
        return cadastroRepository.save(cadastro);
    }

    @PutMapping("{id}")
    public Cadastro atualizar(@RequestBody Cadastro cadastro, @PathVariable int id) {
        cadastro.setId(id);
        return cadastroRepository.save(cadastro);
    }

    @DeleteMapping("{id}")
    public void remover(@PathVariable int id) {
        cadastroRepository.deleteById(id);
    }

    @GetMapping("pesquisa")
    public List<Cadastro> buscar(@RequestParam(required = false) String usuario, @RequestParam(defaultValue = "false") boolean novo) {
        return usuario !=null ? cadastroRepository.findByUsuarioAndNovo(usuario, novo) : cadastroRepository.findByNovo(novo);
    }

}
