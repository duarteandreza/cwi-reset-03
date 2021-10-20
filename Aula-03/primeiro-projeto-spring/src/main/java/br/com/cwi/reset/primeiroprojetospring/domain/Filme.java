package br.com.cwi.reset.primeiroprojetospring.domain;

public class Filme {

    private String nome;
    private String descricao;
    private int duracaoMinutos;
    private int anoLancamento;
    private double notaAvaliacao;
    private Diretor diretor;

    public Filme(String nome, String descricao, int duracaoMinutos, int anoLancamento, double notaAvaliacao, Diretor diretor) throws AvaliacaoForaDoPadraoException {
        if (notaAvaliacao < 1 || notaAvaliacao > 5) {
            throw new AvaliacaoForaDoPadraoException();
        }

        this.nome = nome;
        this.descricao = descricao;
        this.duracaoMinutos = duracaoMinutos;
        this.anoLancamento = anoLancamento;
        this.notaAvaliacao = notaAvaliacao;
        this.diretor = diretor;

    }

    public void reproduzirFilme() {
        System.out.println("Nome do filme: " + nome);
        System.out.println("Descrição: " + descricao);
        System.out.println("Duração: " + duracaoMinutos + "min");
        System.out.println("Diretor: " + diretor.getNome());
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public double getNotaAvaliacao() {
        return notaAvaliacao;
    }

    public Diretor getDiretor() {
        return diretor;
    }


}
