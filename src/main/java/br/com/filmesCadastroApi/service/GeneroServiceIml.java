package br.com.filmesCadastroApi.service;

import br.com.filmesCadastroApi.domain.Genero;
import br.com.filmesCadastroApi.repository.GeneroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class GeneroServiceIml implements GeneroService {
    private final GeneroRepository generoRepository;

    public GeneroServiceIml(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    @Override
    public Optional<Genero> findOne(long id) {
        return generoRepository.findById(id);
    }

    @Override
    public List<Genero> findAll() {
        return generoRepository.findAll();
    }
}
