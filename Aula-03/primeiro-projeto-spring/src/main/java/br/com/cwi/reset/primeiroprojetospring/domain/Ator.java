package br.com.cwi.reset.primeiroprojetospring.domain;

import java.time.LocalDate;

public class Ator extends Pessoa{

    private int qtdOscars;


    public Ator(String nome, LocalDate dataNascimento, int qtdOscars, Genero genero) {
        super(nome, dataNascimento, genero);
        this.qtdOscars = qtdOscars;

    }

}