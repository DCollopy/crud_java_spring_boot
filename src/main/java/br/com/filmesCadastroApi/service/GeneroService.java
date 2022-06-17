package br.com.filmesCadastroApi.service;

import br.com.filmesCadastroApi.domain.Genero;

import java.util.List;
import java.util.Optional;

public interface GeneroService {
    Optional<Genero> findOne(long id);
    List<Genero> findAll();
}
