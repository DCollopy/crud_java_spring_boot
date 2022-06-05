package br.com.filmesCadastroApi.model;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import static javax.persistence.CascadeType.ALL;


@Data
@Entity
public class Diretor extends Perfil {

    @ManyToOne(cascade = ALL)
    private Filmes filmes_id;
}
