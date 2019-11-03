package lab3;
import java.util.Objects;

/**
 * Representacao de um contato que existe dentro de uma agenda, que tem um nome, um sobrenome, ate 3 numeros de telefone
 * e um nivel de proximidade com o dono da agenda.
 *
 * @author Caetano Albuquerque
 */
public class Contato {

    /**
     * String que guarda o primeiro nome do contato.
     */
    private String nome;

    /**
     * String que guarda o sobrenome do contato.
     */
    private String sobrenome;

    /**
     * Array do tipo Telefone, que guarda 3 numeros diferentes, um do tipo Celular, outro do tipo Trabalho e outro do
     * tipo Casa.
     */
    private Telefone[] telefone = new Telefone[3];

    /**
     * inteiro que varia de 1 a 5, que determina o nivel de amizade entre o contato e o dono da agenda.
     */
    private int proximidade;

    /**
     * Construtor de contato que alem de atribuir valores para nome, sobrenome, proximidade e um numero, ele tambem testa
     * se as entradas sao validas.
     * @param nome - Primeiro nome do contato
     * @param sobrenome - Sobrenome do contato
     * @param pais - codigo do pais do numero que sera armazenado
     * @param ddd - ddd do numero que sera armazenado
     * @param numero - numero que sera armazenado
     * @param tipo - tipo do numero que sera armazenado (Celular/trabalho/Casa)
     * @param proximidade - nivel de proximidade/amizade entre o contato e o dono da agenda
     */
    public Contato(String nome, String sobrenome, String pais, String ddd, String numero, int tipo, int proximidade) {

        if (nome.equals(null) || nome.trim().equals("")) {
            throw new IllegalArgumentException("NOME INVALIDO");
        }else if (sobrenome.equals(null) || sobrenome.trim().equals("")){
            throw new IllegalArgumentException("SOBRENOME INVALIDO");
        }else if (numero.equals(null) || numero.trim().equals("")){
            throw new IllegalArgumentException("NUMERO DE TELEFONE INVALIDO");
        }else if (pais.equals(null) || pais.trim().equals("")){
            throw new IllegalArgumentException("CODIGO DO PAIS INVALIDO");
        }else if (ddd.equals(null) || ddd.trim().equals("")){
            throw new IllegalArgumentException("DDD INVALIDO");
        }else if (tipo < 1 || tipo > 3){
            throw new IllegalArgumentException("TIPO DE CONTATO INVALIDO");
        }else if (proximidade < 1 || proximidade > 5){
            throw new IllegalArgumentException("VALOR DE PROXIMIDADE INVALIDO");
        }

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.proximidade = proximidade;
        this.telefone[tipo-1] = new Telefone(pais, ddd, numero, tipo);
    }

    /**
     * Metodo que caso nao exista nenhum telefone do tipo (Celular/trabalho/Casa) que o usuario selecionou, adiciona um
     * novo objeto do tipo telefone e caso ja exista ele cria um objeto telefone e substitui o antigo.
     * @param tipo - Tipo do numero que sera armazenado (Celular/trabalho/Casa)
     * @param pais - Codigo do pais do numero que sera armazenado
     * @param ddd - ddd do numero que sera armazenado
     * @param numero - numero que sera armazenado
     */
    public void adicionaTelefone(int tipo, String pais, String ddd, String numero){
        this.telefone[tipo-1] = new Telefone(pais, ddd, numero, tipo);
    }

    /**
     * metodo que pega o nome completo do contato
     * @return nome completo, no formato "*nome* *sobrenome*"
     */
    public String getNomeCompleto() {
        return this.nome + " " + this.sobrenome;
    }

    /**
     * metodo que pega todos os telefones cadastrados em determinado contato.
     * @return uma string que contem todos os telefones armazenados em determinado contato
     */
    public String getTelefones(){
        String numeros = "";
        for (int i = 0; i < 3; i++){
            if (!(this.telefone[i] == null)) {
                numeros += (this.telefone[i].telefoneToString() + System.lineSeparator());
            }
        }
        return (numeros.substring(0, numeros.length() - 2));
    }

    /**
     * Metodo que pega o nivel de proximidade/amizade entre o contato e o dono da agenda
     * @return nivel de proximidade/amizade entre o contato e o dono da agenda.
     */
    public int getProximidade() {
        return proximidade;
    }

    /**
     * pega o primeiro nome do contato
     * @return uma string contendo o primeiro nome do contato
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo que gera um numero de identificacao por meio dos atributos -nomes e sobrenome-.
     * @return Um inteiro que representa um id gerado a partir dos atributos -nomes e sobrenome-.
     */
    @Override
	public int hashCode() {
		return Objects.hash(nome, sobrenome);
	}

    /**
     * Metodo que verifica se dois objetos sao iguais a partir dos atributos nome e sobrenome.
     * @param obj um objeto do tipo objeto.
     * @return Um booleano que retorna true se o conjunto -nome e sobrenome-  forem iguais.
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Contato other = (Contato) obj;
		return Objects.equals(nome, other.nome) &&
                Objects.equals(sobrenome, other.sobrenome);
	}
    
    
    
}



