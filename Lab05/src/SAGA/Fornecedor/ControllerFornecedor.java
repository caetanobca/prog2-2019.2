package SAGA.Fornecedor;

import SAGA.Validacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Criado para controlar os objetos do tipo Fornecedor
 * Um ControllerFornecedor possui um Conjunto de fornecedores, que possuem como chave o nome do fornecedor e um
 * objeto que e responsavel por verificar a validade das strings.
 *
 * @author Caetano Albuquerque - UFCG
 */
public class ControllerFornecedor {

    /**
     * Mapa que usa o nome dos fornecedores como chave para acessar objetos do tipo Fornecedor
     */
    private Map<String, Fornecedor> fornecedores;

    /**
     * Objeto que tem funcoes que permite verificar se uma string e null ou composta apenas de espacos
     */
    private Validacao validador;

    /**
     * Inicializa o ControllerFornecedor
     */
    public ControllerFornecedor(){
        this.fornecedores = new HashMap<String , Fornecedor>();
        this.validador = new Validacao();
    }

    /**
     * Metodo que cria um Fornecedor e o adiciona ao mapa
     * @param nome - nome do fornecedor, que e o seu indentificador unico
     * @param email - email do fornecedor
     * @param telefone - telefone do fornecedor
     * @return Caso o fornecedor tenha sido cadastrado com sucesso, retorna o nome do fornecedor
     */
    public String cadastraFornecedor(String nome, String email, String telefone) {
        this.validador.validaString(nome,"Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        this.validador.validaString(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
        this.validador.validaString(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");

        if (this.fornecedores.containsKey(nome)){
            throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
        }else {
            this.fornecedores.put(nome, new Fornecedor(nome, email, telefone));
        }

        return nome;
    }

    /**
     * Metodo que exibe uma representacao de determinado fornecedor
     * @param nome - nome do fornecedro, que e seu indentificador unico e que e usado como chave no mapa que
     *             guarda os fornecedores
     * @return uma representacao do fornecedor no formato <nome, email e telefone>
     */
    public String exibeFornecedor(String nome) {
        this.validador.validaString(nome, "Erro na exibicao do fornecedor: nome nao pode ser vazio ou nulo.");

        String result;
        if (this.fornecedores.containsKey(nome)){
            result = this.fornecedores.get(nome).toString();
        }else {
            throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
        }
        return result;
    }

    /**
     * Metodo que exibe uma representacao de todos os fornecedores
     * @return uma representacao de todos os fornecedores, na qual e usado o separador | para separar
     * os fornecedores retornados
     */
    public String listarFornecedores() {

        ArrayList<String> fornecedoresList = new ArrayList<>();

        for (String nome : this.fornecedores.keySet()){
            fornecedoresList.add(this.fornecedores.get(nome).toString());
        }

        Collections.sort(fornecedoresList);

        String result = "";
        for (int i = 0; i < fornecedoresList.size(); i++){
            result += fornecedoresList.get(i) + " | ";
        }

        if (!result.equals("")){
            result = result.substring(0, result.length() - 3);
        }
        return result;
    }

    /**
     * Metodo que edita alguma informacao de um fornecedor
     * @param nome - nome do fornecedor, que sera usado para pegar o fornecedor no mapa
     * @param opcao - oque o usuario deseja aterar no fornecedor
     * @param novoValor - o novo valor que determinado atributo do fornecedor ira assumir
     */
    public void editarFornecedor(String nome, String opcao, String novoValor) {
        this.validador.validaString(nome, "Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
        this.validador.validaString(novoValor, "Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
        this.validador.validaString(opcao, "Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");

        if (this.fornecedores.containsKey(nome)){
            if (opcao.toUpperCase().equals("EMAIL")){
                this.fornecedores.get(nome).setEmail(novoValor);
            }else if (opcao.toUpperCase().equals("TELEFONE")){
                this.fornecedores.get(nome).setTelefone(novoValor);
            }else if (opcao.toUpperCase().equals("NOME")){
                throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
            }else {
                throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
            }
        }else {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
        }
    }

    /**
     * Metodo que remove algumm fornecedor do sistema
     * @param nome - nome do fornecedor que sera removido
     */
    public void removerFornecedor(String nome) {
        this.validador.validaString(nome, "Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");

        if(this.fornecedores.containsKey(nome)){
            this.fornecedores.remove(nome);
        }else {
            throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
        }
    }

    /**
     * Metodo que cadastra um produto em um fornecedor.
     * @param fornecedor - nome do fornecedor onde sera cadastrado o produto
     * @param nomeProduto - nome do produto que sera cadastrado
     * @param descricao - descricao do produto que sera cadastrado
     * @param preco - valor em reais do produto que sera cadastrado
     */
    public void cadastrarProduto(String fornecedor, String nomeProduto, String descricao, double preco) {
        this.validador.validaString(fornecedor, "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
        this.validador.validaString(nomeProduto, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
        this.validador.validaString(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");

        if (preco < 0){
            throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
        }

        if (this.fornecedores.containsKey(fornecedor)){
            this.fornecedores.get(fornecedor).cadastraProduto(nomeProduto, descricao, preco);
        }else {
            throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
        }
    }

    /**
     * Metodo que exibe um determinado produto de um determinado fornecedor
     * @param fornecedor - nome do fornecedor, no qual vai ser feita a busca
     * @param nomeProduto - nome do produto que sera buscado
     * @param descricao - descricao do produto que sera buscado
     * @return caso o produto esteja cadastrado, o metodo retorna a representacao do produto
     */
    public String exibeProduto(String fornecedor, String nomeProduto, String descricao) {
        this.validador.validaString(fornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
        this.validador.validaString(nomeProduto, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
        this.validador.validaString(descricao, "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");

        String result;

        if (this.fornecedores.containsKey(fornecedor)){
            result = this.fornecedores.get(fornecedor).exibeProduto(nomeProduto, descricao);
        }else {
            throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
        }

        return result;
    }

    /**
     * Metodo que lista todos os produtos cadastrados em determinado fornecedor
     * @param fornecedor - nome do fornecedor
     * @return retorna uma representacao de todos os produtos de determinado fornecedor
     */
    public String listarProdutosDoFornecedor(String fornecedor) {
        this.validador.validaString(fornecedor, "");

        String result = "Fornecedor nao cadastrado";
        if (this.fornecedores.containsKey(fornecedor)){
            result = this.fornecedores.get(fornecedor).listarProdutos();
        }
        return result;
    }

    /**
     * Metodo que lista todos os produtos cadastrado em todos os fornecedores
     * @return uma representacao de todos os produtos cadastrados em todos os fornecedores
     */
    public String listarTodosProdutos() {

        ArrayList<Fornecedor> arrayListFornecedores = new ArrayList<Fornecedor>(this.fornecedores.values());

        Collections.sort(arrayListFornecedores);

        String result = "";
        for (int i = 0; i < arrayListFornecedores.size(); i++){
            result += arrayListFornecedores.get(i).listarProdutosComNome() + " | ";
        }

        if (!result.equals("")) {
            result = result.substring(0, result.length() - 3);
        }
        return result;
    }

    /**
     * Edita o valor de um produto ja cadastrado
     * @param fornecedor - nome do fornecedor
     * @param nomeProduto - nome do produto que tera seu preco alterado
     * @param descricao - descricao do produto que tera seu preco alterado
     * @param novoPreco - o novo preco que o produto ira assumir
     */
    public void editarProduto(String fornecedor, String nomeProduto, String descricao, double novoPreco) {
        this.validador.validaString(fornecedor, "Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
        this.validador.validaString(nomeProduto, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
        this.validador.validaString(descricao, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");

        if (novoPreco < 0){
            throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
        }

        if (this.fornecedores.containsKey(fornecedor)){
            this.fornecedores.get(fornecedor).editarProduto(nomeProduto, descricao, novoPreco);
        }else {
            throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
        }
    }

    /**
     * Metodo que remove um produto
     * @param fornecedor - nome do fornecedor
     * @param nomeProduto - nome do produto
     * @param descricao - descricao do produto
     */
    public void removerProduto(String fornecedor, String nomeProduto, String descricao) {
        this.validador.validaString(fornecedor, "Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
        this.validador.validaString(nomeProduto, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
        this.validador.validaString(descricao, "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");

        if(this.fornecedores.containsKey(fornecedor)){
            this.fornecedores.get(fornecedor).removeProduto(nomeProduto, descricao);
        }else {
            throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
        }

    }

    /**
     * Metodo que exibe uma representacao textual de determinado produto, de determinado fornecedor
     * @param fornecedor - nome do fornecedor -identificador unico-
     * @return a representacao textual do produto
     */
    public String exibeProdutosFornecedor(String fornecedor) {
        this.validador.validaString(fornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
        if (!this.fornecedores.containsKey(fornecedor)){
            throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
        }
        return this.fornecedores.get(fornecedor).listarProdutosComNome();
    }

    /**
     * Metodo que pega o preco de determinado produto em determinado fornecedor
     * @param fornecedor - nome do fornecedor -identificador unico-
     * @param nomeProduto - nome do produto
     * @param descricaoProduto - descricao do produto
     * @return o preco do produto
     */
    public double getPrecoProduto(String fornecedor, String nomeProduto, String descricaoProduto) {
        this.validador.validaString(fornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
        this.validador.validaString(nomeProduto, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
        this.validador.validaString(descricaoProduto, "Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");


        if (!this.fornecedores.containsKey(fornecedor)) {
            throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao existe.");
        }else if (!this.fornecedores.get(fornecedor).existeProduto(nomeProduto, descricaoProduto)){
            throw new IllegalArgumentException("Erro ao cadastrar compra: produto nao existe.");
        }

        return this.fornecedores.get(fornecedor).getPreco(nomeProduto, descricaoProduto);

    }

    /**
     * metodo que verifica se algum fornecedor esta cadastrado
     * @param fornecedor - nome do fornecedor -identificador unico-
     * @return true caso o fornecedor esteja cadastrado, false caso nao
     */
    public boolean existeFornecedo(String fornecedor) {
        this.validador.validaString(fornecedor, "Fornecedor nao pode ser vazio ou nulo");
        if (this.fornecedores.containsKey(fornecedor)){
            return true;
        }
        return false;
    }

    /**
     * Metodo que adiciona combo em determinado fornecedor
     * @param fornecedor - nome do fornecedor -identificador unico-
     * @param nomeCombo - nome do combo que esta sendo criado
     * @param descricaoCombo - descricao do combo que esta sendo criado
     * @param fator - fator de promocao do combo (porcentagem, valores acima de 0 e menores que 1)
     * @param produtos - os nomes e as descricoes de todos os produtos que o combo possuira
     */
    public void adicionaCombo(String fornecedor, String nomeCombo, String descricaoCombo, double fator, String produtos) {
        this.validador.validaString(fornecedor, "Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");
        this.validador.validaString(nomeCombo, "Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
        this.validador.validaString(descricaoCombo, "Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
        this.validador.validaString(produtos, "Erro no cadastro de combo: combo deve ter produtos.");

        if (fator <= 0 || fator >= 1){
            throw new IllegalArgumentException("Erro no cadastro de combo: fator invalido.");
        }

        if (this.fornecedores.containsKey(fornecedor)){
            this.fornecedores.get(fornecedor).adicionaCombo(nomeCombo, descricaoCombo, fator, produtos);
        }else {
            throw new IllegalArgumentException("Erro no cadastro de combo: fornecedor nao existe.");
        }
    }

    /**
     * Metodo que edita o fator promocional do combo
     * @param fornecedor - nome do fornecedor
     * @param nomeCombo - nome do combo
     * @param descricaoCombo - descricao do combo
     * @param novoFator - o novo fator de desconto
     */
    public void editaCombo(String fornecedor, String nomeCombo, String descricaoCombo, double novoFator) {
        this.validador.validaString(fornecedor, "Erro na edicao de combo: fornecedor nao pode ser vazio ou nulo.");
        this.validador.validaString(nomeCombo, "Erro na edicao de combo: nome nao pode ser vazio ou nulo.");
        this.validador.validaString(descricaoCombo, "Erro na edicao de combo: descricao nao pode ser vazia ou nula.");

        if (novoFator < 0 || novoFator > 1){
            throw new IllegalArgumentException("Erro na edicao de combo: fator invalido.");
        }

        if (this.fornecedores.containsKey(fornecedor)){
            this.fornecedores.get(fornecedor).editarCombo(nomeCombo, descricaoCombo, novoFator);
        }else {
            throw new IllegalArgumentException("Erro na edicao de combo: fornecedor nao existe.");
        }
    }
}
