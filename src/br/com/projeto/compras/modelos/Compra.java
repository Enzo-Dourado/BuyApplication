package br.com.projeto.compras.modelos;

public class Compra {

    private String nomeProduto;
    private int valor;

    public Compra(String nomeProduto, int valor) {
        this.nomeProduto = nomeProduto;
        this.valor = valor;
    }
    public String getNomeProduto() {
        return nomeProduto;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Compra: " + getNomeProduto() + ", valor = " + getValor();
    }

}
