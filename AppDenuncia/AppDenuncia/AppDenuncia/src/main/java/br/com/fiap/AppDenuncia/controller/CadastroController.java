package br.com.fiap.AppDenuncia.controller;

import br.com.fiap.AppDenuncia.model.Cadastro;
import br.com.fiap.AppDenuncia.repository.CadastroRepository;
import br.com.fiap.AppDenuncia.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("cadastro")
public class CadastroController {
    @Autowired
    private CadastroRepository cadastroRepository;

    @Autowired
    private LoginRepository loginRepository;

   @GetMapping("cadastrar")
    public String abrirFormulario(Cadastro cadastro, Model model) {
       model.addAttribute("login", loginRepository.findAll());
       return "home/form";
   }

   @PostMapping("cadastrar")
    public String processForm(@Valid Cadastro cadastro, BindingResult result, RedirectAttributes redirectAttributes) {
      if(result.hasErrors()) {
          return "cadastro/form";
      }
      redirectAttributes.addFlashAttribute("msg", "Cadastro realizado com sucesso!");
      cadastroRepository.save(cadastro);
      return "redirect:listar";
   }

   @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") int id, Model model) {
       model.addAttribute("cadastro", cadastroRepository.findById(id));
       return "cadastro/form";
   }

   @PostMapping("excluir")
    public String remover(int id, RedirectAttributes redirectAttributes) {
       redirectAttributes.addFlashAttribute("msg", "Removido!");
       cadastroRepository.deleteById(id);
       return "redirect:listar";
   }



}
