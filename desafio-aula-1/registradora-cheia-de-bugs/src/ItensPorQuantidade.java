public class ItensPorQuantidade {

    static int pao = 3600;
    static int torta = 64;
    static int sanduiche = 20;
    static int leite = 20;
    static int cafe = 20;

    static int getQuantidadeEstoque(String item) {
        if ("pao".equals(item)) {
            return ItensPorQuantidade.pao;
        }
        if ("torta".equals(item)) {
            return ItensPorQuantidade.torta;
        }
        if ("sanduiche".equals(item)) {
            return ItensPorQuantidade.sanduiche;
        }
        if ("leite".equals(item)) {
            return ItensPorQuantidade.leite;
        }
        if ("cafe".equals(item)){
            return ItensPorQuantidade.cafe;
        }
    return 0;
    }

    static void setQuantidadeEstoque(String item, int quantidade) {
        if ("pao".equals(item)) {
            ItensPorQuantidade.pao -= quantidade;
        }
        if ("torta".equals(item)) {
            ItensPorQuantidade.torta -= quantidade;
        }
        if ("sanduiche".equals(item)) {
            ItensPorQuantidade.sanduiche -= quantidade;
        }
        if ("leite".equals(item)) {
            ItensPorQuantidade.leite -= quantidade;
        }
        if ("cafe".equals(item)) {
            ItensPorQuantidade.cafe -= quantidade;
        }

    }

}
