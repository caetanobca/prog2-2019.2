public class Facade {

    private ControllerCliente controllerCliente;
    private ControllerFornecedor controllerFornecedor;

    public Facade(){
        this.controllerCliente = new ControllerCliente();
        this.controllerFornecedor = new ControllerFornecedor();
    }

    public String cadastraCliente (String nome, String cpf, String email, String localizacao){
        return this.controllerCliente.cadastraCliente(cpf, nome, email, localizacao);
    }

    public String exibeCliente (String cpf){
        return this.controllerCliente.exibeCliente(cpf);
    }

    public String listarClientes (){
        return this.controllerCliente.listarClientes();
    }

    public void editarCliente (String cpf, String opcao, String novoValor){
        this.controllerCliente.editarCliente(cpf, opcao, novoValor);
    }

    public String removerCliente(String cpf){
        return this.controllerCliente.removerCliente(cpf);
    }

    public String cadastrarFornecedor (String nome, String email, String telefone){
        return this.controllerFornecedor.cadastraFornecedor(nome, email, telefone);
    }

    public String exibeFornecedor (String nome){
        return this.controllerFornecedor.exibeFornecedor(nome);
    }

    public String listarFornecedores () {
        return this.controllerFornecedor.listarFornecedores();
    }

    public void editarFornecedor (String nome, String opcao, String novoValor){
        this.controllerFornecedor.editarFornecedor(nome, opcao, novoValor);
    }

    public void removerFornecedor (String nome){
        this.controllerFornecedor.removerFornecedor(nome);
    }

    public void cadastrarProduto (String fornecedor, String nomeProduto, String descricao, double preco){
        this.controllerFornecedor.cadastrarProduto(fornecedor, nomeProduto, descricao, preco);
    }

    public String exibeProduto (String fornecedor, String nomeProduto, String descricao){
        return this.controllerFornecedor.exibeProduto(fornecedor, nomeProduto, descricao);
    }

    public String listarProdutosDoFornecedor(String fornecedor){
        return this.controllerFornecedor.listarProdutosDoFornecedor(fornecedor);
    }

    public String listarTodosProdutos (){
        return this.controllerFornecedor.listarTodosProdutos();
    }

    public void editarProduto (String fornecedor, String nomeProduto, String descricao, double novoPreco){
        this.controllerFornecedor.editarProduto(fornecedor, nomeProduto, descricao, novoPreco);
    }

    public void removerProduto (String fornecedor, String nomeProduto, String descricao){
        this.controllerFornecedor.removerProduto(fornecedor, nomeProduto, descricao);
    }
}
