import java.util.HashMap;

public class Facade {

    private ControllerCliente controllerCliente;

    public Facade(){
        this.controllerCliente = new ControllerCliente();
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

    public void editarCliente (String cpf, String opcao, String mudanca){
        this.controllerCliente.editarCliente(cpf, opcao, mudanca);
    }

    public String removerCliente(String cpf){
        return this.controllerCliente.removerCliente(cpf);
    }



}
