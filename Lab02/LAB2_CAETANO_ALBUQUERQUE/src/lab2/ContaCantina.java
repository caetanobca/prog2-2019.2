package lab2;

/**
 * Representacao das contas de cantina de um aluno, de computacao da * UFCG.
 * Toda conta de cantina precisa ter o nome da cantina e deve ser identificado unicamente por este nome.
 *
 * @author Caetano Bezerra Cavalcanti Albuquerque - 119110355
 */

public class ContaCantina {

    /**
     *Nome da cantina.
      */
    private String nomeDaCantina;

    /**
     * Quanto o aluno tem em dividas atualmente, em centavos.
      */
    private int debitoAtual;

    /**
     * Qunatidade total de itens comprados.
      */
    private int qtdItens;

    /**
     * Valor, em centavos, de todas as compras realizadas.
     */
    private int totalCompras;

    /**
     * Array que guarda os 5 ultimos detalhes de compras.
      */
    private String[] detalhes;

    /**
     * Quantidade de detalhes de compras salvos.
      */
    private int qtdDetalhes;

    /**
     * Constroi uma conta para uma cantina a partir do nome da cantina.
     * @param nomeDaCantina uma String que representa a cantina a qual a conta esta se referindo.
     */
    public ContaCantina(String nomeDaCantina){
        this.nomeDaCantina = nomeDaCantina;
        this.debitoAtual = 0;
        this.qtdItens = 0;
        this.qtdDetalhes = 0;
        this.detalhes = new String[5];
    }

    /**
     * Metodo criado para cadastro de lanche em lab2.ContaCantina e acrescentar na divida dessa
     * conta o valor dessa compra.
     * @param qtdItens Inteiro que representa a quantidade de itens adquiridos nessa compra
     * @param valorCentavos Inteiro que representa o valor, em centavos, gasto nessa compra.
     */
    public void cadastraLanche(int qtdItens, int valorCentavos){
        this.debitoAtual += valorCentavos;
        this.totalCompras += valorCentavos;
        this.qtdItens += qtdItens;
    }

    /**
     * Metodo criado para cadastrar lanche, acrescentar na divida dessa
     * conta o valor dessa compra e salvar uma especificacao do lanche.
     * @param qtdItens Inteiro que representa a quantidade de itens adquiridos nessa compra
     * @param valorCentavos Inteiro que representa o valor, em centavos, gasto nessa compra
     * @param detalhes String que representa a especificacao do lanche.
     */
    public void cadastraLanche(int qtdItens, int valorCentavos, String detalhes){
        this.debitoAtual += valorCentavos;
        this.totalCompras += valorCentavos;
        this.qtdItens += qtdItens;

        if (this.qtdDetalhes == 5){
            for (int i = 0; i < 4; i++){
                this.detalhes[i] = this.detalhes[i+1];
            }

            this.detalhes[4] = detalhes;

        }else {
            this.detalhes[this.qtdDetalhes] = detalhes;
            this.qtdDetalhes++;
        }

    }

    /**
     * Metodo que subtrai um valor da divida.
     * @param valorCentavos Inteiro que representa o valor, em centavos, que esta sendo pago.
     */
    public void pagaConta(int valorCentavos){
        this.debitoAtual -= valorCentavos;
    }

    /**
     *Metodo utilizado para saber quanto o aluno ainda deve.
     * @return Um inteiro representando a divida.
     */
    public int getFaltaPagar( ){
        return this.debitoAtual;
    }

    /**
     * Retorna a String que resume o estado da cantina, mostrando o nome da cantina,
     * o total de itens comprados e o valor total das compras.
     *
     * @return a representação em String das principais informacoes do objeto.
     */
    public String toString( ){
        return this.nomeDaCantina + " " + this.qtdItens + " " + this.totalCompras;
    }

    /**
     * Retorna uma String que conrem os 5 ultimos detalhes registrados.
     *
     * @return a representação em String dos detalhes.
     */
    public String listarDetalhes( ) {
        String temporaria = "";
        for (int i = 0; i < qtdDetalhes; i++){
            temporaria += this.detalhes[i] + "\n";
        }
        return temporaria;
    }

}
