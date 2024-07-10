package carrinhodecompras.modelos;

import java.util.Collections;
import java.util.Scanner;

public class Menu {
    public void menuDeCompras(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vinde ao Carrinho de Compras");
        System.out.println("\nInforme o limite do seu cartão de crédito: ");
        double saldo = scanner.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(saldo);

        int opcao = 0;

        do {
            System.out.println("\n1 - Comprar");
            System.out.println("2 - Consultar saldo");
            System.out.println("9 - Sair;");
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Informe o produto da compra: ");
                    String produto = scanner.next();

                    System.out.println("Informe o valor do produto: ");
                    double valor = scanner.nextDouble();

                    Compra compra = new Compra(produto, valor);
                    boolean compraRealizada = cartao.lancaCompra(compra);

                    if (compraRealizada) {
                        System.out.println("Compra realizada!");
                    } else {
                        System.out.println("Saldo insuficiente");
                        System.out.println("Você voltou ao menu de compras");
                    }
                    break;
                case 2:
                    System.out.println("\nSaldo do cartão: R$ " + cartao.getSaldo());
                    break;
                case 9:
                    opcao = 9;
                    break;
                default:
                    System.out.println("Escolha uma opção válida");
                    break;
            }


        } while (opcao != 9);

        scanner.close();

        System.out.println("***********************");
        System.out.println("COMPRAS REALIZADAS:\n");
        Collections.sort(cartao.getCompras());
        for (Compra c : cartao.getCompras()) {
            System.out.println(c.getProduto() + " - " +c.getValor());
        }
        System.out.println("\n***********************");
    }
}
