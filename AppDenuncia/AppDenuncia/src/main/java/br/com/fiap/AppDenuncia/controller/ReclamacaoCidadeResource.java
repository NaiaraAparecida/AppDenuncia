package br.com.fiap.AppDenuncia.controller;

import br.com.fiap.AppDenuncia.model.ReclamacaoCidade;
import br.com.fiap.AppDenuncia.repository.ReclamacaoCidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ReclamacaoCidade")
public class ReclamacaoCidadeResource {

    @Autowired
    private ReclamacaoCidadeRepository reclamacaoCidadeRepository;

    @GetMapping
    public List<ReclamacaoCidade> listar() {
        return reclamacaoCidadeRepository.findAll();
    }

    @GetMapping("{id}")
    public ReclamacaoCidade buscar(@PathVariable int id) {
        return reclamacaoCidadeRepository.findById(id).get();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public ReclamacaoCidade ReclamacaoCidade(@RequestBody ReclamacaoCidade reclamacaoCidade) {
        return reclamacaoCidadeRepository.save(reclamacaoCidade);
    }

    @PutMapping("{id}")
    public ReclamacaoCidade atualizar(@RequestBody ReclamacaoCidade reclamacaoCidade, @PathVariable int id) {
        reclamacaoCidade.setId(id);
        return reclamacaoCidadeRepository.save(reclamacaoCidade);
    }

    @DeleteMapping("{id}")
    public void remover(@PathVariable int id) {
        reclamacaoCidadeRepository.deleteById(id);
    }

    @GetMapping("pesquisa")
    public List<ReclamacaoCidade> buscar(@RequestParam(required = false) String reclamacao, @RequestParam(defaultValue = "false") boolean novo) {
        return reclamacao !=null ? reclamacaoCidadeRepository.findByReclamacaoAndNovo(reclamacao, novo) : reclamacaoCidadeRepository.findByNovo(novo);
    }
}
