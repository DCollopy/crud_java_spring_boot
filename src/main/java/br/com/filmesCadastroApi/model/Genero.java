package br.com.filmesCadastroApi.model;

import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Data
@Entity
public class Genero implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100)
    private String tipo;

    @ManyToMany(cascade = ALL)
    private Set<Filmes> filmes;

}
