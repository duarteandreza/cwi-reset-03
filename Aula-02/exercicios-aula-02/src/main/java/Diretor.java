public class Diretor {

    private String nome;
    private int idade;
    private int qtdFilmesDirigidos;
    private Genero GENERO;

    public Diretor(String nome, int idade, int qtdFilmesDirigidos, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.qtdFilmesDirigidos = qtdFilmesDirigidos;
    }

    public String getNome() {
        return nome;
    }
}
