package br.com.fiap.AppDenuncia.controller;


import br.com.fiap.AppDenuncia.model.ElogioCidade;
import br.com.fiap.AppDenuncia.repository.ElogioCidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ElogioCidade")
public class ElogioCidadeResource {

    @Autowired
    private ElogioCidadeRepository elogioCidadeRepository;

    @GetMapping
    public List<ElogioCidade> listar() {
        return elogioCidadeRepository.findAll();
    }

    @GetMapping("{id}")
    public ElogioCidade buscar(@PathVariable int id) {
        return elogioCidadeRepository.findById(id).get();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public ElogioCidade ElogioCidade(@RequestBody ElogioCidade elogioCidade) {
        return elogioCidadeRepository.save(elogioCidade);
    }

    @PutMapping("{id}")
    public ElogioCidade atualizar(@RequestBody ElogioCidade elogioCidade, @PathVariable int id) {
        elogioCidade.setId(id);
        return elogioCidadeRepository.save(elogioCidade);
    }

    @DeleteMapping("{id}")
    public void remover(@PathVariable int id) {
        elogioCidadeRepository.deleteById(id);
    }

    @GetMapping("pesquisa")
    public List<ElogioCidade> buscar(@RequestParam(required = false) String cidade, @RequestParam(defaultValue = "false") boolean novo) {
        return cidade !=null ? elogioCidadeRepository.findByCidadeAndNovo(cidade, novo) : elogioCidadeRepository.findByNovo(novo);
    }
}
