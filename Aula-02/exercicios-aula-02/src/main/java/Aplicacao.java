public class Aplicacao {
    public static void main(String[] args) {
        Diretor diretor1 = new Diretor("João", 51, 40);
        Diretor diretor2 = new Diretor("Pedro", 45, 18);

        Filme filme1 = new Filme("Primeiro Filme", "Este é um filme de comédia", 98, 2015, 4.8, diretor1);
        Filme filme2 = new Filme("Segundo Filme", "Este é um filme de suspense", 123, 2008, 3.5, diretor2);

        filme1.reproduzirFilme();
        filme2.reproduzirFilme();
    }
}
