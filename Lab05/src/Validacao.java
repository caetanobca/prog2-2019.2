/**
 * Classe criada para Representar um validador de entradas
 *
 * @author Caetano Albuquerque - UFCG
 */
public class Validacao {

    public void validaString (String testa, String msg){

        if (testa == null){
            throw new NullPointerException(msg);
        }else if (testa.trim().equals("")){
            throw new IllegalArgumentException(msg);
        }

    }

    public void validaTamanho(String testa, int tamanho, String msg) {
        if (!(testa.length() == tamanho)){
            throw new IllegalArgumentException(msg);
        }
    }

    public void validaDouble(double testa, double minimo, double maximo, String msg){
        if(testa < minimo){
            throw new IllegalArgumentException(msg);
        }else if(testa > maximo){
            throw new IllegalArgumentException(msg);
        }
    }

    public void validaData(String data, String msg){

    }
}