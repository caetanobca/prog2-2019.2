package Tests;

import Scr.Controlador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControladorTest {

    private Controlador controlador;

    @BeforeEach
    void setUp() {
        this.controlador = new Controlador();
        this.controlador.cadastraAluno("001", "Marta Rocha", "Farmacia");
        this.controlador.cadastraAluno("002", "Arthur Brito", "Computacao");
        this.controlador.cadastraAluno("003", "Clara Barbosa","Arquitetura");
        this.controlador.cadastraAluno("004", "Bia Marinho", "Psicologia");

        this.controlador.cadastraGrupo("Calculo");
        this.controlador.cadastraGrupo("Historia");
    }

    @Test
    void cadastraAluno() {
        String msg1 = "Esperando obter true, ja que matricula ainda nao foi cadastrada";

        assertTrue(this.controlador.cadastraAluno("250", "Gabriel Reys", "Computacao"), msg1);
        assertTrue(this.controlador.cadastraAluno("100", "Caetano Albuquerque", "computacao"), msg1);

        String msg2 = "Esperando obter false, ja que a matricula ja foi cadastrada";

        assertFalse(this.controlador.cadastraAluno("250", "Mei-Ling Zhou", "computacao"), msg2);
        assertFalse(this.controlador.cadastraAluno("100", "Caetano Albuquerque", "medicina"), msg2);
        assertFalse(this.controlador.cadastraAluno("001", "Matheus Oliveira", "Historia"), msg2);

    }

    @Test
    void exibirAluno() {
        //Scr.Aluno: 250 - Gabriel Reyes - Computação
        String msg = "Esperando obter um resumo do aluno referente a matricula no formato: " + System.lineSeparator() +
                    "Scr.Aluno: matricula - nome - Curso";
        assertEquals("Scr.Aluno: 001 - Marta Rocha - Farmacia", this.controlador.exibirAluno("001"), msg);
        assertEquals("Scr.Aluno: 002 - Arthur Brito - Computacao", this.controlador.exibirAluno("002"), msg);
    }

    @Test
    void cadastraGrupo() {
        String msg1 = "Esperando obter true, ja que o tema ainda nao foi cadastrada";

        assertTrue(this.controlador.cadastraGrupo("Listas"), msg1);
        assertTrue(this.controlador.cadastraGrupo("Programacao"), msg1);

        String msg2 = "Esperando obter false, ja que o tema ja foi cadastrada e maiusculas e minusculas sao indistintas ";

        assertFalse(this.controlador.cadastraGrupo("listas"), msg2);
        assertFalse(this.controlador.cadastraGrupo("LISTAS"), msg2);
        assertFalse(this.controlador.cadastraGrupo("LiSTas"), msg2);
        assertFalse(this.controlador.cadastraGrupo("Programacao"), msg2);
    }

    @Test
    void alocaAlunoEmGrupo() {
        String msg1 = "Esperando receber -ALUNO ALOCADO!- ja que esse aluno ainda nao foi cadastrado nesse grupo";
        String msg2 = "Esperando receber -ALUNO ALOCADO!- ja que o aluno ja esta no grupo";
        assertEquals("ALUNO ALOCADO!", this.controlador.alocaAlunoEmGrupo("001", "Calculo"), msg1);
        assertEquals("ALUNO ALOCADO!", this.controlador.alocaAlunoEmGrupo("001", "Calculo"), msg2);

        String msg3 = "Esperando obter uma mensagem que diz que o aluno ainda nao foi cadastrado";
        String msg4 = "Esperando obter uma mensagem, que diz que o grupo ainda nao foi cadastrado";
        assertEquals("Scr.Aluno nao cadastrado.", this.controlador.alocaAlunoEmGrupo("005", "Calculo"), msg3);
        assertEquals("Scr.Grupo nao cadastrado.", this.controlador.alocaAlunoEmGrupo("003", "Filosofia"), msg4);
    }

    @Test
    void imprimeGrupo() {
        this.controlador.alocaAlunoEmGrupo("001", "Calculo");
        this.controlador.alocaAlunoEmGrupo("002", "Calculo");

        assertEquals("Alunos do grupo Calculo:" + System.lineSeparator() +
                "* 001 - Marta Rocha - Farmacia" + System.lineSeparator() +
                "* 002 - Arthur Brito - Computacao", this.controlador.imprimeGrupo("Calculo"));

        this.controlador.alocaAlunoEmGrupo("003", "Calculo");

        assertEquals("Alunos do grupo Calculo:" + System.lineSeparator() +
                "* 001 - Marta Rocha - Farmacia" + System.lineSeparator() +
                "* 002 - Arthur Brito - Computacao" + System.lineSeparator() +
                "* 003 - Clara Barbosa - Arquitetura", this.controlador.imprimeGrupo("Calculo"));

        String msg2 = "Esperando uma mensagem dizendo que o grupo nao existe";
        assertEquals("Scr.Grupo nao cadastrado.", this.controlador.imprimeGrupo("Filosofia"), msg2);
    }

    @Test
    void registraResposta() {
        assertEquals("ALUNO REGISTRADO!", this.controlador.registraResposta("001"));
        assertEquals("ALUNO REGISTRADO!", this.controlador.registraResposta("002"));
        assertEquals("ALUNO REGISTRADO!", this.controlador.registraResposta("001"));

        assertEquals("Scr.Aluno nao cadastrado.", this.controlador.registraResposta("555"));
    }

    @Test
    void exibirAlunosRespoderam() {
       this.controlador.registraResposta("001");
       this.controlador.registraResposta("002");

       assertEquals("Alunos: " + System.lineSeparator()+
                            "1. 001 - Marta Rocha - Farmacia" + System.lineSeparator() +
                            "2. 002 - Arthur Brito - Computacao", this.controlador.exibirAlunosRespoderam());

       this.controlador.registraResposta("003");
       this.controlador.registraResposta("001");
       this.controlador.registraResposta("555");

        assertEquals("Alunos: " + System.lineSeparator()+
                "1. 001 - Marta Rocha - Farmacia" + System.lineSeparator() +
                "2. 002 - Arthur Brito - Computacao" + System.lineSeparator() +
                "3. 003 - Clara Barbosa - Arquitetura" + System.lineSeparator() +
                "4. 001 - Marta Rocha - Farmacia", this.controlador.exibirAlunosRespoderam());



    }
}