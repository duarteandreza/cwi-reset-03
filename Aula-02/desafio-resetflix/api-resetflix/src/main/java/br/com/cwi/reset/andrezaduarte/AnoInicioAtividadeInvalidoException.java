package br.com.cwi.reset.andrezaduarte;

public class AnoInicioAtividadeInvalidoException extends Exception{

    public AnoInicioAtividadeInvalidoException() {

        super("Ano de início de atividade inválido para o ator cadastrado.");

    }

}