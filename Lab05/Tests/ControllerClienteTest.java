import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerClienteTest {

    private ControllerCliente controllerCliente;

    @BeforeEach
    void setUp() {
        this.controllerCliente = new ControllerCliente();
        this.controllerCliente.cadastraCliente("33322211100", "Ano Silvao", "anosilvao@ccc.ufcg.edu.br", "LSD");
    }

    @Test
    void cadastraCliente() {
        this.controllerCliente.cadastraCliente("00011122233", "Ana Silva", "anasilva@ccc.ufcg.edu.br", "Embedded");
        assertEquals("Ana Silva - Embedded - anasilva@ccc.ufcg.edu.br",
                this.controllerCliente.exibeCliente("00011122233"));
    }

    @Test
    void exibeCliente() {
        assertEquals("Ano Silvao - LSD - anosilvao@ccc.ufcg.edu.br",
                this.controllerCliente.exibeCliente("33322211100"));
    }

    @Test
    void listarClientes() {
        this.controllerCliente.cadastraCliente("00011122233", "Ana Silva", "anasilva@ccc.ufcg.edu.br", "Embedded");
        assertEquals("Ano Silvao - LSD - anosilvao@ccc.ufcg.edu.br | Ana Silva - Embedded - anasilva@ccc.ufcg.edu.br",
                this.controllerCliente.listarClientes());
    }

    @Test
    void editarCliente() {
        assertEquals("Ano Silvao - LSD - anosilvao@ccc.ufcg.edu.br",
                this.controllerCliente.exibeCliente("33322211100"));

        this.controllerCliente.editarCliente("33322211100", "nome", "Ana Silva");
        assertEquals("Ana Silva - LSD - anosilvao@ccc.ufcg.edu.br",
                this.controllerCliente.exibeCliente("33322211100"));

        this.controllerCliente.editarCliente("33322211100", "email", "anasilva@ccc.ufcg.edu.br");
        assertEquals("Ana Silva - LSD - anasilva@ccc.ufcg.edu.br",
                this.controllerCliente.exibeCliente("33322211100"));

        this.controllerCliente.editarCliente("33322211100", "localizacao", "Embedded");
        assertEquals("Ana Silva - Embedded - anasilva@ccc.ufcg.edu.br",
                this.controllerCliente.exibeCliente("33322211100"));
    }

    @Test
    void removerCliente() {
        this.controllerCliente.cadastraCliente("00011122233", "Ana Silva", "anasilva@ccc.ufcg.edu.br", "Embedded");
        assertEquals("Ano Silvao - LSD - anosilvao@ccc.ufcg.edu.br | Ana Silva - Embedded - anasilva@ccc.ufcg.edu.br",
                this.controllerCliente.listarClientes());

        this.controllerCliente.removerCliente("00011122233");

        assertEquals("Ano Silvao - LSD - anosilvao@ccc.ufcg.edu.br",
                this.controllerCliente.listarClientes());
    }
}