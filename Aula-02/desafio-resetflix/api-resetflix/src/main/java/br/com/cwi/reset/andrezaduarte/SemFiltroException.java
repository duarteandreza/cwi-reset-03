package br.com.cwi.reset.andrezaduarte;

public class SemFiltroException extends Exception {

    public SemFiltroException(String filtroNome) {

        super("Ator não encontrato com o filtro {filtroNome}, favor informar outro filtro.");

    }

}
