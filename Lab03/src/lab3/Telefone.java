package lab3;

/**
 * Representacao de um telefone completo que existe em um contato, e que tem um tipo, o codigo de pais, o ddd e o numero.
 *
 * @author Caetano Albuquerque
 */
public class Telefone {

    /**
     * String que armazena o ddd, do numero.
     */
    private String ddd;

    /**
     * String que armazena o codigo do pais do numero.
     */
    private String pais;

    /**
     * String que armazena o numero do telefone.
     */
    private String numero;

    /**
     * Determina o tipo do numero (1 - Celular, 2 - Trabalho, 3- Casa).
     */
    private int tipo;

    /**
     * construtor unico da classe telefone que cria o objeto já atribuindo algum valor a todos os parametros.
     * @param pais - codigo do pais do numero
     * @param ddd - ddd do numero
     * @param numero - numero de telefone
     * @param tipo - tipo do numero (Celular/trabalho/Casa)
     */
    public Telefone (String pais, String ddd, String numero, int tipo){
        this.ddd = ddd;
        this.pais = pais;
        this.numero = numero;
        this.tipo = tipo;
    }

    /**
     * Monta uma string que traz todas as informaçoes dos numero de telefone.
     * @return uma String no formato "*Tipo do numero*:
     *                                *pais* (*ddd*) *numero*"
     */
    public String telefoneToString(){
        if (this.tipo == 1){
            return ("CELULAR: " + System.lineSeparator() + this.pais + " (" + this.ddd + ") " + this.numero);
        }else if (this.tipo == 2){
            return ("TRABALHO: " + System.lineSeparator() + this.pais + " (" + this.ddd + ") " + this.numero);
        }else {
            return ("CASA: " + System.lineSeparator() + this.pais + " (" + this.ddd + ") " + this.numero);
        }
    }


}
