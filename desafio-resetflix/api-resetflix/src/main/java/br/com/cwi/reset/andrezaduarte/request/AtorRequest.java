package br.com.cwi.reset.andrezaduarte.request;

import br.com.cwi.reset.andrezaduarte.model.StatusCarreira;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class AtorRequest {
    @NotNull (message = "Campo obrigatório não informado. Favor informar o campo Nome")
    private String nome;
    @NotNull (message = "Campo obrigatório não informado. Favor informar o campo Data de Nascimento")
    private LocalDate dataNascimento;
    private StatusCarreira statusCarreira;
    private Integer anoInicioAtividade;

    public AtorRequest(String nome, LocalDate dataNascimento, StatusCarreira statusCarreira, Integer anoInicioAtividade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.statusCarreira = statusCarreira;
        this.anoInicioAtividade = anoInicioAtividade;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public StatusCarreira getStatusCarreira() {
        return statusCarreira;
    }

    public Integer getAnoInicioAtividade() {
        return anoInicioAtividade;
    }
}
