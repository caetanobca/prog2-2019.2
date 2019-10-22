import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Criado para controlar os objetos do tipo Cliente
 * Um ControllerCliente possui um Conjunto de Clientes, que possuem como chave o CPF do Cliente e um
 * objeto que e responsavel por verificar a validade das strings.
 *
 * @author Caetano Albuquerque - UFCG
 */
public class ControllerCliente {

    /**
     * Mapa que usa o cpf dos clientes como chave para acessar objetos do tipo Cliente
     */
    private HashMap<String, Cliente> clientes;

    /**
     * Objeto que tem funcoes que permite verificar se uma string e null ou composta apenas de espacos
     */
    private Validacao validadorString;

    /**
     * Objeto adicionado para fazer com que o controller cliente tenha acesso aos dados do controllerFornecedor
     */
    private ControllerFornecedor controllerFornecedor;

    /**
     * Enum que define os tipos de ordenacao para exibir as compraa
     */
    private CriterioOrdenacao criterioOrdenacao;






    /**
     * Inicializa o ControllerFornecedor
     */
    public ControllerCliente(ControllerFornecedor controllerFornecedor) {
        this.clientes = new HashMap<String, Cliente>();
        this.validadorString = new Validacao();
        this.controllerFornecedor = controllerFornecedor;
        this.criterioOrdenacao = CriterioOrdenacao.NAODEFINIDO;

    }

    /**
     * Metodo que cadastra um cliente a partir do seu cpf, nome, email e localizacao
     * @param cpf - cpf do cliente, que e o seu indentificador unico
     * @param nome - nome do cliente
     * @param email - email do cliente
     * @param localizacao - local onde o cliente estuda/trabalha na universidade
     * @return caso o cliente seja cadastrado com sucesso e retornado o seu cpf
     */
    public String cadastraCliente(String cpf, String nome, String email, String localizacao) {
        this.validadorString.validaString(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
        this.validadorString.validaString(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
        this.validadorString.validaString(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
        this.validadorString.validaString(localizacao, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");

        if (!(cpf.length() == 11)){
            throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
        }
        if (this.clientes.containsKey(cpf)){
            throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
        }else {
            this.clientes.put(cpf, new Cliente(cpf, nome, email, localizacao));
        }

        return cpf;
    }

    /**
     * Cria uma representaco textual do cliente
     * @param cpf - cpf do cliente que e seu indetificador unico
     * @return uma representacao textual de um cliente
     */
    public String exibeCliente(String cpf) {
        this.validadorString.validaString(cpf, "Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");

        String result;
        if (this.clientes.containsKey(cpf)){
            result = this.clientes.get(cpf).toString();
        }else {
            throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
        }
        return result;
    }

    /**
     * Cria um texto com o resumo de todos os clientes cadastrados no sistema
     * @return a listagem de todos os clientes cadastrados no sistema
     */
    public String listarClientes() {
        ArrayList<String> clientesList = new ArrayList<>();

        for (String cpf : this.clientes.keySet()){
            clientesList.add(this.clientes.get(cpf).toString());
        }

        Collections.sort(clientesList);

        String result = "";
        for (int i = 0; i < clientesList.size(); i++){
            result += clientesList.get(i) + " | ";
        }

        if (!result.equals("")){
            result = result.substring(0, result.length() - 3);
        }
        return result;
    }

    /**
     * Metodo altera algum dos atributos de um cliente (menos o cpf, ja que ele e o indentificador unico de cliente)
     * @param cpf - cpf do cliente, que e seu indentificador unico
     * @param opcao - o nome do atributo que se deseja alterar
     * @param novoValor - o valor que o atributo ira assumir
     */
    public void editarCliente(String cpf, String opcao, String novoValor) {
        this.validadorString.validaString(cpf, "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
        this.validadorString.validaString(novoValor, "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
        this.validadorString.validaString(opcao, "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");

        if (this.clientes.containsKey(cpf)){
            if (opcao.toUpperCase().equals("NOME")){
                this.clientes.get(cpf).setNome(novoValor);
            }else if (opcao.toUpperCase().equals("EMAIL")){
                this.clientes.get(cpf).setEmail(novoValor);
            }else if (opcao.toUpperCase().equals("LOCALIZACAO")){
                this.clientes.get(cpf).setLocalizacao(novoValor);
            }else if (opcao.toUpperCase().equals("CPF")){
                throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser editado.");
            }else {
                throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
            }
        }else {
            throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
        }
    }

    /**
     * Metodo que remove um cliente do sistema
     * @param cpf - cpf do cliente que e seu indentificador unico
     */
    public void removerCliente(String cpf) {
        this.validadorString.validaString(cpf,"Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");

        if(this.clientes.containsKey(cpf)){
            this.clientes.remove(cpf);
        }else {
            throw new IllegalArgumentException("Erro na remocao do cliente: cliente nao existe.");
        }
    }


    /**
     * Metodo que cadastra uma nova compra em um cliente, caso o cliente nao tenha uma conta com o fornecedor,
     * o metodo ira criar uma nova conta
     * @param cpf - cpf do cliente -identificador uncio-
     * @param fornecedor - nome do fornecedor -identificador unico-
     * @param data - data em que a compra foi realizada
     * @param nomeProduto - nome do produto que foi comprado
     * @param descricaoProduto - descricao do produto que foi comprado
     */
    public void cadastraCompra(String cpf, String fornecedor, String data, String nomeProduto, String descricaoProduto) {
        this.validadorString.validaString(cpf, "Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");
        this.validadorString.validaString(fornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
        this.validadorString.validaString(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
        this.validadorString.validaString(nomeProduto, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
        this.validadorString.validaString(descricaoProduto, "Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");

        double preco;
        if (!(cpf.length() == 11)){
            throw new IllegalArgumentException("Erro ao cadastrar compra: cpf invalido.");
        }else if(!this.clientes.containsKey(cpf)){
            throw new IllegalArgumentException("Erro ao cadastrar compra: cliente nao existe.");
        }else if(!(data.length() == 10)){
            throw new IllegalArgumentException("Erro ao cadastrar compra: data invalida.");
        }
        if (!(this.controllerFornecedor.existeFornecedo(fornecedor))){
            throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao existe.");
        }else{
            preco = this.controllerFornecedor.getPrecoProduto(fornecedor, nomeProduto, descricaoProduto);
        }

        this.clientes.get(cpf).cadastrarCompra(fornecedor, data, nomeProduto, descricaoProduto, preco);



    }

    /**
     * Metodo que calcula o quanto um determinado cliente esta devendo a determinado fornecedor
     * @param cpf - cpf do cliente -identificador unico-
     * @param fornecedor - nome do fornecedor -identificador unico
     * @return o valor que um cliente esta devendo a determinado fornecedor
     */
    public String getDebito(String cpf, String fornecedor) {
        this.validadorString.validaString(cpf, "Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");
        this.validadorString.validaString(fornecedor, "Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");

        if (!(cpf.length() == 11)){
            throw new IllegalArgumentException("Erro ao recuperar debito: cpf invalido.");
        }else if (!this.clientes.containsKey(cpf)){
            throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao existe.");
        }else if (!this.controllerFornecedor.existeFornecedo(fornecedor)) {
            throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao existe.");
        }

        return this.clientes.get(cpf).getDebito(fornecedor);
    }

    /**
     * Metodo que cria uma representacao textual de uma contade do cliente em determinado fornecedor
     * @param cpf - cpf do cliente -identificador unico-
     * @param fornecedor - nome do fornecedor -identificador unico-
     * @return uma representacao textual da conta que o cliente tem em determinado fornecedor
     */
    public String getContaEmFornecedor(String cpf, String fornecedor) {
        this.validadorString.validaString(cpf, "Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.");
        this.validadorString.validaString(fornecedor, "Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");

        if (!(cpf.length() == 11)){
            throw new IllegalArgumentException("Erro ao exibir conta do cliente: cpf invalido.");
        }else if (!this.clientes.containsKey(cpf)){
            throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao existe.");
        }
        if (!(this.controllerFornecedor.existeFornecedo(fornecedor))){
            throw new IllegalArgumentException("Erro ao exibir conta do cliente: fornecedor nao existe." );
        }

        return this.clientes.get(cpf).getContaEmfornecedor(fornecedor);
    }

    /**
     * cria uma representacao textual de todas as contas que o cliente tem
     * @param cpf - cpf do cliente -identificador unico-
     * @return todas as contas que o cliente possui
     */
    public String contaCliente(String cpf) {
        this.validadorString.validaString(cpf, "Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.");
        if (!(cpf.length() == 11)){
            throw new IllegalArgumentException("Erro ao exibir contas do cliente: cpf invalido.");
        }else if (!this.clientes.containsKey(cpf)){
            throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao existe.");
        }
        return this.clientes.get(cpf).getConta();
    }

    /**
     * Metodo que realiza o pagamento TOTAL da conta do cliente em determinado fornecedor
     * @param cpf - cpf do cliente
     * @param fornecedor - nome do fornecedor que sera pago
     */
    public void realizaPagamento(String cpf, String fornecedor) {
        this.validadorString.validaString(cpf, "Erro no pagamento de conta: cpf nao pode ser vazio ou nulo.");
        this.validadorString.validaString(fornecedor, "Erro no pagamento de conta: fornecedor nao pode ser vazio ou nulo.");
        this.validadorString.validaTamanho(cpf, 11, "Erro no pagamento de conta: cpf invalido.");

        if (!this.clientes.containsKey(cpf)){
            throw new IllegalArgumentException("Erro no pagamento de conta: cliente nao existe.");
        }else if (!this.controllerFornecedor.existeFornecedo(fornecedor)){
            throw new IllegalArgumentException("Erro no pagamento de conta: fornecedor nao existe.");
        }

        this.clientes.get(cpf).realizaPagamento(fornecedor);
    }




    public void ordenaPor(String criterio) {
        this.validadorString.validaString(criterio, "Erro na listagem de compras: criterio nao pode ser vazio ou nulo.");

        if (criterio.toUpperCase().equals("CLIENTE")) {
            this.criterioOrdenacao = CriterioOrdenacao.CLIENTE;
        }else if (criterio.toUpperCase().equals("FORNECEDOR")) {
            this.criterioOrdenacao = CriterioOrdenacao.FORNECEDOR;
        }else if (criterio.toUpperCase().equals("DATA")){
            this.criterioOrdenacao = CriterioOrdenacao.DATA;
        }else {
            throw new IllegalArgumentException("Erro na listagem de compras: criterio nao oferecido pelo sistema.");
        }
    }

    public String listarCompras() {
        if (this.criterioOrdenacao == CriterioOrdenacao.NAODEFINIDO){
            throw new IllegalArgumentException("Erro na listagem de compras: criterio ainda nao definido pelo sistema.");
        }
        ArrayList<Compra> compras= new ArrayList<Compra>();

        String result = "";
        ArrayList<Cliente> clienteList = new ArrayList<Cliente>();

        for (String cpf : this.clientes.keySet()){
            clienteList.add(this.clientes.get(cpf));
        }

        for (int i = 0; i < clienteList.size(); i++){
            if (clienteList.get(i).existeConta()) {
                compras.addAll(clienteList.get(i).getCompras());
            }
        }



        if (this.criterioOrdenacao == CriterioOrdenacao.CLIENTE) {
            Collections.sort(compras, new ComparadorPorNome());
            for (int i = 0; i < compras.size(); i++) {
                result += compras.get(i).getCliente() + ", " + compras.get(i).getFornecedor() + ", " +
                        compras.get(i).getDescricaoProduto() + ", " + compras.get(i).getData() + " | ";
            }
        }else if (this.criterioOrdenacao == CriterioOrdenacao.FORNECEDOR){
            Collections.sort(compras, new ComparadorPorFornecedor());
            for (int i = 0; i < compras.size(); i++) {
                result +=  compras.get(i).getFornecedor() + ", " + compras.get(i).getCliente() + ", " +
                        compras.get(i).getDescricaoProduto() + ", " + compras.get(i).getData() + " | ";
            }
        }else if (this.criterioOrdenacao == CriterioOrdenacao.DATA){
            Collections.sort(compras, new ComparadorPorData());
            for (int i = 0; i < compras.size(); i++) {
                result +=  compras.get(i).getData() + ", " +  compras.get(i).getCliente() + ", " +
                        compras.get(i).getFornecedor() + ", " + compras.get(i).getDescricaoProduto() + " | ";
            }
        }

        if (!result.equals("")) {
            result = result.substring(0, result.length() - 3);
        }

        return result;
    }
}
