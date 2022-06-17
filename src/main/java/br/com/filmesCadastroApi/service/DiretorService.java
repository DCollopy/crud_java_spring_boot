package br.com.filmesCadastroApi.service;


import br.com.filmesCadastroApi.domain.Diretor;

import java.util.List;
import java.util.Optional;

public interface DiretorService {
    Optional<Diretor> findOne(long id);

    List<Diretor> findAll();

    Diretor save(Diretor diretor);

    void saveDiretorFilme(long id,String nome,String sobrenome);
}
