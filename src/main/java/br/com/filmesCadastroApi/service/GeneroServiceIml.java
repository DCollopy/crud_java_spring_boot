package br.com.filmesCadastroApi.service;

import br.com.filmesCadastroApi.domain.Genero;
import br.com.filmesCadastroApi.repository.GeneroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    @Override
    public Set<Genero> findType(String tipo) {
        Set<Genero> generoId = generoRepository.findAllByTipo(tipo);
        for (Genero genero: generoId) {
            return generoRepository.findAllById(genero.getId());
        }
        return generoId;
    }
}
