package br.com.cwi.reset.andrezaduarte;

import java.time.LocalDate;

public class Diretor {
    private static Integer id;
    private String nome;
    private LocalDate dataNascimento;
    private Integer anoInicioAtividade;

    public static Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Integer getAnoInicioAtividade() {
        return anoInicioAtividade;
    }
}
