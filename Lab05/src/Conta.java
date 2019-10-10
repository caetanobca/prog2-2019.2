import java.util.List;

public class Conta {

    private String fornecedor;
    private double debito;
    private List<String> compras;

    public Conta(String fornecedor, String data, String nomeproduto, double preco){
        this.fornecedor = fornecedor;
        this.debito = 0;
        this.adicionaProduto(nomeproduto, data, preco);
    }

    private void adicionaProduto(String nomeproduto, String data, double preco) {
        this.debito += preco;
        this.compras.add(nomeproduto + " - " + data);
    }

    public double getDebito() {
        return this.debito;
    }

    @Override
    public String toString() {
        String result = this.fornecedor;
        for (int i = 0; i < this.compras.size(); i++){
            result += this.compras.get(i);
        }
        return result;
    }
}
