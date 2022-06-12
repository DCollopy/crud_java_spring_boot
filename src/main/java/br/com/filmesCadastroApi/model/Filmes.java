package br.com.filmesCadastroApi.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;
import static javax.persistence.CascadeType.ALL;

@Entity
public class Filmes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 100,nullable = false)
    private String titulo;
    @Column(length = 500)
    private String descricao;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate anoProducao;

    @Embedded
    private Estudio estudios;
    @ManyToMany(cascade = ALL)
    private Set<Genero> generos;
    @Embedded
    private Avaliacao avaliacoes;
    @ManyToMany(cascade = ALL)
    private Set<Diretor> diretores;
    @ManyToMany(cascade = ALL)
    private Set<Autor> autores;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getAnoProducao() {
        return anoProducao;
    }

    public void setAnoProducao(LocalDate anoProducao) {
        this.anoProducao = anoProducao;
    }

    public Estudio getEstudios() {
        return estudios;
    }

    public void setEstudios(Estudio estudios) {
        this.estudios = estudios;
    }

    public Set<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(Set<Genero> generos) {
        this.generos = generos;
    }

    public Avaliacao getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(Avaliacao avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public Set<Diretor> getDiretores() {
        return diretores;
    }

    public void setDiretores(Set<Diretor> diretores) {
        this.diretores = diretores;
    }

    public Set<Autor> getAutores() {
        return autores;
    }

    public void setAutores(Set<Autor> autores) {
        this.autores = autores;
    }
}
