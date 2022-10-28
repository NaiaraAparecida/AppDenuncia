package br.com.fiap.AppDenuncia.controller;

import br.com.fiap.AppDenuncia.model.Cadastro;
import br.com.fiap.AppDenuncia.model.Denuncia;
import br.com.fiap.AppDenuncia.repository.CadastroRepository;
import br.com.fiap.AppDenuncia.repository.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("denuncia")
public class DenunciaResource {

    @Autowired
    private DenunciaRepository denunciaRepository;

    @GetMapping
    public List<Denuncia> listar() {
        return denunciaRepository.findAll();
    }

    @GetMapping("{id}")
    public Denuncia buscar(@PathVariable int id) {
        return denunciaRepository.findById(id).get();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Denuncia cadastrar(@RequestBody Denuncia denuncia) {
        return denunciaRepository.save(denuncia);
    }

    @PutMapping("{id}")
    public Denuncia atualizar(@RequestBody Denuncia denuncia, @PathVariable int id) {
        denuncia.setId(id);
        return denunciaRepository.save(denuncia);
    }

    @DeleteMapping("{id}")
    public void remover(@PathVariable int id) {
        denunciaRepository.deleteById(id);
    }

    @GetMapping("pesquisa")
    public List<Denuncia> buscar(@RequestParam(required = false) String titulo, @RequestParam(defaultValue = "false") boolean novo) {
        return titulo !=null ? denunciaRepository.findByTituloAndNovo(titulo, novo) : denunciaRepository.findByNovo(novo);
    }

}

