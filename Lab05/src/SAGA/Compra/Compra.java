package SAGA.Compra;

import SAGA.Validacao;

import static java.util.Comparator.comparing;

/**
 * Classe criada para Representar uma compra.
 * Uma compra e composta pelo produto que foi comprado, pelo cliente que fez a compra, pelo fornecedor que efetuou
 * a venda e pela a data da compra
 *
 * @author Caetano Albuquerque - UFCG
 */
public class Compra{

    /**
     * objeto que tem funcoes para validar as entradas
     */
    private Validacao validador;

    /**
     * nome do produto vendido
     */
    private String nomeProduto;

    /**
     * descricao do produto vendido
     */
    private String descricaoProduto;

    /**
     * data em que a compra foi feita
     */
    private String data;

    /**
     * nome do cliente que realizou a compra
     */
    private String cliente;

    /**
     * nome do fornecedor no qual a compra foi feita
     */
    private String fornecedor;

    /**
     * Construtor de compra
     * @param nomeproduto - nome do produto que foi comprado
     * @param descricaoProduto - descricao do produto que foi comprado
     * @param data - data em que a compra foi feita
     * @param cliente - nome do cliente que realizou a compra
     * @param fornecedor - nome do fornecedor que realizou a venda
     */
    public Compra(String nomeproduto, String descricaoProduto, String data, String cliente, String fornecedor) {
        this.validador = new Validacao();
        this.validador.validaString(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
        this.validador.validaString(nomeproduto, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
        this.validador.validaString(descricaoProduto,"Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula");
        this.validador.validaString(descricaoProduto,"Erro ao cadastrar compra: nome nao pode ser vazio ou nulo");
        this.validador.validaString(fornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");

        this.data = data;
        this.nomeProduto = nomeproduto;
        this.descricaoProduto = descricaoProduto;
        this.cliente = cliente;
        this.fornecedor = fornecedor;
    }

    /**
     * pega a descricao do produto que foi comprado
     * @return descricao do produto
     */
    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    /**
     * pega a data em que a compra foi feita
     * @return data da compra
     */
    public String getData() {
        return data;
    }

    /**
     * pega o nome do cliente que realizou a compra
     * @return nome do cliente
     */
    public String getCliente(){
        return this.cliente;
    }

    /**
     * pega o nome do fornecedor que realizou a venda
     * @return- nome do fornecedor
     */
    public String getFornecedor() {
        return fornecedor;
    }

    /**
     * monta uma representacao da compra, no formato <nomeProduto - data>
     * @return uma representacao da compra
     */
    @Override
    public String toString() {
        return this.nomeProduto + " - "+this.data.replace("/", "-");
    }
}
