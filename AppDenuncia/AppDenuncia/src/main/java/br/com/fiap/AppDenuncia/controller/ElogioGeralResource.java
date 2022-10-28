package br.com.fiap.AppDenuncia.controller;

import br.com.fiap.AppDenuncia.model.ElogioGeral;
import br.com.fiap.AppDenuncia.repository.ElogioGeralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ElogioGeral")
public class ElogioGeralResource {

    @Autowired
    private ElogioGeralRepository elogioGeralRepository;

    @GetMapping
    public List<ElogioGeral> listar() {
        return elogioGeralRepository.findAll();
    }

    @GetMapping("{id}")
    public ElogioGeral buscar(@PathVariable int id) {
        return elogioGeralRepository.findById(id).get();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public ElogioGeral ElogioGeral(@RequestBody ElogioGeral elogioGeral ) {
        return elogioGeralRepository.save(elogioGeral);
    }

    @PutMapping("{id}")
    public ElogioGeral atualizar(@RequestBody ElogioGeral elogioGeral, @PathVariable int id) {
        elogioGeral.setId(id);
        return elogioGeralRepository.save(elogioGeral);
    }

    @DeleteMapping("{id}")
    public void remover(@PathVariable int id) {
        elogioGeralRepository.deleteById(id);
    }

    @GetMapping("pesquisa")
    public List<ElogioGeral> buscar(@RequestParam(required = false) String descricao, @RequestParam(defaultValue = "false") boolean novo) {
        return descricao !=null ? elogioGeralRepository.findByDescricaoAndNovo(descricao, novo) : elogioGeralRepository.findByNovo(novo);
    }
}
