package br.com.filmesCadastroApi.domain;


import lombok.Data;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import java.io.Serializable;
import java.util.Set;


@Data
@Entity
public class Diretor extends Perfil implements Serializable {

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Filmes> filmes;

    public Diretor(String nome, String sobrenome) {
        super(nome, sobrenome);
    }

    protected Diretor() {}
}
