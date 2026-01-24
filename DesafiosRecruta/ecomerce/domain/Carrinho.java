package DesafiosRecruta.ecomerce.domain;

public class Carrinho {
    private Produto[] produtos;

    public Carrinho(Produto[] produtos) {
        this.produtos = produtos;
    }

    public void adicionarProduto(Produto produto) {
        for (int i = 0; i < 5; i++) {

            if (produtos[i] == null) {
                produtos[i] = produto;
                return;
            }
            if (i == 4) {
                System.out.println("Carrinho cheio!");
                return;
            }
        }
    }

    public void imprimeRelatorio() {
        System.out.println("---- RELATÓRIO DO CARRINHO ----");
        double total = 0;
        for (Produto produto : produtos) {
            if (produto != null) {
                produto.imprime();
                System.out.println("--------------");
                double imposto = produto.getCategoria().calcularImposto(produto.getPreco());
                total += imposto + produto.getPreco();
            }
        }

        System.out.println("VALOR TOTAL A PAGAR : R$ " + total);

    }


    public Produto[] getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto[] produtos) {
        this.produtos = produtos;
    }
}
