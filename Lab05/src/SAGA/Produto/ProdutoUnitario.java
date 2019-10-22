package SAGA.Produto;

import SAGA.Validacao;

import java.util.Objects;

/**
 * Classe criada para Representar um ProdutoUnitario.
 * Um ProdutoUnitario tem como atributos Nome, descricao e preco. O produto usa como identificador
 * unico seu nome e sua descricao.
 *
 * @author Caetano Albuquerque - UFCG
 */
public class ProdutoUnitario implements ProdutoInterface {

    /**
     * Nome do produto, que junto a sua descricao e o indentificador unico de produto
     */
    private String nome;

    /**
     * Descricao do produto, que junto ao seu nome e o indentificador unico de produto
     */
    private String descricao;

    /**
     * Preco do produto
     */
    private double preco;

    /**
     * Objeto que tem funcoes que permite saber se as entradas sao validas
     */
    private Validacao validador;

    /**
     * Cria um objeto do tipo produto a partir do nome, da descricao e do preco do produto
     * @param nome - nome do produto que junto a descricao e seu identificador unico
     * @param descricao - descricao do produto que junto ao seu nome e o indentificador unico
     * @param preco - preco inicial do produto
     */
    public ProdutoUnitario(String nome, String descricao, double preco) {
        this.validador = new Validacao();

        this.validador.validaString(nome, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
        this.validador.validaString(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");

        if (preco < 0){
            throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
        }

        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    /**
     * Metodo que edita o preco do produto
     * @param preco - novo preco
     */
    public void editarProduto(double preco) {
        if (preco < 0){
            throw new IllegalArgumentException("preco invalido.");
        }

        this.preco = preco;
    }

    /**
     * metodo que pega o preco do produto
     * @return preco do produto
     */
    public double getPreco() {
        return this.preco;
    }

    /**
     * Metodo que monta uma representacao textual do produto no formato <NOME - DESCRICAO - R$PRECO></NOME>
     * @return uma representacao textual do produto
     */
    @Override
    public String toString() {
        return this.nome + " - " + this.descricao + " - R$" + String.format("%.2f",this.preco);
    }

    /**
     * Metodo que analisa se dois objetos sao iguais a partir do seu nome e da sua descricao
     * @param o - objeto que sera comparado com o produto em questao
     * @return true caso os objetos tenham o nome e a descricao iguais e false caso nao
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoUnitario produto = (ProdutoUnitario) o;
        return nome.equals(produto.nome) &&
                descricao.equals(produto.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao);
    }

    /**
     * compara o tostring de produto
     * @param o - produto que sera comparado
     * @return um numero possitivo caso esse produto for "maior" que o produto o, um numero negativo se o
     * produto o for "maior" e zero se os produtos tiverem um valor "igual"
     */
    @Override
    public int compareTo(ProdutoInterface o) {
        return this.toString().compareTo(o.toString());
    }
}
