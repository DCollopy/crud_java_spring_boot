package br.com.filmesCadastroApi.repository;

import br.com.filmesCadastroApi.model.Diretor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiretorRepository  extends JpaRepository<Diretor,Long> {
}
