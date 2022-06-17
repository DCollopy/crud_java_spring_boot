package br.com.filmesCadastroApi.controller;

import br.com.filmesCadastroApi.model.FormDTO;
import br.com.filmesCadastroApi.domain.Filmes;
import br.com.filmesCadastroApi.service.AutorService;
import br.com.filmesCadastroApi.service.FilmeService;
import br.com.filmesCadastroApi.service.GeneroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


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
                           @PathVariable("id") Long id, Model model) {
        model.addAttribute("filmes",filmeService.findOne(id).get());
        model.addAttribute("autores", autorService.findAutorFilme(id));
        return "filmes/detalhes";
    }

    @GetMapping("/cadastro")
    public String cadastro(Model model) {
        model.addAttribute("add", true);
        FormDTO formDTO = new FormDTO();
        model.addAttribute("cadastro", formDTO);
        model.addAttribute("generos", generoService.findAll());
        return "filmes/cadastro";
    }

    @PostMapping("/cadastro")
    public String salve(@ModelAttribute FormDTO formDTO, Model model) {
        model.addAttribute("add", true);
        filmeService.saveAllMovies(formDTO);
        return "filmes/home";
    }

    @GetMapping("/edite{id}")
    public String edite(@RequestParam(required = false)
                        @PathVariable Long id, Model model) {
        model.addAttribute("add", false);
        FormDTO formDTO = new FormDTO();
        formDTO.setId(id);
        model.addAttribute("cadastro", formDTO);
        model.addAttribute("generos", generoService.findAll());
        model.addAttribute("filmes",filmeService.findOne(id).get());
        return "filmes/edite";
    }

    @PostMapping("/edite")
    public String editeFilme(@ModelAttribute("cadastro")
                             FormDTO formDTO, Model model) {
        model.addAttribute("add", false);
        filmeService.update(formDTO);
        return "redirect:/filmes/home";
    }
    @GetMapping("/delete{id}")
    public String deleteFilme(@RequestParam(required = false)
                              @PathVariable("id") Long id) {
        Set<Filmes> filmesId = filmeService.findMovieId(id);
        for (Filmes filme: filmesId) {
            filmeService.delete(filme);
        }
        return "filmes/home";
    }
}
