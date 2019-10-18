import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Conta {

    private String fornecedor;
    private double debito;
    private List<Compra> compras;

    private Validacao validadorString;

    public Conta(String fornecedor, String data, String nomeproduto, String descricaoProduto, double preco){
        this.validadorString = new Validacao();
        this.validadorString.validaString(fornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
        this.validadorString.validaString(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
        this.validadorString.validaString(nomeproduto, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");

        this.fornecedor = fornecedor;
        this.debito = 0;
        this.compras = new ArrayList<Compra>();
        this.adicionaProduto(nomeproduto, descricaoProduto, data, preco);
    }

    public void adicionaProduto(String nomeproduto, String descricaoProduto, String data, double preco) {
        this.validadorString.validaString(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
        this.validadorString.validaString(nomeproduto, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
        this.validadorString.validaString(descricaoProduto,"Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula");
        this.debito += preco;

        this.compras.add(new Compra(nomeproduto, descricaoProduto, data));
    }

    public String getDebito() {
        return String.format("%.2f",this.debito).replace(",", ".");
    }

    @Override
    public String toString() {
        String result = this.fornecedor + " | " ;
        for (int i = 0; i < this.compras.size(); i ++){
            result += this.compras.get(i).toString() + " | ";
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

    public String getContaOrdenada(String nomeCliente) {
        String result = "";

        Collections.sort(this.compras);

        for (int i = 0; i < this.compras.size(); i++){
            result += nomeCliente + ", " + this.fornecedor + ", "
                    + this.compras.get(i).getDescricaoProduto() + ", " + this.compras.get(i).getData() + " | ";
        }
        return result;
    }
}
