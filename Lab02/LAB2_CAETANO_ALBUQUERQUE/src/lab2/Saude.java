package lab2;

/**
 * Representacao do estado de saude de um estudante de computacao da * UFCG.
 *
 * @author Caetano Bezerra Cavalcanti Albuquerque
 */

public class Saude {

    /**
     * Estado de saude mental do aluno.
      */
    private String saudeMental;

    /**
     * Estado de saude fisica do aluno.
      */
    private String saudeFisica;

    /**
     * Emoji, que da uma liberdade para que o aluno descreva sua ultima sensacao em geral
      */
    private String emoji;

    /**
     * Metodo utilizado para inicializar um objeto do tipo lab2.Saude tomando como valores
     * bases para saudeFisica e saudeMental o estado "boa" e para o emoji uma String vazia.
     */
    public Saude(){
        this.saudeFisica = "boa";
        this.saudeMental = "boa";
        this.emoji = "";
    }

    /**
     * Define um novo valor para saude mental. E caso esse valor não for igual ao
     * que ja tinhamos, o emoji sera apagado
     * @param valor String que define o estado de saude mental.
     */
    public void defineSaudeMental(String valor){
        if (!valor.equals(this.saudeMental)){
            this.emoji = "";
        }
        this.saudeMental = valor;
    }

    /**
     * Define um novo valor para saude fisica. E caso esse valor não for igual ao
     * que ja tinhamos, o emoji sera apagado
     * @param valor String que define o estado de saude fisica.
     */
    public void defineSaudeFisica(String valor){
        if (!valor.equals(this.saudeFisica)){
            this.emoji = "";
        }
        this.saudeFisica = valor;
    }

    /**
     * Metodo utilizado para atribuir valor ao atributo emoji.
     * @param valor que sera atribuido ao atributo emoji.
     */
    public void definirEmoji(String valor){
        this.emoji = valor;
    }

    /**
     * Retorna a String que resume os principais estados do objeto, mostrando o qualificador
     * (boa, ok e fraca), seguido (caso exista um emoji registrado) de um emoji.
     * @return a representação em String do estado de saude de um aluno.
     */
    public String getStatusGeral(){
        if (this.saudeFisica.equals(this.saudeMental)){
            if ("boa".equals(this.saudeMental)){
                return  "boa" + "  " +this.emoji ;
            }
            return "fraca" + "  " + this.emoji;
        }
        return "ok" + "  " + this.emoji;
    }
}
