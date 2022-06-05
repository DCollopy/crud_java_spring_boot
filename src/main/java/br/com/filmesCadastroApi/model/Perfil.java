package br.com.filmesCadastroApi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 100,nullable = false)
    private String nome;
    @Column(length = 100,nullable = false)
    private String sobrenome;

}
