package com.filme;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WebControl {

    private final FilmeDAO filmeDAO;

    public WebControl(FilmeDAO filmeDAO) {
        this.filmeDAO = filmeDAO;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/filmes";
    }

    @GetMapping("/filmes")
    public String listar(Model model, @RequestParam(required = false) String mensagem) {
        model.addAttribute("filmes", filmeDAO.findAll());
        model.addAttribute("mensagem", mensagem);
        return "filmes";
    }

    @GetMapping("/filmes/novo")
    public String novo(Model model) {
        model.addAttribute("filme", new Filme());
        return "form";
    }

    @GetMapping("/filmes/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Filme filme = filmeDAO.findById(id).orElseThrow();
        model.addAttribute("filme", filme);
        return "form";
    }

    @PostMapping("/filmes/salvar")
    public String salvar(@ModelAttribute Filme filme, RedirectAttributes redirectAttributes) {
        filmeDAO.save(filme);
        redirectAttributes.addAttribute("mensagem", "Filme salvo com sucesso");
        return "redirect:/filmes";
    }

    @GetMapping("/filmes/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        filmeDAO.deleteById(id);
        return "redirect:/filmes";
    }

}