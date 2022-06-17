package br.com.filmesCadastroApi.repository;

import br.com.filmesCadastroApi.domain.Diretor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface DiretorRepository  extends JpaRepository<Diretor,Long> {
    Set<Diretor> findAllById(long id);
}
