import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;

/**
 * Classe criada para Representar um Fornecedor
 * Um fornecedor tem como atributo nome, Email, um telefone e um
 * conjunto de produtos. O fornecedor tem como identificador unico o seu nome.
 *
 * @author Caetano Albuquerque - UFCG
 */
public class Fornecedor<produtosList> {

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
     * Objeto que tem funcoes que permite saber se as entradas sao validas
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

        this.validadorString.validaString(nome,"Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        this.validadorString.validaString(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
        this.validadorString.validaString(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");

        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.produtos = new HashMap<>();
    }


    public void setEmail(String email) {
        this.validadorString.validaString(email, "Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");

        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.validadorString.validaString(telefone, "Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");

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
        this.validadorString.validaString(nomeProduto, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
        this.validadorString.validaString(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");

        if (preco < 0){
            throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
        }

        if (this.produtos.containsKey(nomeProduto + descricao)) {
            throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
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
        this.validadorString.validaString(nomeProduto, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
        this.validadorString.validaString(descricao, "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");

        String result;

        if (this.produtos.containsKey(nomeProduto+descricao)){
            result = this.produtos.get(nomeProduto+descricao).toString();
        }else {
            throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
        }
        return result;
    }

    /**
     * Retorna uma string que lista todos os produtos que estao cadastrados no fornecedores
     * @return uma lista com todos os produtos cadastrados no fornecedor
     */
    public String listarProdutos() {

        ArrayList<String> produtosList = new ArrayList<>();

        for (String nome : this.produtos.keySet()){
            produtosList.add(this.produtos.get(nome).toString());
        }

        Collections.sort(produtosList);

        String result = "";
        for (int i = 0; i < produtosList.size(); i++){
            result += produtosList.get(i).toString() + " | ";
        }

        if (result.equals("")) {
            result = "Nenhum produto cadastrado pelo fornecedor: " + this.nome;
        } else {
            result = result.substring(0, result.length() - 3);
        }
        return result;
    }

    /**
     * Faz uma listagem de todos os produtos desse fornecedor, antecipados do nome do produtor
     * @return uma listagem de todos os produtos antecipados do nome do produtor
     */
    public String listarProdutosComNome() {

        ArrayList<String> produtosList = new ArrayList<>();

        for (String nome : this.produtos.keySet()){
            produtosList.add(this.produtos.get(nome).toString());
        }

        Collections.sort(produtosList);

        String result = "";
        for (int i = 0; i < produtosList.size(); i++){
            result += this.nome + " - " + produtosList.get(i) + " | ";
        }

        if (!result.equals("")) {
            result = result.substring(0, result.length() - 3);
        }else {
            result = this.nome + " -";
        }
        return result;
    }

    /**
     * Esse metodo edita o preco de determinado produto
     * @param nomeProduto - nome do produto, que junto a sua descricao forma o identificador unico do produto
     * @param descricao - descricao do produto, que junto a seu nome forma o identificador unico do produto
     * @param novoPreco - o novo preco do produto
     */
    public void editarProduto(String nomeProduto, String descricao, double novoPreco) {
        this.validadorString.validaString(nomeProduto, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
        this.validadorString.validaString(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");

        if (novoPreco < 0){
            throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
        }

        if (this.produtos.containsKey(nomeProduto + descricao)){
            this.produtos.get(nomeProduto + descricao).setPreco(novoPreco);
        }
        else {
            throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
        }
    }

    /**
     * Esse metodo remove um produto, do fornecedor
     * @param nomeProduto - nome do produto, que junto a sua descricao forma o identificador unico do produto
     * @param descricao - descricao do produto, que junto a seu nome forma o identificador unico do produto
     */
    public void removeProduto(String nomeProduto, String descricao) {
        this.validadorString.validaString(nomeProduto, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
        this.validadorString.validaString(descricao, "Erro na remocao de produto: descricao nao pode ser vazio ou nulo.");

        if (this.produtos.containsKey(nomeProduto + descricao)){
            this.produtos.remove(nomeProduto + descricao);
        }else {
            throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
        }
    }

    /**
     * Compare se outro objeto do mesmo tipo e igual a partir do nome do fornecedor
     * @param o o objeto que sera comparado com o fornecedor em questao
     * @return true caso o nome dos dois objetos forem o mesmo e false caso nao
     */
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
