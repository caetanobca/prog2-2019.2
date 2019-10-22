/**
 * Classe criada para Representar um Combo.
 * Um combo tem como atributos Nome, descricao, precoe o fator de desconto. O produto usa como identificador
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
    private Validacao validador;

    /**
     * Metodo que cria um combo a partir do seu nome, o preco original, a descricao e o fator de desconto
     * @param nomeCombo - nome do combo
     * @param descricaoCombo - descricao do combo
     * @param fator - fator de desconto sobre o preco total dos itens
     * @param preco - preco total d os intens que formam o combo
     */
    public Combo(String nomeCombo, String descricaoCombo, double fator, double preco) {
        this.validador = new Validacao();

        this.validador.validaString(nomeCombo, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
        this.validador.validaString(descricaoCombo, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");

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

    /**
     * Metodo que edita o fator de desconto do produto
     * @param fator
     */
    public void editarProduto(double fator) {
        if (fator < 0 || fator > 1){
            throw new IllegalArgumentException("fator invalido.");
        }
        this.fator = fator;
    }

    /**
     * Calcula o preco do combo, que e o preco total dos produtos com o desconto determinado pelo usuario
     * @return preco final do combo
     */
    public double getPreco() {
        return (this.preco - (this.preco * this.fator));
    }

    /**
     * compara a partir do toString
     * @param o - outro produto que sera comparado
     * @return um numero negativo se esse produto for "menor" que o produto "o", um numero possitivo caso o produto "o"
     * for maior e zero caso os dois sejam iguais
     */
    @Override
    public int compareTo(ProdutoInterface o) {
        return this.toString().replace("+", "-").compareTo(o.toString().replace("+", "-"));
    }

}
