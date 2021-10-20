package br.com.cwi.reset.primeiroprojetospring.domain;

import java.time.LocalDate;
import java.time.Period;

public class Pessoa {

    private String nome;
    private LocalDate dataNascimento;
    private Genero genero;

    public Pessoa(String nome, LocalDate dataNascimento, Genero genero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
    }

    public void dados() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + this.calcularIdade());
        System.out.println("Gênero: " + genero.getDescricao());
    }

    public String getNome() {
        return nome;
    }

    private Integer calcularIdade() {
        return Period.between(LocalDate.now(), dataNascimento).getYears();
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Genero getGenero() {
        return genero;
    }
}