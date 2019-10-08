public class ControllerGeral {
    private ControllerCliente controllerCliente;
    private ControllerFornecedor controllerFornecedor;
    private Validacao validadorString;

    ControllerGeral(){
        this.controllerCliente = new ControllerCliente();
        this.controllerFornecedor = new ControllerFornecedor();
        this.validadorString = new Validacao();
    }

    public String cadastraCliente(String cpf, String nome, String email, String localizacao) {
        this.validadorString.validaString(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
        this.validadorString.validaString(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
        this.validadorString.validaString(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
        this.validadorString.validaString(localizacao, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
        return this.controllerCliente.cadastraCliente(cpf, nome, email, localizacao);
    }

    public String exibeCliente(String cpf) {
        this.validadorString.validaString(cpf, "Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
        return this.controllerCliente.exibeCliente(cpf);
    }

    public String listarClientes() {
        return this.controllerCliente.listarClientes();
    }

    public void editarCliente(String cpf, String opcao, String novoValor) {
        this.validadorString.validaString(cpf, "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
        this.validadorString.validaString(novoValor, "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
        this.validadorString.validaString(opcao, "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
        this.controllerCliente.editarCliente(cpf, opcao, novoValor);
    }

    public void removerCliente(String cpf) {
        this.validadorString.validaString(cpf,"Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
        this.controllerCliente.removerCliente(cpf);
    }

    public String cadastraFornecedor(String nome, String email, String telefone) {
        this.validadorString.validaString(nome,"Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
        this.validadorString.validaString(email, "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
        this.validadorString.validaString(telefone, "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
        return this.controllerFornecedor.cadastraFornecedor(nome, email, telefone);
    }

    public String exibeFornecedor (String nome){
        this.validadorString.validaString(nome, "Erro na exibicao do fornecedor: nome nao pode ser vazio ou nulo.");
        return this.controllerFornecedor.exibeFornecedor(nome);
    }

    public String exibeFornecedores() {

        return this.controllerFornecedor.listarFornecedores();
    }

    public void editaFornecedor(String nome, String opcao, String novoValor){
        this.validadorString.validaString(nome, "Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
        this.validadorString.validaString(novoValor, "Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
        this.validadorString.validaString(opcao, "Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
        this.controllerFornecedor.editarFornecedor(nome, opcao, novoValor);
    }

    public void removeFornecedor(String nome){
        this.validadorString.validaString(nome, "Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
        this.controllerFornecedor.removerFornecedor(nome);
    }

    public void adicionaProduto(String fornecedor, String nomeProduto, String descricao, double preco){
        this.validadorString.validaString(fornecedor, "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
        this.validadorString.validaString(nomeProduto, "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
        this.validadorString.validaString(descricao, "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
        this.controllerFornecedor.cadastrarProduto(fornecedor, nomeProduto, descricao, preco);
    }

    public String exibeProduto (String nomeProduto, String descricao, String fornecedor){
        this.validadorString.validaString(fornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
        this.validadorString.validaString(nomeProduto, "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
        this.validadorString.validaString(descricao, "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
        return this.controllerFornecedor.exibeProduto(fornecedor, nomeProduto, descricao);
    }

    public String listarProdutosDoFornecedor(String fornecedor){
        this.validadorString.validaString(fornecedor, "");
        return this.controllerFornecedor.listarProdutosDoFornecedor(fornecedor);
    }

    public String exibeProdutos(){
        return this.controllerFornecedor.listarTodosProdutos();
    }

    public void editaProduto(String nomeProduto, String descricao, String fornecedor, double novoPreco){
        this.validadorString.validaString(fornecedor, "Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
        this.validadorString.validaString(nomeProduto, "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
        this.validadorString.validaString(descricao, "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
        this.controllerFornecedor.editarProduto(fornecedor, nomeProduto, descricao, novoPreco);
    }

    public void removeProduto(String nomeProduto, String descricao, String fornecedor){
        this.validadorString.validaString(fornecedor, "Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
        this.validadorString.validaString(nomeProduto, "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
        this.validadorString.validaString(descricao, "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
        this.controllerFornecedor.removerProduto(fornecedor, nomeProduto, descricao);
    }

    public String exibeProdutosFornecedor (String fornecedor){
        this.validadorString.validaString(fornecedor, "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
        return this.controllerFornecedor.exibeProdutosFornecedor(fornecedor);
    }

}
