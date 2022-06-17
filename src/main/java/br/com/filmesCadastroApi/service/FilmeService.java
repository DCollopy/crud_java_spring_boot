package br.com.filmesCadastroApi.service;

import br.com.filmesCadastroApi.model.FormDTO;
import br.com.filmesCadastroApi.domain.Filmes;

import java.util.List;
import java.util.Optional;
import java.util.Set;


public interface FilmeService {
    Optional<Filmes> findOne(long id);
    List<Filmes> findAll();
    Filmes save(Filmes filmes);
    void saveAllMovies(FormDTO formDTO);
    void update(FormDTO formDTO);
    Set<Filmes> findMovieId(long id);
    void delete(Filmes filme);
}
