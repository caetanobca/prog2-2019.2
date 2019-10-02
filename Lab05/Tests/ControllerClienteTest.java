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
    void cadastraClienteNull(){
        assertThrows(NullPointerException.class, () -> {
            this.controllerCliente.cadastraCliente(null, "ana", "ana.ana@gmail.com", "LSD");
        });
        assertThrows(NullPointerException.class, () -> {
            this.controllerCliente.cadastraCliente("55522277782", null, "ana.ana@gmail.com", "LSD");
        });
        assertThrows(NullPointerException.class, () -> {
            this.controllerCliente.cadastraCliente("55522277782", "ana", null, "LSD");
        });
        assertThrows(NullPointerException.class, () -> {
            this.controllerCliente.cadastraCliente("55522277782", "ana", "ana.ana@gmail.com", null);
        });
    }

    @Test
    void cadastraClienteVazio(){
        assertThrows(IllegalArgumentException.class, () -> {
            this.controllerCliente.cadastraCliente("", "ana", "ana.ana@gmail.com", "LSD");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            this.controllerCliente.cadastraCliente("55522277782", "", "ana.ana@gmail.com", "LSD");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            this.controllerCliente.cadastraCliente("55522277782", "ana", "", "LSD");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            this.controllerCliente.cadastraCliente("55522277782", "ana", "ana.ana@gmail.com", "");
        });

    }

    @Test
    void exibeCliente() {
        assertEquals("Ano Silvao - LSD - anosilvao@ccc.ufcg.edu.br",
                this.controllerCliente.exibeCliente("33322211100"));
    }

    @Test
    void exibeClienteNull(){
        assertThrows(NullPointerException.class, () -> {
            this.controllerCliente.exibeCliente(null);
        });

    }

    @Test
    void exibeClienteVazio(){
        assertThrows(IllegalArgumentException.class, () -> {
            this.controllerCliente.exibeCliente("");
        });
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
    void editarClienteNull(){
        assertThrows(NullPointerException.class, () -> {
            this.controllerCliente.editarCliente(null, "nome", "Caetano");
        });
        assertThrows(NullPointerException.class, () -> {
            this.controllerCliente.editarCliente("00011122233", null, "Caetano");
        });
        assertThrows(NullPointerException.class, () -> {
            this.controllerCliente.editarCliente("00011122233", "nome", null);
        });
    }

    @Test
    void editarClienteVazio(){
        assertThrows(IllegalArgumentException.class, () -> {
            this.controllerCliente.editarCliente("", "nome", "Caetano");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            this.controllerCliente.editarCliente("00011122233", "", "Caetano");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            this.controllerCliente.editarCliente("00011122233", "nome", "");
        });
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

    @Test
    void removerClienteNull(){
        assertThrows(NullPointerException.class, () -> {
            this.controllerCliente.removerCliente(null);
        });

    }

    @Test
    void removerClienteVazio(){
        assertThrows(IllegalArgumentException.class, () -> {
            this.controllerCliente.removerCliente("");
        });

    }
}