package lab2;

import java.util.HashMap;
import java.util.Map;

/**
 * Representacao de um aluno de computacao da * UFCG que tem um conjunto de contas em laboratorios,
 * um conjunto de contas em cantinas, um conjunto de disciplinas, um estato de saude e sua matricula
 * @author Caetano Bezerra Cavalcanti Albuquerque - 119110355
 */
public class Aluno {

    /**
     * Um mapa, que usa o nome de determinado laboratorio como chave, para acessar objeto do tipo
     * ContaLaboratorio que tem o mesmo nome.
     */
    private Map<String, ContaLaboratorio> contasLaboratorio;

    /**
     * Um mapa, que usa o nome de determinada disciplina como chave, para acessar objeto do tipo
     * Disciplina que tem o mesmo nome.
     */
    private Map<String, Disciplina> disciplinas;

    /**
     * Um mapa, que usa o nome de determinada cantina como chave, para acessar objeto do tipo
     * ContaCantina que tem o mesmo nome.
     */
    private Map<String, ContaCantina> contasCantina;

    /**
     * Atributo do tipo Saude que tem como funcao armazenar os estado de saude mental e fisica do aluno.
     */
    private Saude saude;

    /**
     * A matricula do aluno, que e o unico meio de indentifica-lo.
     */
    private int matricula;

    /**
     * Constroi um objeto do tipo Aluno, apartir de sua matricula
     * @param matricula meio de indentificacao do aluno
     */
    public Aluno(int matricula){
        this.matricula = matricula;

        this.contasLaboratorio = new HashMap<>();
        this.disciplinas = new HashMap<>();
        this.contasCantina = new HashMap<>();

        this.saude = new Saude();
    }

    /**
     * Cria um objeto do tipo ContaLaboratorio, usando apenas o seu .
     * @param nomeLaboratorio nome do laboratorio no qual esta sendo criada a conta.
     */
    public void cadastraLaboratorio(String nomeLaboratorio){
        this.contasLaboratorio.put(nomeLaboratorio, new ContaLaboratorio(nomeLaboratorio));
    }

    /**
     * Cria um objeto  do tipo ContaLaboratorio, a partir do seu nome e da cota que o aluno tera disponivel.
     * @param nomeLaboratorio nome do laboratorio no qual esta sendo criada a conta.
     * @param cota espaco que sera disponibilizado para o aluno.
     */
    public void cadastraLaboratorio(String nomeLaboratorio, int cota){
        this.contasLaboratorio.put(nomeLaboratorio, new ContaLaboratorio(nomeLaboratorio, cota));
    }

    /**
     * Consome o espaco livre em determinado laboratorio.
     * @param nomeLaboratorio nome do laboratorio que tera sua memoria consumida.
     * @param mbytes espaco que o aluno consumiu.
     */
    public void consomeEspaco(String nomeLaboratorio, int mbytes){
        this.contasLaboratorio.get(nomeLaboratorio).consomeEspaco(mbytes);
    }

    /**
     * Libera espaco em determinado laboratorio.
     * @param nomeLaboratorio nome do laboratorio.
     * @param mbytes espaco que sera liberado.
     */
    public void liberaEspaco(String nomeLaboratorio, int mbytes){
        this.contasLaboratorio.get(nomeLaboratorio).liberaEspaco(mbytes);
    }

    public boolean atingiuCota(String nomeLaboratorio){
        return this.contasLaboratorio.get(nomeLaboratorio).atingiuCota();
    }

    public String laboratorioToString(String nomeLaboratorio){
        return this.contasLaboratorio.get(nomeLaboratorio).toString();
    }

    public void cadastraDisciplina(String nomeDisciplina){
        this.disciplinas.put(nomeDisciplina, new Disciplina(nomeDisciplina));
    }

    public void cadastraHoras(String nomeDisciplina, int horas){
        this.disciplinas.get(nomeDisciplina).cadastraHoras(horas);
    }

    public void cadastraNota(String nomeDisciplina, int nota, double valorNota){
        this.disciplinas.get(nomeDisciplina).cadastraNota(nota, valorNota);
    }

    public boolean aprovado(String nomeDisciplina){
        return this.disciplinas.get(nomeDisciplina).aprovado();
    }

    public String disciplinaToString(String nomeDisciplina){
        return this.disciplinas.get(nomeDisciplina).toString();
    }

    public void cadastraCantina(String nomeCantina){
        this.contasCantina.put(nomeCantina, new ContaCantina(nomeCantina));
    }
    public void cadastraLanche(String nomeCantina, int qtdItens, int valorCentavos){
        this.contasCantina.get(nomeCantina).cadastraLanche(qtdItens, valorCentavos);
    }
    public void pagarConta(String nomeCantina, int valorCentavos){
        this.contasCantina.get(nomeCantina).pagaConta(valorCentavos);
    }

    public int getFaltaPagar(String nomeCantina){
        return this.contasCantina.get(nomeCantina).getFaltaPagar();
    }

    public String cantinaToString(String nomeCantina){
        return this.contasCantina.get(nomeCantina).toString();
    }

    public void defineSaudeMental(String valor){
        this.saude.defineSaudeMental(valor);
    }

    public void defineSaudeFisica(String valor){
        this.saude.defineSaudeFisica(valor);
    }

    public String getStatusGeral(){
        return this.saude.getStatusGeral();
    }
}
