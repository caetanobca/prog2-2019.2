public class Validacao {

    public void validaString (String testa, String msg){

        if (testa == null){
            throw new NullPointerException(msg);
        }else if (testa.trim().equals("")){
            throw new IllegalArgumentException(msg);
        }

    }
}
