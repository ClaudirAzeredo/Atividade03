package br.ControleDeEstoque.com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variável para armazenar o produto
        Produto produto = null;

        // Loop para interação com o usuário
        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Adicionar novo produto");
            System.out.println("2. Atualizar preço ou quantidade");
            System.out.println("3. Exibir detalhes do produto");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            // Switch para lidar com as opções
            switch (opcao) {
                case 1:
                    System.out.print("\nNome do produto: ");
                    String nome = scanner.next();
                    System.out.print("Preço do produto: R$");
                    double preco = scanner.nextDouble();
                    System.out.print("Quantidade em estoque: ");
                    int quantidade = scanner.nextInt();
                    produto = new Produto(nome, preco, quantidade);
                    System.out.println("\nProduto adicionado com sucesso!");
                    break;

                case 2:
                    if (produto == null) {
                        System.out.println("\nNenhum produto cadastrado ainda. Por favor, adicione um produto primeiro.");
                    } else {
                        System.out.println("\n=== Atualizar ===");
                        System.out.println("1. Atualizar preço");
                        System.out.println("2. Atualizar quantidade");
                        System.out.print("Escolha uma opção: ");
                        int escolha = scanner.nextInt();
                        if (escolha == 1) {
                            System.out.print("\nNovo preço: R$");
                            double novoPreco = scanner.nextDouble();
                            produto.setPreco(novoPreco);
                            System.out.println("\nPreço atualizado com sucesso!");
                        } else if (escolha == 2) {
                            System.out.print("\nNova quantidade em estoque: ");
                            int novaQuantidade = scanner.nextInt();
                            produto.setQuantidadeEmEstoque(novaQuantidade);
                            System.out.println("\nQuantidade em estoque atualizada com sucesso!");
                        } else {
                            System.out.println("\nOpção inválida.");
                        }
                    }
                    break;

                case 3:
                    if (produto == null) {
                        System.out.println("\nNenhum produto cadastrado ainda. Por favor, adicione um produto primeiro.");
                    } else {
                        System.out.println("\n=== Detalhes do Produto ===");
                        produto.exibirDetalhes();
                    }
                    break;

                case 4:
                    System.out.println("\nSaindo...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("\nOpção inválida.");
            }
        }
    }
}