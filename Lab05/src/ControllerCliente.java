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
     * Inicializa o ControllerFornecedor
     */
    public ControllerCliente(){
        this.clientes = new HashMap<String, Cliente>();
        this.validadorString = new Validacao();
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


}
