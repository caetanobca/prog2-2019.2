package lab2;

/**
 * Representacao das contas dos laboratorios de um estudante de computacao da * UFCG.
 * Toda conta de laboratorio precisa ter o nome do leboratorio e deve ser identificado unicamente por este nome.
 *
 * @author Caetano Bezerra Cavalcanti Albuquerque - 119110355
 */

public class ContaLaboratorio {

    /**
     * Nome do laboratorio.
      */
    private String nomeLaboratorio;

    /**
     * Cota da memoria, em mb que o aluno tem disponivel.
      */
    private int cota;

    /**
     * Espaco utilizado pelo o aluno na memoria desse laboratorio.
      */
    private  int espacoOcupado;

    /**
     * Metodo que inicializa um objeto do tipo lab2.ContaLaboratorio,
     * com uma cota padrao de 2000 mgb (aproximadamente 2GB).
     * @param nomeLaboratorio String que representa o nome do laboratoro.
     */
    public ContaLaboratorio(String nomeLaboratorio){
        this.cota = 2000;
        this.nomeLaboratorio = nomeLaboratorio;
        this.espacoOcupado = 0;
    }

    /**
     * Metodo que inicializa um objeto do tipo lab2.ContaLaboratorio, com uma "cota nao padrao".
     * @param nomeLaboratorio String que representa o nome do laboratoro.
     * @param cota inteiro que representa o espaco limite de memoria disponivel para o usuario nesse laboratorio.
     */
    public ContaLaboratorio(String nomeLaboratorio, int cota){
        this.cota = cota;
        this.nomeLaboratorio = nomeLaboratorio;
        this.espacoOcupado = 0;
    }

    /**
     * Ocupa espaco de memoria na conta.
     * @param mbytes inteiro que representa a quantidade de memoria, em mb, que sera consumido da conta.
     */
    public void consomeEspaco(int mbytes){
        this.espacoOcupado += mbytes;
    }

    /**
     * libera espaco de memoria que ja tenha sido utilizado.
     * @param mbytes inteiro que representa a quantidade de memoria, em mb, que sera liberado da conta.
     */
    public void liberaEspaco(int mbytes){
        this.espacoOcupado -= mbytes;
    }

    /**
     * Verifica se o aluno atingiu o limite de memoria (cota) de sua conta nesse laboratorio.
     * @return Um booleano que retorna verdade se passou do limite e falso se esta abaixo do limite.
     */
    public boolean atingiuCota(){
        if (this.espacoOcupado >= this.cota){
            return true;
        }
        return false;
    }

    /**
     * Retorna a String que resume os principais estados do objeto, mostrando o nome do laboratorio,
     * o total de espaco utilizado e o total de memoria do laboratorio (cota).
     * @return a representação em String das informacoes referentes ao laboratorio.
     */
    public String toString(){
        return this.nomeLaboratorio + " " + this.espacoOcupado + "/" + this.cota;
    }

}
