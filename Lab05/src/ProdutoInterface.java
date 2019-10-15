public interface ProdutoInterface extends Comparable<ProdutoInterface> {
    public String toString ();

    public double getPreco();

    public void editarProduto(double novoValor);
}
