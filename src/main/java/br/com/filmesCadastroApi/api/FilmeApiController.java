package br.com.filmesCadastroApi.api;

import br.com.filmesCadastroApi.domain.Autor;
import br.com.filmesCadastroApi.domain.Diretor;
import br.com.filmesCadastroApi.domain.Filmes;
import br.com.filmesCadastroApi.service.AutorService;
import br.com.filmesCadastroApi.service.DiretorService;
import br.com.filmesCadastroApi.service.FilmeService;
import br.com.filmesCadastroApi.service.GeneroService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/filmes")
public class FilmeApiController {

    private final AutorService autorService;
    private final DiretorService diretorService;
    private final FilmeService filmeService;
    private final GeneroService generoService;

    public FilmeApiController(AutorService autorService, DiretorService diretorService,
                              FilmeService filmeService, GeneroService generoService) {
        this.autorService = autorService;
        this.diretorService = diretorService;
        this.filmeService = filmeService;
        this.generoService = generoService;
    }

    @GetMapping
    public List<Filmes> list() {
        return filmeService.findAll();
    }

    @PostMapping("/cadastro")
    public Filmes Create(@Valid @RequestBody Filmes filmes){
        return filmeService.save(filmes);
    }

    @PostMapping("/cadastro/diretor")
    public Diretor CreateDiretor(@Valid @RequestBody Diretor diretor){
        return diretorService.save(diretor);
    }

    @PostMapping("/cadastro/autor")
    public Autor CreateAutor(@Valid @RequestBody Autor autor){
        return autorService.save(autor);
    }

}
