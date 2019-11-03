package lab3Test;

import lab3.Contato;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContatoTest {

    private Contato contato1;
    private Contato contato2;


    @BeforeEach
    void setUp() {
        this.contato1 = new Contato("Caetano", "Albuquerque", "+55", "83", "99999-9999", 1, 5 );
        this.contato1.adicionaTelefone(2, "+55", "83", "3323-2121" );
        this.contato1.adicionaTelefone(3, "+55", "83", "3372-2018");

        this.contato2 = new Contato("Joa", "Albertino", "+55", "43", "3372-2298", 2,1);
    }

    @Test
    public void testNomeInvalido() {
        try {
            Contato contatoInvalido = new Contato(null, "Gaudencio", "+55", "83", "8814-9987", 1, 4);
            fail("Era esperado exceção ao passar código nulo");
        } catch (NullPointerException npe) {}
        try {
            Contato contatoInvalido = new Contato("", "Gaudencio", "+55", "83", "8814-9987", 2, 3);
            fail("Era esperado exceção ao passar uma string vazia");
        } catch (IllegalArgumentException npe) {}
    }

    @Test
    public void testSobrenomeInvalido() {
        try {
            Contato contatoInvalido = new Contato("Matheus", null, "+55", "83", "8814-9987", 1, 4);
            fail("Era esperado exceção ao passar código nulo");
        } catch (NullPointerException npe) {}
        try {
            Contato contatoInvalido = new Contato("Matheus", "", "+55", "83", "8814-9987", 2, 3);
            fail("Era esperado exceção ao passar uma string vazia");
        } catch (IllegalArgumentException npe) {}
    }

    @Test
    public void testNumeroInvalido() {
        try {
            Contato contatoInvalido = new Contato("Matheus", "Gaudencio", "+55", "83", null, 1, 4);
            fail("Era esperado exceção ao passar código nulo");
        } catch (NullPointerException npe) {}
        try {
            Contato contatoInvalido = new Contato("Matheus", "Gaudencio", "+55", "83", "", 2, 3);
            fail("Era esperado exceção ao passar uma string vazia");
        } catch (IllegalArgumentException npe) {}
    }

    @Test
    public void testPaisInvalido() {
        try {
            Contato contatoInvalido = new Contato("matheus", "Gaudencio", null, "83", "8814-9987", 1, 4);
            fail("Era esperado exceção ao passar código nulo");
        } catch (NullPointerException npe) {}
        try {
            Contato contatoInvalido = new Contato("Matheus", "Gaudencio", "", "83", "8814-9987", 2, 3);
            fail("Era esperado exceção ao passar uma string vazia");
        } catch (IllegalArgumentException npe) {}
    }

    @Test
    public void testDddInvalido() {
        try {
            Contato contatoInvalido = new Contato("Matheus", "Gaudencio", "+55", null, "8814-9987", 1, 4);
            fail("Era esperado exceção ao passar código nulo");
        } catch (NullPointerException npe) {}
        try {
            Contato contatoInvalido = new Contato("Matheus", "Gaudencio", "+55", "", "8814-9987", 2, 3);
            fail("Era esperado exceção ao passar uma string vazia");
        } catch (IllegalArgumentException npe) {}
    }

    @Test
    public void testTipoContInvalido() {
        try {
            Contato contatoInvalido = new Contato("Matheus", "Gaudencio", "+55", "83", "8814-9987", 0, 4);
            fail("Era esperado exceção ao passar um numero menor que 1");
        } catch (IllegalArgumentException npe) {}
        try {
            Contato contatoInvalido = new Contato("Matheus", "Gaudencio", "+55", "83", "8814-9987", 4, 3);
            fail("Era esperado exceção ao passar um numero maior que 4");
        } catch (IllegalArgumentException npe) {}
    }

    @Test
    public void testProximidadeInvalido() {
        try {
            Contato contatoInvalido = new Contato("Matheus", "Gaudencio", "+55", "83", "8814-9987", 1, 0);
            fail("Era esperado exceção ao passar um numero menor que 1");
        } catch (IllegalArgumentException npe) {}

        try {
            Contato contatoInvalido = new Contato("Matheus", "Gaudencio", "+55", "83", "8814-9987", 1, 6);
            fail("Era esperado exceção ao passar um numero maior que 5");
        } catch (IllegalArgumentException npe) {}
    }

    @Test
    void getNomeCompleto() {
        String msg = "Esperando obter o nome completo (nome + sobrenome)";
        assertEquals("Caetano Albuquerque", this.contato1.getNomeCompleto(), msg);
        assertEquals("Joa Albertino", this.contato2.getNomeCompleto(), msg);
    }

    @Test
    void adicionaTelefone(){
        String msg = "Eperando obter o novo telefone adicionado";
        this.contato1.adicionaTelefone(2, "+55", "83", "3372-2018");
        this.contato1.adicionaTelefone(1, "+55", "83", "98803-5260");
        assertEquals("CELULAR: " + System.lineSeparator() + "+55 (83) 98803-5260" + System.lineSeparator() + "TRABALHO: "
                    + System.lineSeparator() + "+55 (83) 3372-2018" + System.lineSeparator() + "CASA: "  + System.lineSeparator() +
                    "+55 (83) 3372-2018", this.contato1.getTelefones(), msg);

        this.contato2.adicionaTelefone(1, "+55", "83", "99808-2828");
        this.contato2.adicionaTelefone(3, "+55", "43", "3372-3546");
        assertEquals("CELULAR: " + System.lineSeparator() + "+55 (83) 99808-2828" + System.lineSeparator() + "TRABALHO: "
                + System.lineSeparator() + "+55 (43) 3372-2298" + System.lineSeparator() + "CASA: "  + System.lineSeparator() +
                "+55 (43) 3372-3546", this.contato2.getTelefones(), msg);

    }

    @Test
    void getTelefones() {
        String msg = "Esperando obter um resumo de todos os telefones cadastrados";
        assertEquals("CELULAR: " +System.lineSeparator()+ "+55 (83) 99999-9999" +System.lineSeparator()+
                    "TRABALHO: " +System.lineSeparator()+ "+55 (83) 3323-2121" +System.lineSeparator()+ "CASA: "
                +System.lineSeparator()+ "+55 (83) 3372-2018", this.contato1.getTelefones(), msg);

        assertEquals("TRABALHO: " +System.lineSeparator()+ "+55 (43) 3372-2298", this.contato2.getTelefones(), msg);
    }

    @Test
    void getProximidade() {
        String msg = "Esperando obter o nivel de proximidade do contato";
        assertEquals(5, this.contato1.getProximidade(), msg);
        assertEquals(1, this.contato2.getProximidade(), msg);
    }

    @Test
    void getNome() {
        String msg = "Esperando obter o nome";
        assertEquals("Caetano", this.contato1.getNome(), msg);
        assertEquals("Joa", this.contato2.getNome(), msg);
    }

    @Test
    void equals() {
        Contato contato3 = new Contato("Caetano", "Albuquerque", "+55", "81", "99998-1463", 1, 3);
        assertTrue(this.contato1.equals(contato3));
        assertFalse(this.contato1.equals(this.contato2));
    }
}