package br.com.cwi.reset.andrezaduarte;

public class DataNascimentoInvalidaException extends Exception {

    public DataNascimentoInvalidaException() {

        super("Não é possível cadastrar atores não nascidos.")

    }

}
