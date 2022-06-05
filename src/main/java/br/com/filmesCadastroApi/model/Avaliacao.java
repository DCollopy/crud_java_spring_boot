package br.com.filmesCadastroApi.model;

import lombok.Data;

import javax.persistence.Embeddable;


@Data
@Embeddable
public class Avaliacao {

    private int pontos;
}
