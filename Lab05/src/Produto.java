import java.util.Objects;

public class Produto {

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
    private Validacao validadorString;

    /**
     * Cria um objeto do tipo produto a partir do nome, da descricao e do preco do produto
     * @param nome - nome do produto que junto a descricao e seu identificador unico
     * @param descricao - descricao do produto que junto ao seu nome e o indentificador unico
     * @param preco - preco inicial do produto
     */
    public Produto(String nome, String descricao, double preco) {
        this.validadorString = new Validacao();

        this.validadorString.validaString(nome, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
        this.validadorString.validaString(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");

        if (preco < 0){
            throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
        }

        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    /**
     * Metodo que monta uma representacao textual do produto no formato <NOME - DESCRICAO - R$PRECO></NOME>
     * @return uma representacao textual do produto
     */
    @Override
    public String toString() {
        return this.nome + " - " + this.descricao + " - R$" + String.format("%.2f",this.preco);
    }

    public void setPreco(double preco) {
        if (preco < 0){
            throw new IllegalArgumentException("preco invalido.");
        }

        this.preco = preco;
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
        Produto produto = (Produto) o;
        return nome.equals(produto.nome) &&
                descricao.equals(produto.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao);
    }
}
