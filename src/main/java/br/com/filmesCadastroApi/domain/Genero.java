package br.com.filmesCadastroApi.domain;

import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Data
@Entity
public class Genero implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100)
    private String tipo;

    @ManyToMany(cascade =CascadeType.PERSIST)
    private Set<Filmes> filmes;
    public Genero(long id) {
        this.id = id;
    }
    public Genero() {}

    public Genero(String tipo) {
        this.tipo = tipo;
    }
}
