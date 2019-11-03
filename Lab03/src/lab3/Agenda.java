package lab3;
/**
 * Representacao de uma agenda que pode armazenar ate 100 contatos.
 *
 * @author Caetano Albuquerque
 */
public class Agenda {

    /**
     * Array do tipo Contato que armazena ate 100 contatos diferentes.
     */
    private Contato[] contatos;

    /**
     * Construtor que define o tamanho do array de contatos como 100.
     */
    public Agenda(){
        this.contatos = new Contato[100];
    }

    /**
     * Caso nao exista nenhum contato na posicao solicitada, o metodo fica responsavel por
     * criar um novo objeto do tipo Contato, caso ja exista o metodo modifica os atributos
     * o contato ja existente.
     * @param posicao - a posicao que o contato ocupara na agenda.
     * @param nome - nome do contato.
     * @param sobrenome - sobrenome do contato.
     * @param pais - codigo do pais do primeiro numero que sera cadastrado no novo contato
     * @param ddd - ddd do primeiro numero que sera cadastrado no novo contato
     * @param numero - primeiro numero que sera cadastrado no novo contato
     * @param tipo - tipo do primeiro numero que sera cadastrado no novo contato
     * @param proximidade - nivel de proximidade/amizade entre o contato e o dono da agenda.
     * @return retorna true, caso o contato tenha sido cadastrado e false caso nao
     */
    public boolean cadastrarContato(int posicao, String nome, String sobrenome, String pais, String ddd, String numero, int tipo, int proximidade){
        if(1 <= posicao || 100 >= posicao){
            this.contatos[posicao - 1] = new Contato(nome, sobrenome, pais, ddd, numero, tipo, proximidade);
            return true;
        }
        return false;
    }

    /**
     * Monta uma string que lista os contatos, no formato "*posicao* - *nome* *sobrenome*"
     * @return string que lista todos os contatos ja cadastrados
     */
    public String listarContatos(){

        String listagem = "";

        for (int i = 0; i < this.contatos.length; i++){
            if (!(this.contatos[i] == null)){
                listagem += ((i+1) + " - " + this.contatos[i].getNomeCompleto() + System.lineSeparator());
            }
        }
        return (listagem.substring(0, listagem.length() - 2));
    }

    /**
     * Monta uma string com nome e o numero do contato
     * @param posicao - posicao do contato no array
     * @return String que contem o nome completo do contato (nome e sobrenome) e todos os numeros salvos nesse contato.
     */
    public String exibirContato(int posicao){
        String buscando = "POSICAO INVALIDA!";

        if (!(this.contatos[posicao - 1] == null)){
            buscando = this.contatos[posicao-1].getNomeCompleto() + System.lineSeparator();
            buscando += this.contatos[posicao-1].getTelefones();
        }
        return buscando;
    }

    /**
     * Mostra todos os contatos que tenha o mesmo nome
     * @param nome - nome que sera usado para fazer a busca
     * @return String com o nome completo e todos os numeros de todos os contatos com o nome igual ao da busca.
     */
    public String exibirContato(String nome){
        String buscando = "";
        for(int i = 0; i < this.contatos.length; i++) {
            if (!(this.contatos[i] == null)) {
                if (this.contatos[i].getNome().equals(nome)) {
                    buscando += (this.contatos[i].getNomeCompleto() + System.lineSeparator() + this.contatos[i].getTelefones() + System.lineSeparator());
                }
            }
        }
        if (buscando.equals("")){
            return "CONTATO NAO ENCONTRADO";
        }
        return buscando.substring(0, buscando.length() - 2);
    }

    /**
     * Mostra todos os contatos que tenha o mesmo nivel de proximidade/amizade
     * @param nivelProximidade - nivel de proximidade/amizade que sera usado para fazer a busca
     * @return String com o nome completo e todos os numeros de todos os contatos com o o nivel de proximidade/amizade
     * igual ao da busca.
     */
    public String buscaPorAmizade(int nivelProximidade) {
        String buscando = "";
        for(int i = 0; i < this.contatos.length; i++){
            if (!(this.contatos[i] == null) && this.contatos[i].getProximidade() == nivelProximidade){
                buscando += (this.contatos[i].getNomeCompleto() + System.lineSeparator() + this.contatos[i].getTelefones() + System.lineSeparator());
            }
        }
        if (buscando.equals("")){
            return "CONTATO NAO ENCONTRADO";
        }
        return buscando.substring(0, buscando.length() - 2);
    }

    /**
     * Calcula a media do nivel de proximidade/amizade de todos os contatos
     * @return a media de proximidade
     */
    public String mediaProximidade(){
        int cont = 0;
        double mediaProximidade = 0;
        for (int i = 0; i < this.contatos.length; i++){
            if (!(this.contatos[i] == null)){
                mediaProximidade += this.contatos[i].getProximidade();
                cont++;
            }
        }
        mediaProximidade /= cont;

        switch (Math.round((float)mediaProximidade)){
            case 1:
                return "DISTANTE";
            case 2:
                return "COLEGA";
            case 3:
                return "AMIGO";
            case 4:
                return "AMIGAO";
            case 5:
                return "IRMAO";
        }
        return "ERRO";
    }

    /**
     * metodo que adiciona um numero de telefone a um determinado contato
     * @param posicao - a posicao que o contato ocupara na agenda.
     * @param tipo - tipo (celular/trabalho/casa) do numero que sera cadastrado no contato.
     * @param pais - codigo do pais do numero que sera adicionado.
     * @param ddd - ddd do numero que sera adicionado
     * @param numero - numero que sera adicionado
     */
    public void adicionaTelefone(int posicao, int tipo, String pais, String ddd, String numero){
        this.contatos[posicao-1].adicionaTelefone(tipo, pais, ddd, numero);
    }
}