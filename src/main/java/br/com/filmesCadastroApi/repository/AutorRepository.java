package br.com.filmesCadastroApi.repository;
import br.com.filmesCadastroApi.domain.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AutorRepository extends JpaRepository<Autor,Long> {
    Set<Autor> findAutorByNomeAndSobrenome(String nome, String sobrenome);
    Set<Autor> findAutorById(long id);

}
