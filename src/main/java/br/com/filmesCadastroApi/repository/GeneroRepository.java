package br.com.filmesCadastroApi.repository;


import br.com.filmesCadastroApi.domain.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Set;

@Repository
public interface GeneroRepository extends JpaRepository<Genero,Long> {
    Set<Genero> findAllByTipo(String tipo);

    Set<Genero> findAllById(long id);
}
