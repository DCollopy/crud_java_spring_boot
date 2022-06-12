package br.com.filmesCadastroApi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable

public class Estudio implements Serializable {
    private String nome;
    protected Estudio(){}
    public Estudio(String nome) {
        this.nome = nome;
    }
}
