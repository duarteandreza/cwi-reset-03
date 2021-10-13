package br.com.cwi.reset.andrezaduarte;

public class NenhumEncontradoIdException extends Exception {

    public NenhumEncontradoIdException() {

        super("Nenhum ator encontrado com o parâmetro id={campo}, favor verifique os parâmetros informados.");

    }
}
