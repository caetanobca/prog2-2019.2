package Scr;

import java.util.HashSet;
import java.util.Objects;

/**
 * Classe criada para representar um Scr.Grupo
 *
 * Os grupo tem um tema (que e o seu identificador unico), e um conjunto de Alunos
 *
 * @author Caetano Bezerra Cavalcanti Albuquerque
 */
public class Grupo {

    /**
     * Tema do grupo, que é o seu indentificador unico (nao e feita a dinsticao entre letras maiusculas e minusculas
     */
    private String tema;

    /**
     * HashSet que guarda os Alunos que foram associados ao grupo
     */
    private HashSet<Aluno> setAlunos;

    /**
     * Construtor de grupo que recebe seu tema, e inicializa o hashSet de alunos
     * @param tema nome do grupo de estudos
     */
    public Grupo(String tema) {

        if (tema.trim().equals("")) {
            throw  new IllegalArgumentException("");
        }
        if (tema == null) {
            throw new NullPointerException();
        }

        this.tema = tema;
        this.setAlunos = new HashSet<>();
    }

    /**
     * Adiciona um aluno ao grupo de estudo
     * @param aluno - objeto do tipo Scr.Aluno que devera ser adicionado ao grupo
     */
    public void alocaAluno(Aluno aluno) {
        this.setAlunos.add(aluno);
    }

    /**
     * monta uma representacao do grupo de estudos, que mostra o nome do grupo e todos os alunos que fazem parte do grupo
     * @return uma string que resume o grupo
     */
    @Override
    public String toString() {
       String result = "Alunos do grupo " +  this.tema + ":" + System.lineSeparator();

       for (Aluno aluno : this.setAlunos){
           result += "* " + aluno.toString() + System.lineSeparator();
       }

       return result.substring(0, result.length() - 2);
    }

    /**
     * Verifica se dois grupos sao iguais, tomando como parametro o tema do grupo
     * @param o - grupo que sera comparado com o em questao
     * @return true caso os temas forem iguais e false caso nao
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grupo grupo = (Grupo) o;
        return Objects.equals(tema.toUpperCase(), grupo.tema.toUpperCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(tema);
    }
}
