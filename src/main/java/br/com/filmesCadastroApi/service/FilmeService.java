package br.com.filmesCadastroApi.service;

import br.com.filmesCadastroApi.model.Filmes;

import java.util.List;
import java.util.Optional;
public interface FilmeService {
    Optional<Filmes> findOne(long id);

    List<Filmes> findAll();
}
