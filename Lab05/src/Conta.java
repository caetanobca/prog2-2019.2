import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Conta {

    private String fornecedor;
    private double debito;
    private List<String> compras;

    private Validacao validadorString;

    public Conta(String fornecedor, String data, String nomeproduto, double preco){
        this.validadorString = new Validacao();
        this.validadorString.validaString(fornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
        this.validadorString.validaString(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
        this.validadorString.validaString(nomeproduto, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");

        this.fornecedor = fornecedor;
        this.debito = 0;
        this.compras = new ArrayList<String >();
        this.adicionaProduto(nomeproduto, data, preco);
    }

    public void adicionaProduto(String nomeproduto, String data, double preco) {
        this.validadorString.validaString(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
        this.validadorString.validaString(nomeproduto, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
        this.debito += preco;

        this.compras.add(nomeproduto + " - " + data);
    }

    public String getDebito() {
        return String.format("%.2f",this.debito).replace(",", ".");
    }

    @Override
    public String toString() {
        String result = this.fornecedor + " | " ;
        for (int i = 0; i < this.compras.size(); i++){
            result += this.compras.get(i).replace("/", "-") + " | ";
        }
        return result.substring(0, result.length() - 3);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return fornecedor.equals(conta.fornecedor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fornecedor);
    }

}
