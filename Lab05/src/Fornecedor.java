import java.util.HashMap;
import java.util.Objects;

public class Fornecedor {

    /**
     * Nome do fornecedor, que e seu indentificador unico
     */
    private String nome;

    /**
     * Email do fornecedor
     */
    private String email;

    /**
     * Telefone do fornecedor
     */
    private String telefone;

    /**
     * Mapa que usa como chave uma string que e formada pela a concatenacao do nome e descricao de um produto
     * como chave e armazena objetos do tipo Produto
     */
    private HashMap<String, Produto> produtos;

    /**
     * Objeto que tem funcoes que permite saber se as strings sao validas
     */
    private Validacao validadorString;

    /**
     * Cria um fornecedor a partir de valores dados pelo o usuario
     * @param nome - nome do fornecedor, que e seu indentificador unico
     * @param email - email do fornecedor
     * @param telefone - telefone do fornecedor
     */
    public Fornecedor(String nome, String email, String telefone) {
        this.validadorString = new Validacao();

        this.validadorString.validaString(nome);
        this.validadorString.validaString(email);
        this.validadorString.validaString(telefone);

        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.produtos = new HashMap<>();
    }


    public void setEmail(String email) {
        this.validadorString.validaString(email);

        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.validadorString.validaString(telefone);

        this.telefone = telefone;
    }

    /**
     * Metodo que retorna uma representacao de um fornecedor
     * @return representacao do fornecedor no formato <NOME - EMAIL - TELEFONE></NOME>
     */
    @Override
    public String toString() {
        return this.nome + " - " + this.email + " - " + this.telefone;
    }

    /**
     * Metodo que cadastra um produto
     * @param nomeProduto - nome do produto, que junto a sua descricao e o indentificador unico do produto
     * @param descricao - descricao do produto, que junto a seu nome e o indentificador unico do produto
     * @param preco -preco do produto
     */
    public void cadastraProduto(String nomeProduto, String descricao, double preco) {
        this.validadorString.validaString(nomeProduto);
        this.validadorString.validaString(descricao);

        if (this.produtos.containsKey(nomeProduto)) {
            throw new IllegalArgumentException("Produto ja cadastrado");
        } else {
            this.produtos.put((nomeProduto + descricao), new Produto(nomeProduto, descricao, preco));

        }
    }

    /**
     * Retorna uma representacao de um produto.
     * @param nomeProduto - nome do produto, que junto a sua descricao e o indentificador unico do produto
     * @param descricao - descricao do produto, que junto a seu nome e o indentificador unico do produto
     * @return uma representacao textual de um produto
     */
    public String exibeProduto(String nomeProduto, String descricao) {
        this.validadorString.validaString(nomeProduto);
        this.validadorString.validaString(descricao);

        String result;

        if (this.produtos.containsKey(nomeProduto+descricao)){
            result = this.produtos.get(nomeProduto+descricao).toString();
        }else {
            result = "Produto nao cadastrado";
        }
        return result;
    }

    /**
     * Retorna uma string que lista todos os produtos que estao cadastrados no fornecedores
     * @return uma lista com todos os produtos cadastrados no fornecedor
     */
    public String listarProdutos() {
        String result = "";

        for (String nomeProduto : this.produtos.keySet()) {
            result += this.produtos.get(nomeProduto).toString() + " | ";
        }
        if (result.equals("")) {
            result = "Nenhum produto cadastrado pelo fornecedor: " + this.nome;
        } else {
            result = result.substring(0, result.length() - 3);
        }
        return result;
    }

    public String listarProdutosComNome() {
        String result = "";

        for (String nomeProduto : this.produtos.keySet()){
            result += this.nome + " - " + this.produtos.get(nomeProduto).toString() + " | ";
        }

        if (result.equals("")){
            result = "Nenhum produto cadastrado pelo fornecedor: " + this.nome;
        }else {
            result = result.substring(0, result.length() - 3);
        }

        return result;
    }

    public void editarProduto(String nomeProduto, String descricao, double novoPreco) {
        this.validadorString.validaString(nomeProduto);
        this.validadorString.validaString(descricao);

        if (this.produtos.containsKey(nomeProduto + descricao)){
            this.produtos.get(nomeProduto + descricao).setPreco(novoPreco);
        }
        else {
            throw new IllegalArgumentException("Produto nao cadastrado");
        }
    }

    public void removeProduto(String nomeProduto, String descricao) {
        this.validadorString.validaString(nomeProduto);
        this.validadorString.validaString(descricao);

        if (this.produtos.containsKey(nomeProduto + descricao)){
            this.produtos.remove(nomeProduto + descricao);
        }else {
            throw new IllegalArgumentException("Produto ja nao estava cadastrado");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fornecedor that = (Fornecedor) o;
        return nome.equals(that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
