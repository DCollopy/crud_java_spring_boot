package br.com.filmesCadastroApi.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Data
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
    @Embedded
    private Genero generos;
    @Embedded
    private Avaliacao avaliacoes;
    @OneToMany(cascade = ALL)
    private List<Diretor> diretores_id;
    @ManyToMany(cascade = ALL)
    private List<Autor> autores_id;



}
