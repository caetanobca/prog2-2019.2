package Tests;

import Scr.Aluno;
import Scr.Grupo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrupoTest {

    private Grupo grupo1;
    private Aluno aluno1;
    private Aluno aluno2;
    private Aluno aluno3;

    @BeforeEach
    void setUp() {
        this.grupo1 = new Grupo("Listas");

        this.aluno1 = new Aluno("001", "Marta Rocha", "Farmacia");
        this.aluno2 = new Aluno("002", "Arthur Brito", "Computacao");
        this.aluno3 = new Aluno("003", "Clara Barbosa", "Arquitetura");


    }


    @Test
    void exceptionTest() {
        assertThrows(NullPointerException.class,
                ()->{
                    Grupo grupoNull = new Grupo(null);
                });

        assertThrows(IllegalArgumentException.class,
                ()->{
                    Grupo grupoVazio = new Grupo("");
                });
    }

    @Test
    void alocaAluno() {
        this.grupo1.alocaAluno(this.aluno1);
        this.grupo1.alocaAluno(this.aluno2);
        this.grupo1.alocaAluno(this.aluno3);
    }


    @Test
    void toStringTest() {


        this.grupo1.alocaAluno(this.aluno1);
        this.grupo1.alocaAluno(this.aluno2);

        assertEquals("Alunos do grupo Listas:" + System.lineSeparator() +
                    "* 001 - Marta Rocha - Farmacia" + System.lineSeparator() +
                    "* 002 - Arthur Brito - Computacao", this.grupo1.toString());

        this.grupo1.alocaAluno(this.aluno3);

        assertEquals("Alunos do grupo Listas:" + System.lineSeparator() +
                "* 001 - Marta Rocha - Farmacia" + System.lineSeparator() +
                "* 002 - Arthur Brito - Computacao" + System.lineSeparator() +
                "* 003 - Clara Barbosa - Arquitetura", this.grupo1.toString());
    }

    @Test
    void equalsTest() {
        Grupo grupo2 = new Grupo("LISTAS");
        Grupo grupo3 = new Grupo("listas");
        Grupo grupo4 = new Grupo("LIsTas");

        assertTrue(this.grupo1.equals(grupo2));
        assertTrue(this.grupo1.equals(grupo3));
        assertTrue(this.grupo1.equals(grupo4));

        Grupo grupo5 = new Grupo("Historia");

        assertFalse(this.grupo1.equals(grupo5));
    }
}