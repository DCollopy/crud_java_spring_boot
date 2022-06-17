package br.com.filmesCadastroApi.domain;


import lombok.Data;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class Avaliacao implements Serializable {
    private int pontos;

    public Avaliacao(int pontos) {
        this.pontos = pontos;
    }
    protected Avaliacao(){}
}
