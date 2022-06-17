package br.com.filmesCadastroApi.repository;

import br.com.filmesCadastroApi.domain.Filmes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface FilmesRepository extends JpaRepository<Filmes,Long> {
    Set<Filmes> findAllById(long id);
    List<Filmes> findFilmesByTitulo(String titulo);
    List<Filmes> findFilmesByGeneros(String tipo);
}
