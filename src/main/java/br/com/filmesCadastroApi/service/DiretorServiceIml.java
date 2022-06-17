package br.com.filmesCadastroApi.service;

import br.com.filmesCadastroApi.domain.Diretor;
import br.com.filmesCadastroApi.domain.Filmes;
import br.com.filmesCadastroApi.repository.DiretorRepository;
import br.com.filmesCadastroApi.repository.FilmesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DiretorServiceIml implements DiretorService{

    private final DiretorRepository diretorRepository;
    private final FilmesRepository filmesRepository;

    public DiretorServiceIml(DiretorRepository diretorRepository, FilmesRepository filmesRepository) {
        this.diretorRepository = diretorRepository;
        this.filmesRepository = filmesRepository;
    }

    @Override
    public Optional<Diretor> findOne(long id) {
        return diretorRepository.findById(id);
    }

    @Override
    public List<Diretor> findAll() {
        return diretorRepository.findAll();
    }

    @Override
    public Diretor save(Diretor diretor) {
        return diretorRepository.save(diretor);
    }

    @Override
    public void saveDiretorFilme(long id, String nome, String sobrenome) {
        Diretor diretores = diretorRepository.save(new Diretor(nome,sobrenome));

        Set<Diretor> diretorId = diretorRepository.findAllById(diretores.getId());
        Set<Filmes> filmesId = filmesRepository.findAllById(id);

        diretores.setFilmes(filmesId);
        diretorRepository.save(diretores);

        for (Filmes filmes: filmesId) {
            filmes.setDiretores(diretorId);
            filmesRepository.save(filmes);
        }
    }
}
