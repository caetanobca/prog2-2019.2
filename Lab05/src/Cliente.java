public class Cliente {

    private String cpf;
    private String nome;
    private String email;
    private String localizacao;

    private Validacao validadorString;

    public Cliente (String cpf, String nome, String email, String localizacao){
        this.validadorString.validaString(cpf);
        this.validadorString.validaString(nome);
        this.validadorString.validaString(email);
        this.validadorString.validaString(localizacao);

        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.localizacao = localizacao;

    }

    @Override
    public String toString() {
        return  nome + " - " + localizacao + " - " + email;
    }

    public void setNome(String nome) {
        this.validadorString.validaString(nome);
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.validadorString.validaString(email);
        this.email = email;
    }

    public void setLocalizacao(String localizacao) {
        this.validadorString.validaString(localizacao);
        this.localizacao = localizacao;
    }
}
