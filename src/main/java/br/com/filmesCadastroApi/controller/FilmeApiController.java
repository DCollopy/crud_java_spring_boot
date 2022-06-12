package br.com.filmesCadastroApi.controller;

import br.com.filmesCadastroApi.model.Diretor;
import br.com.filmesCadastroApi.model.Filmes;
import br.com.filmesCadastroApi.repository.DiretorRepository;
import br.com.filmesCadastroApi.repository.FilmesRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/filmes")
public class FilmeApiController {

    private final FilmesRepository filmesRepository;
    private final DiretorRepository diretorRepository;

    public FilmeApiController(FilmesRepository filmesRepository, DiretorRepository diretorRepository) {
        this.filmesRepository = filmesRepository;
        this.diretorRepository = diretorRepository;
    }

    @GetMapping
    public List<Filmes> list() {
        return filmesRepository.findAll();
    }

    @PostMapping("/criar")
    public Filmes Create(@Valid @RequestBody Filmes filmes){
        return filmesRepository.save(filmes);
    }

    @PostMapping("/criadiretor")
    public Diretor CreateDiretor(@Valid @RequestBody Diretor diretor){
        return diretorRepository.save(diretor);
    }

    @PostMapping("/criamoke")
    public Filmes CreateMoke(Filmes filmes){
        //filmes = Mocke.novoFilme();
        return filmesRepository.save(filmes);
    }

}
