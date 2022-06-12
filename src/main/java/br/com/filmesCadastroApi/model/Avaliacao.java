package br.com.filmesCadastroApi.model;


import lombok.Data;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class Avaliacao implements Serializable {
    private int pontos;

}
