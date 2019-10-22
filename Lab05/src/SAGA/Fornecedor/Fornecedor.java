package SAGA.Fornecedor;

import SAGA.Produto.Combo;
import SAGA.Produto.ProdutoInterface;
import SAGA.Produto.ProdutoUnitario;
import SAGA.Validacao;

import java.util.*;

/**
 * Classe criada para Representar um Fornecedor
 * Um fornecedor tem como atributo nome, Email, um telefone e um
 * conjunto de produtos. O fornecedor tem como identificador unico o seu nome.
 *
 * @author Caetano Albuquerque - UFCG
 */
public class Fornecedor<produtosList> implements Comparable<Fornecedor> {

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
     * como chave e armazena objetos do tipo ProdutoUnitario
     */
    private Map<String, ProdutoInterface> produtos;

    /**
     * Objeto que tem funcoes que permite saber se as entradas sao validas
     */
    private Validacao validador;

    /**
     * Cria um fornecedor a partir de valores dados pelo o usuario
     * @param nome - nome do fornecedor, que e seu indentificador unico
     * @param email - email do fornecedor
     * @param telefone - telefone do fornecedor
     */
    public Fornecedor(String nome, String email, String telefone) {
        this.validador = new Validacao();

        this.validador.validaString(nome,"Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        this.validador.validaString(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
        this.validador.validaString(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");

        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.produtos = new HashMap<>();
    }

    /**
     * Muda o email do fornecedor
     * @param email - novo email
     */
    public void setEmail(String email) {
        this.validador.validaString(email, "Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");

        this.email = email;
    }

    /**
     * muda o telefone do fornecedor
     * @param telefone - novo telefone
     */
    public void setTelefone(String telefone) {
        this.validador.validaString(telefone, "Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");

        this.telefone = telefone;
    }

    /**
     * Metodo que cadastra um produto
     * @param nomeProduto - nome do produto, que junto a sua descricao e o indentificador unico do produto
     * @param descricao - descricao do produto, que junto a seu nome e o indentificador unico do produto
     * @param preco -preco do produto
     */
    public void cadastraProduto(String nomeProduto, String descricao, double preco) {
        this.validador.validaString(nomeProduto, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
        this.validador.validaString(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");

        if (preco < 0){
            throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
        }

        if (this.produtos.containsKey(nomeProduto + descricao)) {
            throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
        } else {
            this.produtos.put((nomeProduto + descricao), new ProdutoUnitario(nomeProduto, descricao, preco));

        }
    }

    /**
     * Retorna uma representacao de um produto.
     * @param nomeProduto - nome do produto, que junto a sua descricao e o indentificador unico do produto
     * @param descricao - descricao do produto, que junto a seu nome e o indentificador unico do produto
     * @return uma representacao textual de um produto
     */
    public String exibeProduto(String nomeProduto, String descricao) {
        this.validador.validaString(nomeProduto, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
        this.validador.validaString(descricao, "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");

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

        ArrayList<ProdutoInterface> produtosList = new ArrayList<>();

        for (String nome : this.produtos.keySet()){
            produtosList.add(this.produtos.get(nome));
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

        ArrayList<ProdutoInterface> produtosList = new ArrayList<>();

        for (String nome : this.produtos.keySet()){
            produtosList.add(this.produtos.get(nome));
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
        this.validador.validaString(nomeProduto, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
        this.validador.validaString(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");

        if (novoPreco < 0){
            throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
        }

        if (this.produtos.containsKey(nomeProduto + descricao)){
            this.produtos.get(nomeProduto + descricao).editarProduto(novoPreco);
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
        this.validador.validaString(nomeProduto, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
        this.validador.validaString(descricao, "Erro na remocao de produto: descricao nao pode ser vazio ou nulo.");

        if (this.produtos.containsKey(nomeProduto + descricao)){
            this.produtos.remove(nomeProduto + descricao);
        }else {
            throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
        }
    }

    /**
     * metodo que pega o preco de um determinado produto, seja ele produtoUnitario ou combo
     * @param nomeProduto - nome do produto
     * @param descricaoProduto - descricao do produto
     * @return o preco do produto
     */
    public double getPreco(String nomeProduto, String descricaoProduto) {
        this.validador.validaString(nomeProduto, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
        this.validador.validaString(descricaoProduto, "Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");

        if (!this.produtos.containsKey(nomeProduto + descricaoProduto)){
            throw new IllegalArgumentException("Erro ao cadastrar compra: produto nao existe.");
        }
        else {
            return this.produtos.get(nomeProduto + descricaoProduto).getPreco();
        }
    }

    /**
     * verifica se determinado produto esta cadastrado no fornecedor
     * @param nomeProduto - nome do produto que sera buscado
     * @param descricaoProduto - descricao do produto que sera pesquisado
     * @return true caso o produto exista, false caso nao
     */
    public boolean existeProduto(String nomeProduto, String descricaoProduto) {
        if (this.produtos.containsKey(nomeProduto + descricaoProduto)){
            return true;
        }
        return false;
    }

    /**
     * metodo que cria um combo a partir de produtos que ja existiam
     * @param nomeCombo - nome do combo
     * @param descricaoCombo - descricao do combo
     * @param fator - fator de desconto do combo
     * @param produtos - todos os produtos que compoe o combo
     */
    public void adicionaCombo(String nomeCombo, String descricaoCombo, double fator, String produtos) {
        String[] produtosCombo = produtos.split(", ");
        String[] nomeEDescricao = new String[2];
        double preco = 0;
        for (int i = 0; i < produtosCombo.length; i++){
            nomeEDescricao = produtosCombo[i].split(" - ");
            if (this.produtos.containsKey(nomeEDescricao[0] + nomeEDescricao [1])){
                if (this.produtos.get(nomeEDescricao[0] + nomeEDescricao[1]) instanceof Combo){
                    throw new IllegalArgumentException("Erro no cadastro de combo: um combo nao pode possuir combos na lista de produtos.");
                }
                preco += this.produtos.get(nomeEDescricao[0]+ nomeEDescricao [1]).getPreco();
            }else {
                throw new IllegalArgumentException("Erro no cadastro de combo: produto nao existe.");
            }
        }

        if(this.produtos.containsKey(nomeCombo + descricaoCombo)){
            throw new IllegalArgumentException("Erro no cadastro de combo: combo ja existe.");
        }
        this.produtos.put(nomeCombo + descricaoCombo, new Combo(nomeCombo, descricaoCombo, fator, preco));
    }

    /**
     * edita o fator de desconto do combo
     * @param nomeCombo - nome do combo que sera editado
     * @param descricaoCombo - descricao do combo que sera editado
     * @param novoFator - novo fator de desconto do combo
     */
    public void editarCombo(String nomeCombo, String descricaoCombo, double novoFator) {
        this.validador.validaString(nomeCombo, "Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
        this.validador.validaString(descricaoCombo, "Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");

        if (novoFator <= 0 || novoFator >= 1){
            throw new IllegalArgumentException("Erro na edicao de combo: fator invalido.");
        }

        if (this.produtos.containsKey(nomeCombo + descricaoCombo)){
            this.produtos.get(nomeCombo + descricaoCombo).editarProduto(novoFator);
        }
        else {
            throw new IllegalArgumentException("Erro na edicao de combo: produto nao existe.");
        }
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

    /**
     * compara o tostring de fornecedot
     * @param o fornecedor que sera comparado
     * @return um numero possitivo caso esse fornecedor for "maior" que o fornecedor o, um numero negativo se o
     * fornecedor o for "maior" e zero se os fornecedores tiverem um valor "igual"
     */
    @Override
    public int compareTo(Fornecedor o) {
        return this.toString().compareTo(o.toString());
    }
}
