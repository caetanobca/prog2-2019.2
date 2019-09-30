import java.util.HashMap;

public class ControllerFornecedor {

    /**
     * Mapa que usa o nome dos fornecedores como chave para acessar objetos do tipo Fornecedor
     */
    private HashMap<String, Fornecedor> fornecedores;

    /**
     * Objeto que tem funcoes que permite verificar se uma string e null ou composta apenas de espacos
     */
    private Validacao validadorString;

    /**
     * Inicializa o ControllerFornecedor
     */
    public ControllerFornecedor(){
        this.fornecedores = new HashMap<String , Fornecedor>();
        this.validadorString = new Validacao();
    }

    /**
     * Metodo que cria um Fornecedor e o adiciona ao mapa
     * @param nome - nome do fornecedor, que e o seu indentificador unico
     * @param email - email do fornecedor
     * @param telefone - telefone do fornecedor
     * @return Caso o fornecedor tenha sido cadastrado com sucesso, retorna o nome do fornecedor
     */
    public String cadastraFornecedor(String nome, String email, String telefone) {
        this.validadorString.validaString(nome);
        this.validadorString.validaString(email);
        this.validadorString.validaString(telefone);

        if (this.fornecedores.containsKey(nome)){
            throw new IllegalArgumentException("Fornecedor ja cadastrado");
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
        this.validadorString.validaString(nome);

        String result = "Fornecedor nao cadastrado";
        if (this.fornecedores.containsKey(nome)){
            result = this.fornecedores.get(nome).toString();
        }
        return result;
    }

    /**
     * Metodo que exibe uma representacao de todos os fornecedores
     * @return uma representacao de todos os fornecedores, na qual e usado o separador | para separar
     * os fornecedores retornados
     */
    public String listarFornecedores() {
        String result = "";
        for (String nome : this.fornecedores.keySet()){
            result += this.fornecedores.get(nome).toString() + " | ";

        }
        if (result.equals("")){
            result = "Nenhum Fornecedor cadastrado";
        }else {
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
        this.validadorString.validaString(nome);
        this.validadorString.validaString(novoValor);
        this.validadorString.validaString(opcao);

        if (this.fornecedores.containsKey(nome)){
            if (opcao.toUpperCase().equals("EMAIL")){
                this.fornecedores.get(nome).setEmail(novoValor);
            }else if (opcao.toUpperCase().equals("TELEFONE")){
                this.fornecedores.get(nome).setTelefone(novoValor);
            }else {
                throw new IllegalArgumentException("Opcao invalida");
            }
        }else {
            throw new IllegalArgumentException("Fornecedor nao cadastrado");
        }
    }

    /**
     * Metodo que remove algumm fornecedor do sistema
     * @param nome - nome do fornecedor que sera removido
     */
    public void removerFornecedor(String nome) {
        this.validadorString.validaString(nome);

        if(this.fornecedores.containsKey(nome)){
            this.fornecedores.remove(nome);
        }else {
            throw new IllegalArgumentException("O fornecedor ja nao estava cadastrado");
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
        this.validadorString.validaString(fornecedor);
        this.validadorString.validaString(nomeProduto);
        this.validadorString.validaString(descricao);

        if (this.fornecedores.containsKey(fornecedor)){
            this.fornecedores.get(fornecedor).cadastraProduto(nomeProduto, descricao, preco);
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
        this.validadorString.validaString(fornecedor);
        this.validadorString.validaString(nomeProduto);
        this.validadorString.validaString(descricao);

        String result;

        if (this.fornecedores.containsKey(fornecedor)){
            result = this.fornecedores.get(fornecedor).exibeProduto(nomeProduto, descricao);
        }else {
            result = "Fornecedor nao cadastrado";
        }

        return result;
    }

    /**
     * Metodo que lista todos os produtos cadastrados em determinado fornecedor
     * @param fornecedor - nome do fornecedor
     * @return retorna uma representacao de todos os produtos de determinado fornecedor
     */
    public String listarProdutosDoFornecedor(String fornecedor) {
        this.validadorString.validaString(fornecedor);

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
        String result = "";
        for (String nome : this.fornecedores.keySet()){
            result += this.fornecedores.get(nome).listarProdutosComNome() + " | ";
        }

        if (result.equals("")){
            result = "Nenhum Fornecedor cadastrado";
        }else {
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
        this.validadorString.validaString(fornecedor);
        this.validadorString.validaString(nomeProduto);
        this.validadorString.validaString(descricao);

        if (this.fornecedores.containsKey(fornecedor)){
            this.fornecedores.get(fornecedor).editarProduto(nomeProduto, descricao, nomeProduto, novoPreco);
        }else {
            throw new IllegalArgumentException("Fornecedor nao cadastrado");
        }
    }

    /**
     * Metodo que remove um produto
     * @param fornecedor - nome do fornecedor
     * @param nomeProduto - nome do produto
     * @param descricao - descricao do produto
     */
    public void removerProduto(String fornecedor, String nomeProduto, String descricao) {
        this.validadorString.validaString(fornecedor);
        this.validadorString.validaString(nomeProduto);
        this.validadorString.validaString(descricao);

        if(this.fornecedores.containsKey(fornecedor)){
            this.fornecedores.get(fornecedor).removeProduto(nomeProduto, descricao);
        }else {
            throw new IllegalArgumentException("Fornecedor nao esta cadastrado");
        }

    }
}
