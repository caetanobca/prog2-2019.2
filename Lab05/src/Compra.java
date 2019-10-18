public class Compra implements Comparable<Compra> {
    private Validacao validadorString;
    private String nomeProduto;
    private String descricaoProduto;
    private String data;

    public Compra(String nomeproduto, String descricaoProduto, String data) {
        this.validadorString = new Validacao();
        this.validadorString.validaString(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
        this.validadorString.validaString(nomeproduto, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
        this.validadorString.validaString(descricaoProduto,"Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula");

        this.data = data;
        this.nomeProduto = nomeproduto;
        this.descricaoProduto = descricaoProduto;
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
}
