package br.com.filmesCadastroApi.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Data
@MappedSuperclass
public class Perfil implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 100,nullable = false)
    private String nome;
    @Column(length = 100,nullable = false)
    private String sobrenome;


    public Perfil(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    protected Perfil() {
    }
}
