package br.com.cwi.reset.andrezaduarte.request;

import br.com.cwi.reset.andrezaduarte.model.Genero;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public class FilmeRequest {
    @NotNull (message = "Campo obrigatório não informado. Favor informar o campo Nome.")
    private String nome;
    @NotNull (message = "Campo obrigatório não informado. Favor informar o campo Ano de Lançamento.")
    private Integer anoLancamento;
    @NotNull (message = "Campo obrigatório não informado. Favor informar o campo Capa do Filme.")
    private String capaFilme;
    @NotNull (message = "Campo obrigatório não informado. Favor informar o campo Gênero.")
    private List<Genero> generos;
    @NotNull (message = "Campo obrigatório não informado. Favor informar o campo Id do Diretor.")
    private Integer idDiretor;
    @NotNull (message = "Campo obrigatório não informado. Favor informar o campo Id do Estúdio.")
    private Integer idEstudio;
    @NotNull (message = "Campo obrigatório não informado. Favor informar o campo Resumo.")
    private String resumo;
    @NotNull (message = "Campo obrigatório não informado. Favor informar o campo Personagens.")
    private List<PersonagemRequest> personagens;

    public FilmeRequest(String nome, Integer anoLancamento, String capaFilme, List<Genero> generos, Integer idDiretor, Integer idEstudio, String resumo, List<PersonagemRequest> personagens) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.capaFilme = capaFilme;
        this.generos = generos;
        this.idDiretor = idDiretor;
        this.idEstudio = idEstudio;
        this.resumo = resumo;
        this.personagens = personagens;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public String getCapaFilme() {
        return capaFilme;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public Integer getIdDiretor() {
        return idDiretor;
    }

    public Integer getIdEstudio() {
        return idEstudio;
    }

    public String getResumo() {
        return resumo;
    }

    public List<PersonagemRequest> getPersonagens() {
        return personagens;
    }
}