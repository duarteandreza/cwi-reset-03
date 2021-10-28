package br.com.cwi.reset.andrezaduarte.request;

import br.com.cwi.reset.andrezaduarte.model.TipoAtuacao;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class PersonagemRequest {
    @NotNull (message = "Campo obrigatório não informado. Favor informar o campo Id do Ator.")
    private Integer idAtor;
    @NotNull (message = "Campo obrigatório não informado. Favor informar o campo Nome do Personagem.")
    private String nomePersonagem;
    @NotNull (message = "Campo obrigatório não informado. Favor informar o campo Descrição.")
    private String descricaoPersonagem;
    @NotNull (message = "Campo obrigatório não informado. Favor informar o campo Tipo de Atuação.")
    private TipoAtuacao tipoAtuacao;

    public PersonagemRequest(Integer idAtor, String nomePersonagem, String descricaoPersonagem, TipoAtuacao tipoAtuacao) {
        this.idAtor = idAtor;
        this.nomePersonagem = nomePersonagem;
        this.descricaoPersonagem = descricaoPersonagem;
        this.tipoAtuacao = tipoAtuacao;
    }

    public Integer getIdAtor() {
        return idAtor;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public String getDescricaoPersonagem() {
        return descricaoPersonagem;
    }

    public TipoAtuacao getTipoAtuacao() {
        return tipoAtuacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonagemRequest that = (PersonagemRequest) o;
        return Objects.equals(idAtor, that.idAtor) && Objects.equals(nomePersonagem, that.nomePersonagem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAtor, nomePersonagem);
    }
}