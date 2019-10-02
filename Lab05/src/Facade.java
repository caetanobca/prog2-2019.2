public class Facade {

    private ControllerCliente controllerCliente;
    private ControllerFornecedor controllerFornecedor;

    public Facade(){
        this.controllerCliente = new ControllerCliente();
        this.controllerFornecedor = new ControllerFornecedor();
    }

    public String adicionaCliente(String cpf, String nome, String email, String localizacao){
        return this.controllerCliente.cadastraCliente(cpf, nome, email, localizacao);
    }

    public String exibeCliente (String cpf){
        return this.controllerCliente.exibeCliente(cpf);
    }

    public String listarClientes (){
        return this.controllerCliente.listarClientes();
    }

    public void editaCliente(String cpf, String opcao, String novoValor){
        this.controllerCliente.editarCliente(cpf, opcao, novoValor);
    }

    public void removeCliente(String cpf){
        this.controllerCliente.removerCliente(cpf);
    }

    public String adicionaFornecedor(String nome, String email, String telefone){
        return this.controllerFornecedor.cadastraFornecedor(nome, email, telefone);
    }

    public String exibeFornecedor (String nome){
        return this.controllerFornecedor.exibeFornecedor(nome);
    }

    public String listarFornecedores () {
        return this.controllerFornecedor.listarFornecedores();
    }

    public void editaFornecedor(String nome, String opcao, String novoValor){
        this.controllerFornecedor.editarFornecedor(nome, opcao, novoValor);
    }

    public void removeFornecedor(String nome){
        this.controllerFornecedor.removerFornecedor(nome);
    }

    public void adicionaProduto(String fornecedor, String nomeProduto, String descricao, double preco){
        this.controllerFornecedor.cadastrarProduto(fornecedor, nomeProduto, descricao, preco);
    }

    public String exibeProduto (String nomeProduto, String descricao, String fornecedor){
        return this.controllerFornecedor.exibeProduto(fornecedor, nomeProduto, descricao);
    }

    public String listarProdutosDoFornecedor(String fornecedor){
        return this.controllerFornecedor.listarProdutosDoFornecedor(fornecedor);
    }

    public String listarTodosProdutos (){
        return this.controllerFornecedor.listarTodosProdutos();
    }

    public void editaProduto(String nomeProduto, String descricao, String fornecedor, double novoPreco){
        this.controllerFornecedor.editarProduto(fornecedor, nomeProduto, descricao, novoPreco);
    }

    public void removeProduto(String nomeProduto, String descricao, String fornecedor){
        this.controllerFornecedor.removerProduto(fornecedor, nomeProduto, descricao);
    }
}
