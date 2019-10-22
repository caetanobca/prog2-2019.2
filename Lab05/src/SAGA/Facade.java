package SAGA;

import SAGA.Cliente.ControllerCliente;
import SAGA.Fornecedor.ControllerFornecedor;

public class Facade {

    private ControllerCliente controllerCliente;
    private ControllerFornecedor controllerFornecedor;

    public Facade() {
        this.controllerFornecedor = new ControllerFornecedor();
        this.controllerCliente = new ControllerCliente(this.controllerFornecedor);
    }



    //Cliente

    public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
        return this.controllerCliente.cadastraCliente(cpf, nome, email, localizacao);
    }

    public String exibeCliente(String cpf) {
        return this.controllerCliente.exibeCliente(cpf);
    }

    public String exibeClientes() {
        return this.controllerCliente.listarClientes();
    }

    public void editaCliente(String cpf, String opcao, String novoValor) {
        this.controllerCliente.editarCliente(cpf, opcao, novoValor);
    }

    public void removeCliente(String cpf) {
        this.controllerCliente.removerCliente(cpf);
    }



    //Fornecedores

    public String adicionaFornecedor(String nome, String email, String telefone) {
        return this.controllerFornecedor.cadastraFornecedor(nome, email, telefone);
    }

    public String exibeFornecedor(String nome) {
        return this.controllerFornecedor.exibeFornecedor(nome);
    }

    public String exibeFornecedores() {
        return this.controllerFornecedor.listarFornecedores();
    }

    public void editaFornecedor(String nome, String opcao, String novoValor) {
        this.controllerFornecedor.editarFornecedor(nome, opcao, novoValor);
    }

    public void removeFornecedor(String nome) {
        this.controllerFornecedor.removerFornecedor(nome);
    }



    //Produtos

    public void adicionaProduto(String fornecedor, String nomeProduto, String descricao, double preco) {
        this.controllerFornecedor.cadastrarProduto(fornecedor, nomeProduto, descricao, preco);
    }

    public String exibeProduto(String nomeProduto, String descricao, String fornecedor) {
        return this.controllerFornecedor.exibeProduto(fornecedor, nomeProduto, descricao);
    }

    public String listarProdutosDoFornecedor(String fornecedor) {
        return this.controllerFornecedor.listarProdutosDoFornecedor(fornecedor);
    }

    public String exibeProdutos() {
        return this.controllerFornecedor.listarTodosProdutos();
    }

    public void editaProduto(String nomeProduto, String descricao, String fornecedor, double novoPreco) {
        this.controllerFornecedor.editarProduto(fornecedor, nomeProduto, descricao, novoPreco);
    }

    public void removeProduto(String nomeProduto, String descricao, String fornecedor) {
        this.controllerFornecedor.removerProduto(fornecedor, nomeProduto, descricao);
    }

    public String exibeProdutosFornecedor(String fornecedor) {
        return this.controllerFornecedor.exibeProdutosFornecedor(fornecedor);
    }



    //Compras

    public void adicionaCompra (String cpf, String fornecedor, String data, String nomeProduto, String descricaoProduto){
        this.controllerCliente.cadastraCompra(cpf, fornecedor, data, nomeProduto, descricaoProduto);
    }

    public String getDebito (String cpf, String fornecedor){
        return this.controllerCliente.getDebito(cpf, fornecedor);
    }

    public String exibeContas (String cpf, String fornecedor){
        return this.controllerCliente.getContaEmFornecedor(cpf, fornecedor);
    }

    public String exibeContasClientes (String cpf){
        return this.controllerCliente.contaCliente(cpf);
    }



    //Combo

    public void adicionaCombo (String fornecedor, String nomeCombo, String descricaoCombo, double fator, String produtos){
        this.controllerFornecedor.adicionaCombo(fornecedor, nomeCombo, descricaoCombo, fator, produtos);
    }

    public void editaCombo (String nomeCombo, String descricaoCombo, String fornecedor, double novoFator){
        this.controllerFornecedor.editaCombo(fornecedor, nomeCombo, descricaoCombo, novoFator);
    }



    //Pagamento

    public void realizaPagamento (String cpf, String fornecedor){
        this.controllerCliente.realizaPagamento(cpf, fornecedor);
    }



    //Listar Compras

    public void ordenaPor(String criterio){
        this.controllerCliente.ordenaPor(criterio);
    }

    public String listarCompras(){
        return this.controllerCliente.listarCompras();
    }

}


