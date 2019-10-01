import java.util.Objects;

public class Produto {

    private String nome;
    private String descricao;
    private double preco;

    private Validacao validadorString;

    public Produto(String nome, String descricao, double preco) {
        this.validadorString = new Validacao();
        this.validadorString.validaString(nome);
        this.validadorString.validaString(descricao);

        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return this.nome + " - " + this.descricao + " - R$" + String.format("%.2f",this.preco);
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

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
