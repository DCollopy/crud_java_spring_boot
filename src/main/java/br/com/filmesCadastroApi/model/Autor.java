package br.com.filmesCadastroApi.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Data
@Entity
public class Autor extends Perfil implements Serializable {

    @ManyToMany(cascade = ALL)
    private Set<Filmes> filmes;
}
