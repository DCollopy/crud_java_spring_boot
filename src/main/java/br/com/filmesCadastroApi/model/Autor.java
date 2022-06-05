package br.com.filmesCadastroApi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Data
@Entity
public class Autor extends Perfil{

    @ManyToMany(cascade = ALL)
    private List<Filmes> filmes_id;
}
