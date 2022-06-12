package br.com.filmesCadastroApi.repository;

import br.com.filmesCadastroApi.model.Filmes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmesRepository extends JpaRepository<Filmes,Long> {
}
