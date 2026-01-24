package DesafiosRecruta.ecomerce.test;

import DesafiosRecruta.ecomerce.domain.*;

import java.util.Scanner;

public class EcomerceTest01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Carrinho carrinho = new Carrinho(new Produto[5]);

        while (true) {
            System.out.println("Menu: 1-Adicionar Produto | 0-Sair e Imprimir Relatório");
            String opcao = input.nextLine();

            if (opcao.equals("0")) {
                break;
            }
            if (!opcao.equals("1")) {
                continue;
            }

            System.out.println("Digite o nome do produto: ");
            String nome = input.nextLine();

            System.out.println("Digite o preço do produto: ");
            double preco = input.nextDouble();
            String limpar = input.nextLine();

            System.out.println("Categoria (1-VESTIARIO, 2-ELETRONICO, 3-LIVRO)");
            String categoriaOpcao = input.nextLine();

            Produto produtoGenerico = null;

            if (categoriaOpcao.equals("1")) {
                System.out.println("Digite o tamanho (P/M/G): ");
                String tamanho = input.nextLine();
                produtoGenerico = new Camiseta(nome, preco, Categoria.VESTUARIO, tamanho);
            } else if (categoriaOpcao.equals("2")) {
                System.out.println("Digite a Memória RAM (int): ");
                int memoria = input.nextInt();
                String limpar2 = input.nextLine();
                produtoGenerico = new Notebook(nome, preco, Categoria.ELETRONICO, memoria);
            } else if (categoriaOpcao.equals("3")) {
                produtoGenerico = new Produto(nome, preco, Categoria.LIVRO);
            } else {
                System.out.println("Categoria inválida! Tente novamente.");
                continue;
            }
            carrinho.adicionarProduto(produtoGenerico);
        }
            carrinho.imprimeRelatorio();
    }
}
