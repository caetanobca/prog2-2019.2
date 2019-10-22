import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;
/**
 * Classe criada para Representar um Cliente.
 * Um Cliente tem com atributos CPF, Nome, Email e
 * Localizacao. E usa como indentificador unico o CPF.
 *
 * @author Caetano Albuquerque - UFCG
 */
public class Cliente implements Comparable<Cliente>{

    /**
     * CPF do cliente que e o seu indentificador unico
     */
    private String cpf;

    /**
     * nome do cliente
     */
    private String nome;

    /**
     * email do cliente
     */
    private String email;

    /**
     * Local onde o cliente trabalha/estuda na universidade
     */
    private String localizacao;

    /**
     * Objeto que tem funcoes que permite verificar se uma string e null ou composta apenas de espacos
     */
    private Validacao validadorString;

    /**
     * Mapa que guarda todas contas do clientes nos fornecedores
     */
    private HashMap <String, Conta> contas;

    /**
     * Metodo que cria um objeto do tipo cliente a partir das entradas de cpf, nome, email e localizacao
     * @param cpf - cpf do cliente, que e o seu indentificador unico
     * @param nome - nome do cliente
     * @param email - email do cliente
     * @param localizacao - local onde o cliente estuda/trabalha na universidade
     */
    public Cliente (String cpf, String nome, String email, String localizacao){
        this.validadorString = new Validacao();

        this.validadorString.validaString(cpf, "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
        this.validadorString.validaString(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
        this.validadorString.validaString(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
        this.validadorString.validaString(localizacao, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");

        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.localizacao = localizacao;
        this.contas = new HashMap<String, Conta>();
    }

    /**
     * Metodo que retorna uma representacao textual do cliente na forma de: <NOME - LOCALIZACAO - EMAIL>
     * @return uma representacao textual do cliente
     */
    @Override
    public String toString() {
        return  nome + " - " + localizacao + " - " + email;
    }

    /**
     * Altera o nome do cliente
     * @param nome - novo nome
     */
    public void setNome(String nome) {
        this.validadorString.validaString(nome, "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
        this.nome = nome;
    }

    /**
     * Altera o email do cliente
     * @param email - novo email
     */
    public void setEmail(String email) {
        this.validadorString.validaString(email, "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
        this.email = email;
    }

    /**
     * Altera o local onde o cliente estuda/trabalha na universidade
     * @param localizacao - novo local
     */
    public void setLocalizacao(String localizacao) {
        this.validadorString.validaString(localizacao, "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
        this.localizacao = localizacao;
    }

    /**
     * Metodo que adicona compra em umaconta ja existente ou cria uma nova conta em determinado fornecedor
     * @param fornecedor - nome do fornecedor -identificador unico-
     * @param data - data em que a compra foi realizada
     * @param nomeProduto - nome do produto comprado
     * @param preco - preco do produto comprad
     */
    public void cadastrarCompra(String fornecedor, String data, String nomeProduto, String descricaoProduto, double preco) {
        this.validadorString.validaString(fornecedor, "Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
        this.validadorString.validaString(data, "Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
        this.validadorString.validaString(nomeProduto, "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
        if (this.contas.containsKey(fornecedor)) {
            this.contas.get(fornecedor).adicionaProduto(nomeProduto, descricaoProduto , data, preco);
        } else {
            this.contas.put(fornecedor, new Conta(fornecedor, data, nomeProduto, descricaoProduto, preco));
        }
    }

    /**
     * Metodo que pega o quanto o cliente deve em determinado fornecedor
     * @param fornecedor - nome do fornecedor -identifcador unico-
     * @return o quanto o cliente deve me determinado fornecedor
     */
    public String getDebito(String fornecedor) {
        this.validadorString.validaString(fornecedor, "Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");

        if (!this.contas.containsKey(fornecedor)){
            throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");
        }
        return this.contas.get(fornecedor).getDebito();
    }

    /**
     * metodo que cria uma representacao textual da conta em determinado fornecedor
     * @param fornecedor - nome do fornecedor -identificador unico-
     * @return representacao textual da conta que o cliente tem em determinado fornecedor
     */
    public String getContaEmfornecedor(String fornecedor) {
        this.validadorString.validaString(fornecedor, "Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");

        if (!this.contas.containsKey(fornecedor)){
            throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");
        }
        return ("Cliente: " + this.nome + " | " + this.contas.get(fornecedor).toString());
    }

    /**
     * Metodo que lista todas as contas do cliente
     * @return todas as contas do cliente
     */
    public String getConta() {
        if (this.contas.isEmpty()){
            throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao tem nenhuma conta.");
        }
        ArrayList<String> contasList = new ArrayList<String>();

        for (String fornecedor : this.contas.keySet()){
            contasList.add(this.contas.get(fornecedor).toString());
        }

        Collections.sort(contasList);

        String result = "Cliente: " + this.nome + " | ";
        for (int i = 0; i < contasList.size(); i++){
            result += contasList.get(i) + " | ";
        }

        if (!result.equals("")) {
            result = result.substring(0, result.length() - 3);
        }
        return result;
    }

    /**
     * Compara se dois clientes tem o mesmo cpf
     * @param o - objeto que sera usado na comparacao
     * @return true caso os dois objetos tenham o mesmo cpf e false caso nao
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return cpf.equals(cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    /**
     * metodo que realiza o pagamento de todos os debitos que o cliente tem em um deterrminado fornecedor
     * @param fornecedor - nome do fornecedor que sera pago
     */
    public void realizaPagamento(String fornecedor) {
        this.validadorString.validaString(fornecedor, "Erro no pagamento de conta: fornecedor nao pode ser vazio ou nulo.");

        if (this.contas.containsKey(fornecedor)){
            this.contas.remove(fornecedor);
        }else {
            throw new IllegalArgumentException("Erro no pagamento de conta: nao ha debito do cliente associado a este fornecedor.");
        }
    }

    /**
     * Verifica se existe conta cadastrada em determinado cliente
     * @return True caso o cliente possua alguma conta e false caso nao
     */
    public boolean existeConta() {
        if (this.contas.isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    public String getNome() {
        return nome;
    }

    /**
     * Metodo que define que o criterio de comparacao de clientes e o seu nome
     * @param o - objeto do tipo cliente
     * @return um numero maior q zero se o nome estiver primeiro em ordem alfabetica em relacao ao nome do cliente "o",
     * um numero menor que zero, caso o nome de "o" vinher primeiro e zero caso os nomes sejam iguais.
     */
    @Override
    public int compareTo(Cliente o) {
        return this.nome.compareTo(o.getNome());
    }



    public String getContaPorCliente(CriterioOrdenacao criterioOrdenacao) {
        String result = "";
        ArrayList<String> fornecedorList = new ArrayList<String>();

        for (String fornecedor : this.contas.keySet()){
            fornecedorList.add(fornecedor);
        }

        Collections.sort(fornecedorList);

        for (int i = 0; i < fornecedorList.size(); i++){
            result += this.contas.get(fornecedorList.get(i)).getContaOrdenada(this.nome);
        }
        return result;
    }
}

