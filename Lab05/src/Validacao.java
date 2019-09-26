public class Validacao {

    public void validaString (String testa){
        if (testa.trim().equals("")){
            throw new IllegalArgumentException("String vazia ou composta apenas por espacos");
        }else if (testa == null){
            throw new NullPointerException("String nula");
        }
    }
}
