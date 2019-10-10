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
public class Cliente {

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
        this.contas = new HashMap<>();
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

    public void cadastrarCompra(String fornecedor, String data, String nomeProduto, double preco) {
        if (this.contas.containsKey(fornecedor)){
            throw new IllegalArgumentException("Fconta ja feita");
        }
        this.contas.put(fornecedor, new Conta(fornecedor, data, nomeProduto, preco));
    }

    public double getDebito(String fornecedor) {
        return this.contas.get(fornecedor).getDebito();
    }

    public String getContaEmfornecedor(String fornecedor) {
        return this.contas.get(fornecedor).toString();
    }

    public String getConta() {
        ArrayList<String> contasList = new ArrayList<>();

        for (String fornecedor : this.contas.keySet()){
            contasList.add(this.contas.get(fornecedor).toString());
        }

        Collections.sort(contasList);

        String result = "";
        for (int i = 0; i < contasList.size(); i++){
            result += contasList.get(i) + System.lineSeparator();
        }

        if (!result.equals("")) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }
}
