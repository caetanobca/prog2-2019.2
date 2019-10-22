import java.util.Comparator;

import static java.util.Comparator.comparing;

public class Compra implements Comparable<Compra> {
    private Validacao validadorString;
    private String nomeProduto;
    private String descricaoProduto;
    private String data;
    private String cliente;
    private String fornecedor;
    private Comparator comparador;

    public Compra(String nomeproduto, String descricaoProduto, String data, String cliente, String fornecedor) {
        this.validadorString = new Validacao();
        this.validadorString.validaString(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
        this.validadorString.validaString(nomeproduto, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
        this.validadorString.validaString(descricaoProduto,"Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula");
        this.validadorString.validaString(descricaoProduto,"Erro ao cadastrar compra: nome nao pode ser vazio ou nulo");
        this.validadorString.validaString(fornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");

        this.data = data;
        this.nomeProduto = nomeproduto;
        this.descricaoProduto = descricaoProduto;
        this.cliente = cliente;
        this.fornecedor = fornecedor;
        this.comparador = new ComparadorPorNome();
    }

    public void setaComparator(CriterioOrdenacao a) {
        a = CriterioOrdenacao.FORNECEDOR;
        if (a  == CriterioOrdenacao.CLIENTE) {
            this.comparador = comparing(Compra:: getData).thenComparing(Compra:: getDescricaoProduto).thenComparing(Compra::getFornecedor).thenComparing(Compra::getCliente);
        }else if (a == CriterioOrdenacao.FORNECEDOR){
            this.comparador = comparing(Compra:: getFornecedor).thenComparing(Compra::getCliente).thenComparing(Compra::getDescricaoProduto).thenComparing(Compra::getData);
        }else if (a == CriterioOrdenacao.DATA){
            this.comparador = new ComparadorPorData();
        }
    }

    @Override
    public String toString() {
        return this.nomeProduto + " - "+this.data.replace("/", "-");
    }

    @Override
    public int compareTo(Compra o) {
        return this.descricaoProduto.compareTo(o.getDescricaoProduto());
    }
    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public String getData() {
        return data;
    }

    public String getCliente(){
        return this.cliente;
    }

    public String getFornecedor() {
        return fornecedor;
    }
}
