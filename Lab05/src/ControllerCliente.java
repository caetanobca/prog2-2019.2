import java.util.HashMap;

public class ControllerCliente {
    private HashMap<String, Cliente> clientes;
    private Validacao validadorString;

    public ControllerCliente(){
        this.clientes = new HashMap<String, Cliente>();
        this.validadorString = new Validacao();
    }

    public String cadastraCliente(String cpf, String nome, String email, String localizacao) {
        this.validadorString.validaString(cpf);
        this.validadorString.validaString(nome);
        this.validadorString.validaString(email);
        this.validadorString.validaString(localizacao);

        if (this.clientes.containsKey(cpf)){
            throw new IllegalArgumentException("CPF ja cadastrado");
        }else {
            this.clientes.put(cpf, new Cliente(cpf, nome, email, localizacao));
        }

        return cpf;
    }

    public String exibeCliente(String cpf) {
        this.validadorString.validaString(cpf);

        String result = "Cliente nao cadastrado";
        if (this.clientes.containsKey(cpf)){
            result = this.clientes.get(cpf).toString();
        }
        return result;
    }

    public String listarClientes() {
        String result = "";
        for (String cpf : this.clientes.keySet()){
            result += this.clientes.get(cpf).toString() + " | ";

        }
        return result.substring(0, result.length() - 3);
    }

    public void editarCliente(String cpf, String opcao, String mundanca) {
        this.validadorString.validaString(cpf);
        this.validadorString.validaString(mundanca);
        this.validadorString.validaString(opcao);

        if (this.clientes.containsKey(cpf)){
            if (opcao.toUpperCase().equals("NOME")){
                this.clientes.get(cpf).setNome(mundanca);
            }else if (opcao.toUpperCase().equals("EMAIL")){
                this.clientes.get(cpf).setEmail(mundanca);
            }else if (opcao.toUpperCase().equals("LOCALIZACAO")){
                this.clientes.get(cpf).setLocalizacao(mundanca);
            }else {
                throw new IllegalArgumentException("Opcao invalida");
            }
        }else {
            throw new IllegalArgumentException("CPF nao cadastrado");
        }
    }

    public String removerCliente(String cpf) {
        this.validadorString.validaString(cpf);

        String result = "Cliente ja nao existia";
        if(this.clientes.containsKey(cpf)){
            this.clientes.remove(cpf);
            result = "Cliente removido";
        }
        return result;
    }
}
