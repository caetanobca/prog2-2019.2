import SAGA.Cliente.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        this.cliente = new Cliente("00011122233", "Ana Silva", "anasilva@ccc.ufcg.edu.br", "Embedded");
    }

    @Test
    void toString1() {
        assertEquals("Ana Silva - Embedded - anasilva@ccc.ufcg.edu.br", this.cliente.toString());
    }

    @Test
    void setNome() {
        this.cliente.setNome("Anna Silva");
        assertEquals("Anna Silva - Embedded - anasilva@ccc.ufcg.edu.br", this.cliente.toString());
    }

    @Test
    void setNomeNull(){
        assertThrows(NullPointerException.class, () -> {
            this.cliente.setNome(null);
        });
    }

    @Test
    void setNomeVazio(){
        assertThrows(IllegalArgumentException.class, () -> {
            this.cliente.setNome("");
        });
    }

    @Test
    void setEmail() {
        this.cliente.setEmail("ana.silva@ccc.ufcg.edu.br");
        assertEquals("Ana Silva - Embedded - ana.silva@ccc.ufcg.edu.br", this.cliente.toString());
    }

    @Test
    void setEmailNull(){
        assertThrows(NullPointerException.class, () -> {
            this.cliente.setEmail(null);
        });
    }

    @Test
    void setEmailVazio(){
        assertThrows(IllegalArgumentException.class, () -> {
           this.cliente.setEmail("");
        });
    }

    @Test
    void setLocalizacao() {
        this.cliente.setLocalizacao("LSD");
        assertEquals("Ana Silva - LSD - anasilva@ccc.ufcg.edu.br", this.cliente.toString());
    }

    @Test
    void setLocalizacaoNull(){
        assertThrows(NullPointerException.class, () -> {
            this.cliente.setLocalizacao(null);
        });
    }

    @Test
    void setLocalizacaoVazia(){
        assertThrows(IllegalArgumentException.class, () -> {
            this.cliente.setLocalizacao("");
        });
    }

    @Test
    void equals1() {
        assertFalse(this.cliente.equals(new Cliente("11122233344", "Ana Silva",
                "anasilva@ccc.ufcg.edu.br", "Embedded")));

        assertTrue(this.cliente.equals(new Cliente("00011122233", "Ano Silvao",
                "anosilvao@ccc.ufcg.edu.br", "LSD")));
    }

    @Test
    void cadastrarCompra() {
    }

    @Test
    void cadastrarCompraNull() {
        assertThrows(NullPointerException.class, () -> {
            this.cliente.cadastrarCompra(null, "14/11/2018", "Bala", "bala de menta", 0.10);
        });
        assertThrows(NullPointerException.class, () -> {
            this.cliente.cadastrarCompra("Dona Ines", null, "Bala", "bala de menta", 0.10);
        });
        assertThrows(NullPointerException.class, () -> {
            this.cliente.cadastrarCompra("Dona Ines", "14/11/2018", null, "bala de menta", 0.10);
        });
        assertThrows(NullPointerException.class, () -> {
            this.cliente.cadastrarCompra("Dona Ines", "14/11/2018", "Bala", null, 0.10);
        });
    }

    @Test
    void cadastrarCompraVazia() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.cliente.cadastrarCompra("", "14/11/2018", "Bala", "bala de menta", 0.10);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            this.cliente.cadastrarCompra("Dona Ines", "", "Bala", "bala de menta", 0.10);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            this.cliente.cadastrarCompra("Dona Ines", "14/11/2018", "", "bala de menta", 0.10);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            this.cliente.cadastrarCompra("Dona Ines", "14/11/2018", "Bala", "", 0.10);
        });
    }


    @Test
    void getDebito() {
    }

    @Test
    void getContaEmfornecedor() {
    }

    @Test
    void getConta() {
    }

    @Test
    void realizaPagamento() {
    }

    @Test
    void existeConta() {
    }

    @Test
    void getCompras() {
    }


}