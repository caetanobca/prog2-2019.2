package Tests;

import Scr.Aluno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    private Aluno aluno1;
    private Aluno aluno2;
    private Aluno aluno3;
    private Aluno aluno4;

    @BeforeEach
    void setUp() {
        this.aluno1 = new Aluno("001", "Marta Rocha", "Farmacia");
        this.aluno2 = new Aluno("002", "Arthur Brito", "Computacao");
        this.aluno3 = new Aluno("003", "Clara Barbosa", "Arquitetura");
        this.aluno4 = new Aluno("004", "Beatriz Marinho", "Psicologia");
    }

    @Test
    void exceptionTest() {
        assertThrows(NullPointerException.class,
                ()->{
                    Aluno alunoNull = new Aluno(null, "Caetano Albuquerque", "Computacao");
                });

        assertThrows(NullPointerException.class,
                ()->{
                    Aluno alunoNull = new Aluno("005", null, "Computacao");
                });

        assertThrows(NullPointerException.class,
                ()->{
                    Aluno alunoNull = new Aluno("005", "Caetano Albuquerque", null);
                });



        assertThrows(IllegalArgumentException.class,
                ()->{
                    Aluno alunoVazio = new Aluno("", "Caetano Albuquerque", "Computacao");
                });

        assertThrows(IllegalArgumentException.class,
                ()->{
                    Aluno alunoVazio = new Aluno("005", "", "Computacao");
                });
        assertThrows(IllegalArgumentException.class,
                ()->{
                    Aluno alunoVazio = new Aluno("005", "Caetano Albuquerque", "");
                });
    }

    @Test
    void toStringTest() {
        assertEquals("001 - Marta Rocha - Farmacia", this.aluno1.toString());
        assertEquals("002 - Arthur Brito - Computacao", this.aluno2.toString());
        assertEquals("003 - Clara Barbosa - Arquitetura", this.aluno3.toString());
    }

    @Test
    void equalsTest() {
        Aluno aluno5 = new Aluno("004", "Caetano Albuquerque", "Computacao");
        Aluno aluno6 = new Aluno("005", "Beatriz Marinho", "Psicologia");

        assertTrue(this.aluno4.equals(aluno5));
        assertFalse(this.aluno4.equals(aluno6));
    }
}