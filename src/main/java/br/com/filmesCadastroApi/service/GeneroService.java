package br.com.filmesCadastroApi.service;

import br.com.filmesCadastroApi.domain.Genero;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface GeneroService {
    Optional<Genero> findOne(long id);
    List<Genero> findAll();

    Set<Genero> findType(String tipo);
}
