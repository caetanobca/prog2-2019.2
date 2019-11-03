package lab3Test;

import lab3.Agenda;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AgendaTest {

    private Agenda agenda1;

    @BeforeEach
    void setUp() {
        this.agenda1 = new Agenda();
        this.agenda1.cadastrarContato(1, "Joa", "Albuquerque", "+55", "83", "10101-9999", 1, 1);
        this.agenda1.cadastrarContato(100, "Caetano", "Oliveira", "+55", "83", "99999-9999", 1, 1);
        this.agenda1.cadastrarContato(50, "Artur", "Albuquerque", "+55", "83", "99838-9999", 1, 1);
    }

    @Test
    void cadastrarContato() {
        assertFalse(this.agenda1.cadastrarContato(0, "Artur", "Albuquerque", "+55", "83", "99999-9099", 1, 5));
        assertFalse(this.agenda1.cadastrarContato(101, "Marta", "Albuquerque", "+55", "83", "90999-9999", 1, 5));
        assertTrue(this.agenda1.cadastrarContato(1, "Joa", "Albuquerque", "+55", "83", "10101-9999", 1, 5));
        assertTrue(this.agenda1.cadastrarContato(100, "Caetano", "Oliveira", "+55", "83", "99999-9999", 1, 5));
    }

    @Test
    void listarContatos() {
        String msg = "Esperando obter uma lista com o nome de todos os contatos";
        assertEquals("1 - Joa Albuquerque" + System.lineSeparator() +"50 - Artur Albuquerque" +
                System.lineSeparator() + "100 - Caetano Oliveira", this.agenda1.listarContatos(), msg);
    }

    @Test
    void mediaProximidade() {
        String msg = "Esperando obter a media do nivel de proximidade com os contatos";
        assertEquals("DISTANTE", this.agenda1.mediaProximidade(), msg);

        this.agenda1.cadastrarContato(3, "Paula", "Albuquerque", "+55", "13", "13201-9999", 1, 5);
        this.agenda1.cadastrarContato(80, "Romeu", "Montequio", "+55", "83", "94444-9999", 1, 5);
        this.agenda1.cadastrarContato(20, "Julieta", "Capuleto", "+55", "32", "83832-9999", 1, 5);

        assertEquals("AMIGO", this.agenda1.mediaProximidade(), msg);
    }

    @Test
    void exibirContato() {
        String msg = "Esperando obter o numero de um contato";
        assertEquals("Joa Albuquerque" + System.lineSeparator() + "CELULAR: " + System.lineSeparator() +
                        "+55 (83) 10101-9999", this.agenda1.exibirContato(1), msg );

        this.agenda1.adicionaTelefone(1, 3, "+55", "83", "3372-2018");

        assertEquals("Joa Albuquerque" + System.lineSeparator() + "CELULAR: " + System.lineSeparator() +
                        "+55 (83) 10101-9999" + System.lineSeparator() + "CASA: " + System.lineSeparator() + "+55 (83) 3372-2018",
                        this.agenda1.exibirContato(1), msg);

        assertEquals("POSICAO INVALIDA!", this.agenda1.exibirContato(3), msg);
    }

    @Test
    void exibirContato1() {
        String msg = "Esperando obter o numero de um contato";
        assertEquals("Joa Albuquerque" + System.lineSeparator() + "CELULAR: " + System.lineSeparator() +
                "+55 (83) 10101-9999", this.agenda1.exibirContato("Joa"), msg );

        this.agenda1.adicionaTelefone(1, 3, "+55", "83", "3372-2018");
        this.agenda1.cadastrarContato(2, "Joa", "Costa", "+55", "83", "998082828", 1, 3);

        assertEquals("Joa Albuquerque" + System.lineSeparator() + "CELULAR: " + System.lineSeparator() +
                        "+55 (83) 10101-9999" + System.lineSeparator() + "CASA: " + System.lineSeparator() + "+55 (83) 3372-2018" +System.lineSeparator()
                        +"Joa Costa" + System.lineSeparator() + "CELULAR: " + System.lineSeparator() + "+55 (83) 998082828",
                this.agenda1.exibirContato("Joa"), msg);

        assertEquals("CONTATO NAO ENCONTRADO", this.agenda1.exibirContato("Carlos"), msg);

    }

    @Test
    void buscaPorAmizade() {
        String msg = "Esperando obter o numero de um contato";
        assertEquals("Joa Albuquerque" + System.lineSeparator() + "CELULAR: " + System.lineSeparator() +
                "+55 (83) 10101-9999" + System.lineSeparator() + "Artur Albuquerque" + System.lineSeparator() +
                "CELULAR: " + System.lineSeparator() + "+55 (83) 99838-9999" + System.lineSeparator()+
                "Caetano Oliveira" + System.lineSeparator() + "CELULAR: " + System.lineSeparator()+
                "+55 (83) 99999-9999", this.agenda1.buscaPorAmizade(1), msg );

        this.agenda1.cadastrarContato(2, "Joa", "Costa", "+55", "83", "998082828", 1, 5);

        assertEquals("Joa Costa" + System.lineSeparator() + "CELULAR: " + System.lineSeparator() + "+55 (83) 998082828",
                this.agenda1.buscaPorAmizade(5), msg);

        assertEquals("CONTATO NAO ENCONTRADO", this.agenda1.buscaPorAmizade(3), msg);
    }

    @Test
    void adicionaTelefone(){
        String msg = "Esperando obter o numero de um contato, com o novo numero adicionado";

        this.agenda1.adicionaTelefone(1, 3, "+55", "83", "3372-2018");

        assertEquals("Joa Albuquerque" + System.lineSeparator() + "CELULAR: " + System.lineSeparator() +
                        "+55 (83) 10101-9999" + System.lineSeparator() + "CASA: " + System.lineSeparator() + "+55 (83) 3372-2018",
                this.agenda1.exibirContato(1), msg);

    }
}