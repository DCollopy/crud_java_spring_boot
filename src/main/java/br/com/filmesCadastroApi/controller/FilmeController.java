package br.com.filmesCadastroApi.controller;

import br.com.filmesCadastroApi.model.Filmes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/filmes")
public class FilmeController {

    @GetMapping
    public List<Filmes> list() {
        return null;
    }
}
