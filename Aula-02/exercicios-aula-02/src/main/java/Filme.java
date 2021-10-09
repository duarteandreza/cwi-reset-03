public class Filme {

    private String nome;
    private String descricao;
    private int duracaoMinutos;
    private int anoLancamento;
    private double notaAvaliacao;
    private Diretor diretor;

    public Filme(String nome, String descricao, int duracaoMinutos, int anoLancamento, double notaAvaliacao, Diretor diretor) {
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


    }
