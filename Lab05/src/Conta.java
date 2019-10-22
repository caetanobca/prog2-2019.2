import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe criada para Representar uma Conta do cliente em um determinado fornecedor.
 * Uma conta e composta pelo fornecedor, um debito e um conjunto de compras
 *
 * @author Caetano Albuquerque - UFCG
 */
public class Conta {

    /**
     * nome do fornecedor
     */
    private String fornecedor;

    /**
     * quanto o cliente deve nesse fornecedor
     */
    private double debito;

    /**
     * todas as compras feitas pelo cliente nesse fornecedor
     */
    private List<Compra> compras;

    /**
     * objeto que tem um conjunto de funcoes para validar uma entrada
     */
    private Validacao validador;

    /**
     * nome do cliente
     */
    private String cliente;

    /**
     * Construtor de conta
     * @param fornecedor - nome do fornecedor
     * @param data - data em que a primeir compra foi feita
     * @param nomeproduto - nome do produto da primeira compra
     * @param descricaoProduto - descricao do produto da primeira compra
     * @param preco - preco do produto da primeira compra
     * @param cliente - nome do cliente
     */
    public Conta(String fornecedor, String data, String nomeproduto, String descricaoProduto, double preco, String cliente){
        this.validador = new Validacao();
        this.validador.validaString(fornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
        this.validador.validaString(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
        this.validador.validaString(nomeproduto, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");

        this.fornecedor = fornecedor;
        this.debito = 0;
        this.compras = new ArrayList<Compra>();
        this.cliente = cliente;
        this.adicionaProduto(nomeproduto, descricaoProduto, data, preco);
    }

    /**
     * Metodo que adiciona uma compra na conta
     * @param nomeproduto - nome do produto
     * @param descricaoProduto - descricao do produto comprado
     * @param data - data da compra
     * @param preco - preco da compra
     */
    public void adicionaProduto(String nomeproduto, String descricaoProduto, String data, double preco) {
        this.validador.validaString(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
        this.validador.validaString(nomeproduto, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
        this.validador.validaString(descricaoProduto,"Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula");
        this.debito += preco;

        this.compras.add(new Compra(nomeproduto, descricaoProduto, data, this.cliente, this.fornecedor));
    }

    /**
     * pega o valor que o cliente deve no fornecedor
     * @return o debito total do cliente neste fornecedor
     */
    public String getDebito() {
        return String.format("%.2f",this.debito).replace(",", ".");
    }

    /**
     * metodo que pega uma compra a partir do seu indice
     * @return um objeto do tipo compra
     */
    public Compra getCompras(int i) {
        return this.compras.get(i);
    }

    /**
     * pega o numero de compras ja cadastradas nessa conta
     * @return numero de compras ja feitas
     */
    public int getNumCompras() {
        return compras.size();
    }

    /**
     * uma representacao da conta no formato <compra1 | compra2 | ... | compraN>
     * @return uma representacao da conta
     */
    @Override
    public String toString() {
        String result = this.fornecedor + " | " ;
        for (int i = 0; i < this.compras.size(); i ++){
            result += this.compras.get(i).toString() + " | ";
        }
        return result.substring(0, result.length() - 3);
    }

    /**
     * compara dois objetos a partir do fornecedor
     * @param o - objeto que sera comparado
     * @return true caso os objetos forem iguais e false caso nao
     */
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
