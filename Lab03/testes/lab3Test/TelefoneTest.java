package lab3Test;

import lab3.Telefone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TelefoneTest {

    Telefone telefoneCelular;
    Telefone telefoneTrabalho;
    Telefone telefoneCasa;

    @BeforeEach
    void setUp() {
        this.telefoneCelular = new Telefone("+55","83", "99999-9999", 1);
        this.telefoneTrabalho = new Telefone("+12", "42", "3333-0303", 2);
        this.telefoneCasa = new Telefone("+01", "83", "3372-2018", 3);
    }

    @Test
    void getNumeroCompleto() {
        String msg = "Esperando obter um resumo do numero de telefone";
        assertEquals("CELULAR: " + System.lineSeparator() + "+55 (83) 99999-9999",this.telefoneCelular.telefoneToString(), msg);
        assertEquals("TRABALHO: " + System.lineSeparator()+ "+12 (42) 3333-0303",this.telefoneTrabalho.telefoneToString(), msg);
        assertEquals("CASA: " + System.lineSeparator() + "+01 (83) 3372-2018",this.telefoneCasa.telefoneToString(), msg);
    }
}