package br.com.filmesCadastroApi.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Validacao {

    public static LocalDate formatarData(String anoProducao){

        return LocalDate.parse(anoProducao, DateTimeFormatter.ISO_DATE);
    }
}
