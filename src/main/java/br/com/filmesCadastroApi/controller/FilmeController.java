package br.com.filmesCadastroApi.controller;

import br.com.filmesCadastroApi.model.Autor;
import br.com.filmesCadastroApi.model.Filmes;
import br.com.filmesCadastroApi.service.AutorService;
import br.com.filmesCadastroApi.service.FilmeService;
import br.com.filmesCadastroApi.service.GeneroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("filmes")
public class FilmeController {
    private final FilmeService filmeService;
    private final GeneroService generoService;
    private final AutorService autorService;

    public FilmeController(FilmeService filmeService, GeneroService generoService, AutorService autorService) {
        this.filmeService = filmeService;
        this.generoService = generoService;
        this.autorService = autorService;
    }
    @GetMapping("/home")
    public String filmes(Model model){
        model.addAttribute("filmes",filmeService.findAll());
        return "filmes/home";
    }
    @GetMapping("/detalhes{id}")
    public String detalhes(@RequestParam(required = false)
                               @PathVariable Long id, Model model) {
        model.addAttribute("filmes",filmeService.findOne(id).get());
        model.addAttribute("autores", autorService.findOne(id).get().getFilmes());
        return "filmes/detalhes";
    }

    @RequestMapping(value="/cadastro", params={"addAutor"})
    public String addFilmes(final Filmes filmes, final BindingResult bindingResult) {
        filmes.getAutores().add(new Autor());
        return "filmes/cadastro";
    }

    @RequestMapping(value="/cadastro", params={"removeAutor"})
    public String removeRow(
            final Filmes filmes, final BindingResult bindingResult,
            final HttpServletRequest req) {
        final long id = Long.parseLong(req.getParameter("removeAutor"));
        filmes.getAutores().remove(id);
        return "filmes/cadastro";
    }
}
