package br.com.projeto.compras;

import br.com.projeto.compras.modelos.Cartao;
import br.com.projeto.compras.modelos.Compra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String compras;
        int valorProduto;
        int valorTotalProdutos = 0;
        int continuar;

        System.out.print("Digite o limite do seu cartão: ");
        int limite = sc.nextInt();

        Cartao cartao = new Cartao(limite);
        double analiseDeLimite = cartao.getLimite();

        List<Compra> listaCompras = new ArrayList<>();

        while(true) {
            System.out.print("Digite sua compra: ");
            compras = sc.next();

            System.out.print("Digite o valor do produto: ");
            valorProduto = sc.nextInt();

            if ((analiseDeLimite >= valorProduto) && (analiseDeLimite >= valorTotalProdutos) && (analiseDeLimite > 0)) {
                valorTotalProdutos += valorProduto;
                analiseDeLimite = cartao.getLimite() - valorTotalProdutos;

            } else {
                System.out.println("O valor do Produto ultrapassa o limite do seu cartão, não foi possível realizar a compra!");
                break;
            }

            if (compras != null && valorProduto != 0) {
                listaCompras.add(new Compra(compras, valorProduto));
                System.out.println("Produto Comprado");
            } else {
                System.out.println("Valores Inválidos!");
                break;
            }

            System.out.println("Deseja continuar? (0 para sair | 1 para continuar)");
            continuar = sc.nextInt();

            if (continuar != 1 && continuar != 0) {
                System.out.println("Valor invalido, digite novamente...");
                System.out.println("Deseja continuar? (0 para sair | 1 para continuar)");
                continuar = sc.nextInt();

            } else if (continuar == 0) {
                break;
            }

        }
        System.out.println("===========================\n");
        System.out.println("*** COMPRAS REALIZADAS ***\n");
        listaCompras.sort(Comparator.comparing(Compra::getValor));
        System.out.println(listaCompras);
        System.out.println("\n===========================");
        System.out.println("Valor total: " + valorTotalProdutos);
        System.out.println("Seu saldo: " + analiseDeLimite);
    }
}
