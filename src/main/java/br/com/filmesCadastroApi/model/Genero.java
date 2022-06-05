package br.com.filmesCadastroApi.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Genero {

    private String tipo;
}
