public class Facade {

    private ControllerGeral controllerGeral;


    public Facade(){
        this.controllerGeral = new ControllerGeral();
    }

    public String adicionaCliente(String cpf, String nome, String email, String localizacao){
        return this.controllerGeral.cadastraCliente(cpf, nome, email, localizacao);
    }

    public String exibeCliente (String cpf){
        return this.controllerGeral.exibeCliente(cpf);
    }

    public String exibeClientes(){
        return this.controllerGeral.listarClientes();
    }

    public void editaCliente(String cpf, String opcao, String novoValor){
        this.controllerGeral.editarCliente(cpf, opcao, novoValor);
    }

    public void removeCliente(String cpf){
        this.controllerGeral.removerCliente(cpf);
    }

    public String adicionaFornecedor(String nome, String email, String telefone){
        return this.controllerGeral.cadastraFornecedor(nome, email, telefone);
    }

    public String exibeFornecedor (String nome){
        return this.controllerGeral.exibeFornecedor(nome);
    }

    public String exibeFornecedores() {
        return this.controllerGeral.exibeFornecedores();
    }

    public void editaFornecedor(String nome, String opcao, String novoValor){
        this.controllerGeral.editaFornecedor(nome, opcao, novoValor);
    }

    public void removeFornecedor(String nome){
        this.controllerGeral.removeFornecedor(nome);
    }

    public void adicionaProduto(String fornecedor, String nomeProduto, String descricao, double preco){
        this.controllerGeral.adicionaProduto(fornecedor, nomeProduto, descricao, preco);
    }

    public String exibeProduto (String nomeProduto, String descricao, String fornecedor){
        return this.controllerGeral.exibeProduto(nomeProduto, descricao, fornecedor);
    }

    public String listarProdutosDoFornecedor(String fornecedor){
        return this.controllerGeral.listarProdutosDoFornecedor(fornecedor);
    }

    public String exibeProdutos(){
        return this.controllerGeral.exibeProdutos();
    }

    public void editaProduto(String nomeProduto, String descricao, String fornecedor, double novoPreco){
        this.controllerGeral.editaProduto(nomeProduto, descricao, fornecedor, novoPreco);
    }

    public void removeProduto(String nomeProduto, String descricao, String fornecedor){
        this.controllerGeral.removeProduto(nomeProduto, descricao, fornecedor);
    }

    public String exibeProdutosFornecedor (String fornecedor){
        return this.controllerGeral.exibeProdutosFornecedor(fornecedor);
    }

    public void adicionaCompra (String cpf, String fornecedor, String data, String nomeProduto, String descricaoProduto){
        this.controllerGeral.cadastraCompra(cpf, fornecedor, data, nomeProduto, descricaoProduto);

    }

    public double getDebito (String cpf, String fornecedor){
        return this.controllerGeral.getDebitoCliente(cpf, fornecedor);
    }

    public String getContaEmFornecedor (String cpf, String fornecedor){
        return this.controllerGeral.getContaEmFornecedor(cpf, fornecedor);
    }

    public String contaDeCliente (String cpf){
        return this.controllerGeral.contaDeCliente(cpf);

    }
}
