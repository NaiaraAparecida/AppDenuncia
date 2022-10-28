package br.com.fiap.AppDenuncia.controller;

import br.com.fiap.AppDenuncia.model.ReclamacaoGeral;
import br.com.fiap.AppDenuncia.repository.ReclamacaoGeralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ReclamacaoGeral")
public class ReclamacaoGeralResourse {

    @Autowired
    private ReclamacaoGeralRepository reclamacaoGeralRepository;

    @GetMapping
    public List<ReclamacaoGeral> listar() {
        return reclamacaoGeralRepository.findAll();
    }

    @GetMapping("{id}")
    public ReclamacaoGeral buscar(@PathVariable int id) {
        return reclamacaoGeralRepository.findById(id).get();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public ReclamacaoGeral ReclamacaoGeral(@RequestBody ReclamacaoGeral reclamacaoGeral) {
        return reclamacaoGeralRepository.save(reclamacaoGeral);
    }

    @PutMapping("{id}")
    public ReclamacaoGeral atualizar(@RequestBody ReclamacaoGeral reclamacaoGeral, @PathVariable int id) {
        reclamacaoGeral.setId(id);
        return reclamacaoGeralRepository.save(reclamacaoGeral);
    }

    @DeleteMapping("{id}")
    public void remover(@PathVariable int id) {
        reclamacaoGeralRepository.deleteById(id);
    }

    @GetMapping("pesquisa")
    public List<ReclamacaoGeral> buscar(@RequestParam(required = false) String reclamacao, @RequestParam(defaultValue = "false") boolean novo) {
        return reclamacao !=null ? reclamacaoGeralRepository.findByReclamacaoAndNovo(reclamacao, novo) : reclamacaoGeralRepository.findByNovo(novo);
    }
}
