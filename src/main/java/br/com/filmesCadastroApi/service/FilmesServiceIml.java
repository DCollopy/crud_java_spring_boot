package br.com.filmesCadastroApi.service;

import br.com.filmesCadastroApi.model.FormDTO;
import br.com.filmesCadastroApi.domain.Avaliacao;
import br.com.filmesCadastroApi.domain.Filmes;
import br.com.filmesCadastroApi.repository.FilmesRepository;
import br.com.filmesCadastroApi.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static br.com.filmesCadastroApi.model.Validacao.formatarData;

@Service
public class FilmesServiceIml implements FilmeService {
    @Autowired
    private  FilmesRepository filmesRepository;
    @Autowired
    private GeneroRepository generoRepository;
    @Override
    public Optional<Filmes> findOne(long id) {
        return filmesRepository.findById(id);
    }
    @Override
    public List<Filmes> findAll() {
        return filmesRepository.findAll();
    }

    @Override
    public Filmes save(Filmes filmes) {
        return filmesRepository.save(filmes);
    }

    @Override
    public void saveAllMovies(FormDTO formDTO) {
        Filmes filmes = new Filmes();
        filmes.setTitulo(formDTO.getTitulo());
        filmes.setEstudios(formDTO.getNomeEstudios());
        filmes.setGeneros(generoRepository.findAllByTipo(formDTO.getTipo()));
        filmes.setDescricao(formDTO.getDescricao());
        filmes.setAnoProducao(formatarData(formDTO.getAnoProducao()));
        filmes.setAvaliacoes(new Avaliacao(5));
        filmesRepository.save(filmes);
    }

    @Override
    public void update(FormDTO formDTO) {
        Set<Filmes> filmeId = filmesRepository.findAllById(formDTO.getId());

        for (Filmes filmes: filmeId) {
            filmes.setTitulo(formDTO.getTitulo());
            filmes.setEstudios(formDTO.getNomeEstudios());
            filmes.setGeneros(formDTO.generoId(formDTO.getGeneroId()));
            filmes.setDescricao(formDTO.getDescricao());
            filmes.setAnoProducao(formatarData(formDTO.getAnoProducao()));
            filmes.setAvaliacoes(new Avaliacao(5));
            filmesRepository.save(filmes);
        }
    }

    @Override
    public Set<Filmes> findMovieId(long id) {
        return filmesRepository.findAllById(id);
    }

    @Override
    public void delete(Filmes filme) {
        filmesRepository.delete(filme);
    }

}
