package lab2;

import java.util.Arrays;

/**
 * Representacao de uma disciplina, de um aluno de computacao da * UFCG,  com o nome da disciplina,
 * a quantidade de horas que o aluno estudou, as notas em cada prova dessa diciplina e a media
 * final de um aluno nessa disciplina.
 *
 * @author Caetano Bezerra Cavalcanti Albuquerque - 119110355
 */
public class Disciplina {

    /**
     * Nome da disciplina.
     */
    private String nomeDisciplina;

    /**
     * Numero de horas que o aluno estudou (essas horas sao cumulativas).
     */
    private int horas;

    /**
     * Array que guarda todas as notas do aluno na disciplina.
     */
    private double [] notas;

    /**
     * Quantidade de notas que seram registradas, caso o usuario nao definir teremos 4 notas.
     */
    private int qtdNotas;

    /**
     * Os pesos que cada prova tera, caso nao seja definido todas as notas teram o mesmo peso.
     */
    private int [] pesos;

    /**
     * Controi uma disciplina a partir do nome, com a quantidade de notas padrao (4 notas) e
     * os pesos tambem sao padroes (todas as notas com o mesmo peso).
     * @param nomeDisciplina o nome da disciplina.
     */
    public Disciplina(String nomeDisciplina){
        this.nomeDisciplina = nomeDisciplina;
        this.horas = 0;
        this.notas = new double[4];
        this.pesos = new int[1];
        this.pesos[0] = 0;
    }

    /**
     * Constroi uma disciplina a partir do nome dela e da quantidade de notas,
     * com os pesos padroes (todas as notas com o mesmo peso).
     * @param nomeDisciplina o nome da disciplina.
     * @param qtdNotas a quantidade de notas que essa disciplina devera ter.
     */
    public Disciplina(String nomeDisciplina, int qtdNotas){
        this.nomeDisciplina = nomeDisciplina;
        this.horas = 0;
        this.qtdNotas = qtdNotas;
        this.notas = new double[qtdNotas];
        this.pesos = new int[1];
        this.pesos[0] = 0;
    }

    /**
     * Constroi uma disciplina a partir do nome dela, da quantidade de notas e dos pesos.
     * @param nomeDisciplina o nome da disciplina.
     * @param qtdNotas a quantidade de notas que essa disciplina devera ter.
     * @param pesos array com os pesos de todas as notas.
     */
    public Disciplina(String nomeDisciplina, int qtdNotas, int[] pesos){
        this.nomeDisciplina = nomeDisciplina;
        this.horas = 0;
        this.qtdNotas = qtdNotas;
        this.notas = new double[qtdNotas];
        this.pesos = pesos;
    }

    /**
     * Cadastra uma quantidade de horas que o aluno estudou.
     * @param horas inteiro que representa a qunatidade de horas de estudo que estao sendo cadastradas.
     */
    public void cadastraHoras(int horas){
        this.horas += horas;
    }

    /**
     * Cadastra uma nota de uma prova em sua determinada posicao.
     * @param nota inteiro que representa qual das notas esta sendo cadastrada.
     * @param valorNota representa a nota que o aluno obteve na prova.
     */
    public void cadastraNota(int nota, double valorNota) { // notas possíveis: 1, 2, 3 e 4
        this.notas[nota-1] = valorNota;
    }

    /**
     * Calcula e retorna a media ponderada (caso o usuario nao tenha definido os pesos, todas as notas
     * teram o mesmo peso) que o aluno obteve.
     * @return double que representa a media do aluno.
     */
    private double calculaMedia(){
        double media;
        if (this.pesos[0] == 0){
            double somatorio = 0;
            for (int i = 0; i < this.notas.length; i++) {
                somatorio += this.notas[i];
            }
            media = somatorio/this.notas.length;
        }else{
            double somatorioComPeso = 0;
            int somatorioPesos = 0;
            for (int i = 0; i < this.qtdNotas; i++){
                somatorioComPeso += (this.notas[i] * this.pesos[i]);
                somatorioPesos += this.pesos[i];
            }
            media = somatorioComPeso / somatorioPesos;
        }
        return media;
    }

    /**
     * Verifica se o aluno atingiu o minimo para passar na disciplina (a media e 7).
     * @return booleano que assume verdadeiro se a media e maior ou igual a 7.
     */
    public boolean aprovado(){
        if (this.calculaMedia() >= 7){
            return true;
        }
        return false;
    }

    /**
     * Retorna a String que representa o aluno. A representação segue o
     * formato “nomeDisciplina - Nome da disciplina, horasAula - quantidade de horas dessa disciplina,
     * media - a media dessa disciplina, notas - as notas individuais de cada prova dessa disciplina.
     *
     * @return a representação em String de uma disciplina.
     */
    public String toString( ){

        return this.nomeDisciplina + " " + this.horas + " " + this.calculaMedia() + " " + Arrays.toString(this.notas);
    }

}

