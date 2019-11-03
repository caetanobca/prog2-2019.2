package lab3;
import java.util.Scanner;

/**
 * Representa um menu para a agenda
 *
 * @author Caetano Albuquerque
 */
public class Menu {

    /**
     * objeto do tipo agenda
     */
    private Agenda agenda1 = new Agenda();

    /**
     * Metodo que exibe o menu e recebe a operacao que o usuario deseja realizar, esse metodo fica tambem responsavel por
     * chamar outros metodos para a realizacao da atividade desejada pelo o usuario, essas atividades sao:
     * 1 - Cadastar contato
     * 2 - Listar contatos
     * 3 - Exibir contatos
     * 4 - Exibir o nivel de proximidade/amizade
     * 5 - Adicionar numero
     * 6 - Sair da aplicacao.
     */
    public void exibeMenu(){

        String opcao;

        do{
            System.out.println("(C)adastrar Contato" + System.lineSeparator() +
                               "(L)istar Contatos" + System.lineSeparator() +
                               "(E)xibir Contato" + System.lineSeparator() +
                               "(N)ivel de proximidade" + System.lineSeparator() +
                               "(A)dicionar numero" + System.lineSeparator() +
                               "(S)air" + System.lineSeparator() +
                               "Opcao> ");

            Scanner sc = new Scanner(System.in);
            opcao = sc.nextLine().toUpperCase();

            if (opcao.equals("C")){
                this.cadastraContato();

            }else if (opcao.equals("L")){
                System.out.println(agenda1.listarContatos());

            }else if(opcao.equals("E")){
                this.exibeContato();

            }else if(opcao.equals("N")) {
                this.agenda1.mediaProximidade();

            }else if(opcao.equals("A")) {
                this.adicionaNumero();

            }else if(!(opcao.equals("S"))){
                System.out.println("OPCAO INVALIDA!");
            }

        }while(!opcao.equals("S"));

        System.out.println("Progama finalizado");
    }

    /**
     * metodo que adiciona um numero a uma determinada agenda
     */
    private void adicionaNumero() {
        Scanner sc = new Scanner(System.in);

        System.out.println("ID do contato no qual voce deseja inserir um numero novo:");
        int posicao = sc.nextInt();

        System.out.println("TIPO DE TELEFONE: \nCELULAR -> 1 \nTRABALHO -> 2 \nCASA -> 3");
        int tipo = sc.nextInt();

        System.out.println("CODIGO DO PAIS: ");
        String pais = sc.nextLine();

        System.out.println("DDD: ");
        String ddd = sc.nextLine();

        System.out.println("NUMERO DE TELEFONE");
        String numero = sc.nextLine();

        this.agenda1.adicionaTelefone(posicao, tipo, pais, ddd, numero);
    }

    /**
     * metodo que cadastra contato em determinada agenda
     */
    private void cadastraContato() {
        Scanner sc = new Scanner(System.in);

        System.out.println("ID:");
        int posicao = sc.nextInt();

        System.out.println("NOME:");
        String nome = sc.nextLine();

        System.out.println("SOBRENOME");
        String sobrenome = sc.nextLine();

        System.out.println("CODIGO DO PAIS: ");
        String pais = sc.nextLine();

        System.out.println("DDD: ");
        String ddd = sc.nextLine();

        System.out.println("NUMERO DE TELEFONE");
        String numero = sc.nextLine();

        System.out.println("TIPO DE TELEFONE: \nCELULAR -> 1 \nTRABALHO -> 2 \nCASA -> 3");
        int tipo = sc.nextInt();

        System.out.println("NIVEL DE PROXIMIDADE: \nDISTANTE -> 1 \nCOLEGA -> 2 \nAMIGO -> 3 \nAMIGAO -> 4 \nIRMAO -> 5");
        int proximidade = sc.nextInt();

        if (this.agenda1.cadastrarContato(posicao, nome, sobrenome, pais, ddd, numero, tipo, proximidade)){
            System.out.println("CADASTRO REALIZADO!");
        }else {
            System.out.println("POSICAO INVALIDA!");
        }
    }

    /**
     * meto que exibe um determinado contato de uma determinada agenda
     */
    private void exibeContato() {
        Scanner sc = new Scanner(System.in);

        System.out.println("BUSCAR POR:" + System.lineSeparator() + "ID -> 1" +System.lineSeparator() + "Nome -> 2"
                            + System.lineSeparator() + "Nivel de amizade -> 3");
        int tipoBusca = sc.nextInt();

        if (tipoBusca == 3){
            System.out.println("NIVEL DE AMIZADE: ");
            int nivelAmizade = sc.nextInt();
            System.out.println(this.agenda1.buscaPorAmizade(nivelAmizade));

        }else if (tipoBusca == 1){
            System.out.println("ID: ");
            int posicao = sc.nextInt();
            System.out.println(this.agenda1.exibirContato(posicao));

        }else if (tipoBusca == 2){
            System.out.println("NOME: ");
            String nome = sc.nextLine();
            System.out.println(this.agenda1.exibirContato(nome));

        }else {
            System.out.println("OPCAO INVALIDA!");
        }

    }


}
