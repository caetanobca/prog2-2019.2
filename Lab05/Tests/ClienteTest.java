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
    void setEmail() {
        this.cliente.setEmail("ana.silva@ccc.ufcg.edu.br");
        assertEquals("Ana Silva - Embedded - ana.silva@ccc.ufcg.edu.br", this.cliente.toString());
    }

    @Test
    void setLocalizacao() {
        this.cliente.setLocalizacao("LSD");
        assertEquals("Ana Silva - LSD - anasilva@ccc.ufcg.edu.br", this.cliente.toString());
    }

    @Test
    void equals1() {
        assertFalse(this.cliente.equals(new Cliente("11122233344", "Ana Silva",
                "anasilva@ccc.ufcg.edu.br", "Embedded")));

        assertTrue(this.cliente.equals(new Cliente("00011122233", "Ano Silvao",
                "anosilvao@ccc.ufcg.edu.br", "LSD")));
    }
}