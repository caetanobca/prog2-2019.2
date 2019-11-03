package Scr;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe criada para representar o controlador
 *
 * O controlador possui um mapa de alunos, no qual as matriculas serao as chaves, um mapa de grupos, no qual
 * os temas serao as chaves, e uma lista dos alunos que responderam alguma pergunta em aula.
 *
 * @author Caetano Bezerra Cavalcanti Albuquerque
 */
public class Controlador {

    /**
     * Mapa, no qual as chaves sao as matriculas dos alunos e os valores sao objetos do tipo Scr.Aluno.
     */
    private HashMap<String, Aluno> mapAlunos;

    /**
     * Mapa, no qual as chaves sao os nomes do grupos e os valores sao objetos do tipo Scr.Grupo.
     */
    private HashMap<String, Grupo> mapGrupos;

    /**
     * ArrayList que guarda os alunos que responderam alguma pergunta em sala.
     */
    private ArrayList<Aluno> listAlunosRespoderam;

    /**
     * Contrutor unico de controlador, que incializa os HashMaps de aluno e grupo e o ArrayList que
     * representa os alunos que responderam em sala
     */
    public Controlador(){
        this.mapAlunos =  new HashMap<>();
        this.mapGrupos = new HashMap<>();
        this.listAlunosRespoderam = new ArrayList<>();
    }

    /**
     * Metodo que cria um objeto do tipo Scr.Aluno e o armazena em um mapa, onde sua chave e sua matricula. Caso a matricula
     * ja esteja cadastrada, a clase retorna false e nao cadastra o aluno.
     * @param matricula - indentificador unico do aluno.
     * @param nome - nome do aluno.
     * @param curso - curso que o aluno esta cursando.
     * @return true caso seja possivel cadastrar o aluno, e false caso nao.
     */
    public boolean cadastraAluno(String matricula, String nome, String curso) {
        boolean result;

        if (!(this.mapAlunos.containsKey(matricula))){
            Aluno aluno = new Aluno(matricula, nome, curso);
            this.mapAlunos.put(matricula, aluno);
            result = true;
        }else{
            result = false;
        }
        return result;
    }

    /**
     * Metodo que a partir da matricula encontra o aluno e retorna um resumo do aluno
     * no formato: "Scr.Aluno: matricula - nome - Curso".
     * @param matricula - a matricula do aluno e usada como chave no mapa que guarda os alunos.
     * @return caso o aluno exista, o metodo retorna um resumo do aluno no formato : "Scr.Aluno: matricula - nome - Curso",
     *         caso nao retorna uma mensagem dizendo que o aluno nao esta cadastrado.
     */
    public String exibirAluno(String matricula) {
        String result;
        if (this.mapAlunos.containsKey(matricula)) {
            result = "Scr.Aluno: " + this.mapAlunos.get(matricula).toString();
        }else{
            result = "Scr.Aluno não cadastrado.";
        }
        return result;
    }

    /**
     * Metodo que cria um objeto do tipo Scr.Grupo e o armazena em um mapa, onde sua chave e seu nome. Caso um grupo com mesmo
     * nome ja esteja cadastrada, a clase retorna false e nao cadastra o Scr.Grupo.
     * @param nome - nome do tema do grupo.
     * @return true caso seja possivel cadastrar o grupo, e false caso nao.
     */
    public boolean cadastraGrupo(String nome) {
        boolean result;
        String chave = nome.toUpperCase();
        if (!(this.mapGrupos.containsKey(chave))){
            Grupo grupo = new Grupo(nome);
            this.mapGrupos.put(chave, grupo);
            result = true;

        }
        else {
            result = false;
        }
        return result;
    }

    /**
     * metodo que aloca um aluno em um grupo.
     * @param matricula - Matricula do aluno que sera usado para acessar o aluno no mapa.
     * @param grupo - Nome do grupo que sera usado para acessar o grupo no mapa.
     * @return uma string dizendo se o aluno foi ou nao alocado no grupo.
     */
    public String alocaAlunoEmGrupo(String matricula, String grupo) {
        String result = "";
        if (this.mapGrupos.containsKey(grupo) && this.mapAlunos.containsKey(matricula)){
            Aluno aluno = this.mapAlunos.get(matricula);
            this.mapGrupos.get(grupo).alocaAluno(aluno);
            result = "ALUNO ALOCADO!";
        }else if(!(this.mapAlunos.containsKey(matricula))){
            result = "Scr.Aluno nao cadastrado.";
        }else if (!(this.mapGrupos.containsKey(grupo))){
            result = "Scr.Grupo nao cadastrado.";
        }
        return result;
    }

    /**
     * metodo que imprime um resumo do grupo que foi solicitado, caso ele exista
     * @param grupo - Nome do grupo que sera usado para acessar o grupo no mapa.
     * @return um resumo do grupo, ou uma mensagem  dizendo que nao existe o grupo
     */
    public String imprimeGrupo(String grupo) {
        String result = "Scr.Grupo nao cadastrado.";
        if (this.mapGrupos.containsKey(grupo)){
           result = this.mapGrupos.get(grupo).toString();
        }
        return result;
    }

    /**
     * Metodo que guarda em um ArrayList informaçoes do aluno que respondeu alguma pergunta em sala
     * @param matricula - Matricula do aluno que sera usado para acessar o aluno no mapa.
     * @return
     */
    public String registraResposta(String matricula) {
        String result;
        if (this.mapAlunos.containsKey(matricula)){
            this.listAlunosRespoderam.add(this.mapAlunos.get(matricula));
            result = "ALUNO REGISTRADO!";
        }else {
            result = "Scr.Aluno nao cadastrado.";
        }
        return result;
    }

    /**
     * metodo cria uma representacao em string dos alunos que responderam perguntas em sala
     * @return - os alunos que respondeream pergunta em sala
     */
    public String exibirAlunosRespoderam() {
        String alunosRespoderam = "Alunos: " + System.lineSeparator();

        for (int i = 0; i < this.listAlunosRespoderam.size(); i ++){
            alunosRespoderam += (i+1) + ". " + this.listAlunosRespoderam.get(i).toString() + System.lineSeparator();
        }
        return alunosRespoderam.substring(0, alunosRespoderam.length() - 1);
    }
}
