import java.util.Objects;

/**
 * Classe criada para Representar um Combo.
 * Um ProdutoUnitario tem como atributos Nome, descricao e preco. O produto usa como identificador
 * unico seu nome e sua descricao.
 *
 * @author Caetano Albuquerque - UFCG
 */
public class Combo implements ProdutoInterface {

    /**
     * Nome do combo, que junto a sua descricao e o indentificador unico de combo
     */
    private String nome;

    /**
     * Descricao do combo, que junto ao seu nome e o indentificador unico de produto
     */
    private String descricao;

    /**
     * Preco do combo
     */
    private double preco;

    /**
     * fator do desconto do combo
     */
    private double fator;

    /**
     * Objeto que tem funcoes que permite saber se as entradas sao validas
     */
    private Validacao validadorString;


    public Combo(String nomeCombo, String descricaoCombo, double fator, double preco) {
        this.validadorString = new Validacao();

        this.validadorString.validaString(nomeCombo, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
        this.validadorString.validaString(descricaoCombo, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");

        if (fator < 0 || fator>1){
            throw new IllegalArgumentException("Erro no cadastro de combo: fator invalido.");
        }else if (preco<0){
            throw new IllegalArgumentException("Erro no cadastro de combo: preco invalido.");

        }

        this.nome = nomeCombo;
        this.descricao = descricaoCombo;
        this.fator = fator;
        this.preco = preco;
    }

    /**
     * Metodo que monta uma representacao textual do combo no formato <NOME - DESCRICAO - R$PRECO>
     * @return uma representacao textual do comobo
     */
    @Override
    public String toString() {
        double precoComDesconto = this.preco - (this.preco * this.fator);
        return this.nome + " - " + this.descricao + " - R$" + String.format("%.2f",precoComDesconto);
    }

    public void editarProduto(double fator) {
        if (fator < 0 || fator > 1){
            throw new IllegalArgumentException("fator invalido.");
        }
        this.fator = fator;
    }

    public double getPreco() {
        return (this.preco - (this.preco * this.fator));
    }

    @Override
    public int compareTo(ProdutoInterface o) {
        return this.toString().replace("+", "-").compareTo(o.toString().replace("+", "-"));
    }

}
