package br.com.filmesCadastroApi.model;

import br.com.filmesCadastroApi.domain.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class FormDTO {
    private  long id;

    private long generoId;

    private String titulo;

    private String descricao;

    private String anoProducao;

    private Estudio nomeEstudios;

    private String tipo;

    private String nome;

    private String sobrenome;

    public Set<Autor> autor(String nome, String sobrenome){
        Set<Autor> autores = new HashSet<>();
        Autor autors = new Autor(nome,sobrenome);

        autores.add(autors);
        return autores;
    }

    public Set<Diretor> diretor(String nome, String sobrenome){
        Set<Diretor> diretores = new HashSet<>();
        Diretor diretor = new Diretor(nome,sobrenome);

        diretores.add(diretor);
        return diretores;
    }

    public Set<Genero> generoId(long id){
        Set<Genero> generos = new HashSet<>();
        Genero gen = new Genero(id);

        generos.add(gen);
        return generos;
    }
    public Set<Genero> generoTipo(String tipo){
        Set<Genero> generos = new HashSet<>();
        Genero gen = new Genero(tipo);

        generos.add(gen);
        return generos;
    }



}
