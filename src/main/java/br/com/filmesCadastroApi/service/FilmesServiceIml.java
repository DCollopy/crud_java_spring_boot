package br.com.filmesCadastroApi.service;

import br.com.filmesCadastroApi.model.Filmes;
import br.com.filmesCadastroApi.repository.FilmesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FilmesServiceIml implements FilmeService {
    @Autowired
    private  FilmesRepository filmesRepository;

    @Override
    public Optional<Filmes> findOne(long id) {
        return filmesRepository.findById(id);
    }
    @Override
    public List<Filmes> findAll() {
        return filmesRepository.findAll();
    }
}
