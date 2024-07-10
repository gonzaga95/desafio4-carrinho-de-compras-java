package carrinhodecompras.modelos;

public class Compra {
    private String produto;
    private double valor;

    public Compra(String produto, double valor) {
        this.produto = produto;
        this.valor = valor;
    }

    public String getProduto() {
        return produto;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Compra: \nProduto: " + produto + "\nValor: " + valor;
    }
}
