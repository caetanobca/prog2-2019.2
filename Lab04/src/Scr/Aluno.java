package Scr;

import java.util.Objects;

/**
 * Classe criada para representar um Scr.Aluno
 *
 * Os alunos tem uma matricula (que e o seu identificador unico), um nome e um curso
 *
 * @author Caetano Bezerra Cavalcanti Albuquerque
 */
public class Aluno {

    /**
     * Matricula do grupo, que é o seu indentificador unico.
     */
    private String matricula;

    /**
     * nome do aluno.
     */
    private String nome;

    /**
     * Curso que o aluno esta estudando.
     */
    private String curso;


    /**
     * Contrutor de aluno que o cria a partir de sua matricula(indentificador unico), nome e curso
     * @param matricula - indentificador unico
     * @param nome - nome do aluno
     * @param curso - curso que o aluno esta cursando
     */
    public Aluno(String matricula, String nome, String curso) {

        if (matricula.trim().equals("") || nome.trim().equals("") || curso.trim().equals("")) {
            throw new IllegalArgumentException("");
        }

        if (matricula == null || nome == null || curso == null) {
            throw new NullPointerException();
        }

        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    /**
     * Metodo que monta e retorna uma representacao do aluno no formato:
     * matricula - nome - curso
     * @return resumo do aluno no formato %matricula - nome - curso
     */
    @Override
    public String toString() {
        return matricula + " - " + nome + " - " + curso;
    }

    /**
     * Metodo equals que usa como parametro de comparacao a matricula do aluno
     * @param o
     * @return true caso as matriculas forem iguais e false caso nao
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(matricula, aluno.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }
}
