
public class Registradora {

    public static void main(String[] args) {
        primeiroBug();

        segundoBug();

        terceiroBug();

        quartoBug();

        quintoBug();

        sextoBug();
    }

    private static double registrarItem(String item, int quantidade) {
        double precoItem = RelacaoPesoPreco.retornaPrecoProduto(item, quantidade);

        if (QuantidadeMinimaItem.precisaReposicao(item)) {
            if ("pao".equals(item) || "sanduiche".equals(item) || "torta".equals(item)) {
                if (!DataProjeto.cozinhaEmFuncionamento()) {
                    System.out.println("Cozinha fechada!");
                    System.out.println("Desculpa!  O item (" + item + ") solicitado está indísponível. A quantidade restante em estoque é de "+ ItensPorQuantidade.getQuantidadeEstoque(item) + ".");
          
                    precoItem = 0;
                } else {
                    ReposicaoCozinha.reporItem(item);
                }
            }

            if ("leite".equals(item) || "cafe".equals(item)) {
                ReposicaoFornecedor.reporItem(item);
            }
        }

        if (precoItem != 0){
            ItensPorQuantidade.setQuantidadeEstoque(item, quantidade);

        }
        return precoItem;
    }

    private static void primeiroBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "sanduiche";
        int quantidade = 4;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println("----- BUG 1 -----");
        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void segundoBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "torta";
        int quantidade = 10;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println("----- BUG 2 -----");
        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void terceiroBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "cafe";
        int quantidade = 40;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println("----- BUG 3 -----");
        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void quartoBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        // Cliente 1
        String item = "sanduiche";
        int quantidade = 20;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println("----- BUG 4 -----");
        System.out.println("Cliente 1:");
        System.out.println(String.format("Valor total: %.2f", precoTotal));

        // Cliente 2
        String item2 = "sanduiche";
        int quantidade2 = 5;

        double precoTotal2 = registrarItem(item2, quantidade2);

        System.out.println("Cliente 2:");
        System.out.println(String.format("Valor total: %.2f", precoTotal2));
    }

    private static void quintoBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "pao";
        int quantidade = 10;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println("----- BUG 5 -----");
        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void sextoBug() {
        DataProjeto.criarDataComCozinhaEncerradaSemDiaUtil();
        // Cliente 1
        String item = "sanduiche";
        int quantidade = 20;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println("----- BUG 6 -----");
        System.out.println("Cliente 1:");
        System.out.println(String.format("Valor total: %.2f", precoTotal));

        // Cliente 2
        String item2 = "sanduiche";
        int quantidade2 = 5;

        double precoTotal2 = registrarItem(item2, quantidade2);

        System.out.println("Cliente 2:");
        System.out.println(String.format("Valor total: %.2f", precoTotal2));
    }

}
