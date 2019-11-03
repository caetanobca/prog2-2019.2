package Scr;

import java.util.Scanner;

/**
 * Classe criada para exibir um menu ao usuario e coletar suas entradas
 *
 * @author Caetano Bezerra Cavalcanti Albuquerque
 */
public class Menu {

    Controlador controlador = new Controlador();

    public void exibeMenu(){

        Scanner sc = new Scanner(System.in);
        String opcao;

        String menu = "(C)adastrar Scr.Aluno" + System.lineSeparator() +
                "(E)xibir Scr.Aluno" + System.lineSeparator() +
                "(N)ovo Scr.Grupo" + System.lineSeparator() +
                "(A)locar Scr.Aluno no Scr.Grupo e Imprimir Grupos" + System.lineSeparator() +
                "(R)egistrar Scr.Aluno que Respondeu" + System.lineSeparator() +
                "(I)mprimir Alunos que Responderam" + System.lineSeparator() +
                "(O)ra, vamos fechar o programa!" + System.lineSeparator() +
                System.lineSeparator() +
                "Opção>";

        do{
            System.out.println(menu);
            opcao = sc.nextLine().toUpperCase();

            if (opcao.equals("C")){
                this.cadastraAluno();

            }else if (opcao.equals("E")){
                this.exibirAluno();

            }else if (opcao.equals("N")){
                this.cadastraGrupo();

            }else if (opcao.equals("A")){
                this.alocarOuImprimir();

            }else if (opcao.equals("R")){
                this.registrarResposta();

            }else if (opcao.equals("I")){
                this.exibirAlunosResponderam();

            }else if (opcao.equals("O")){

            }else {

            }

        }while (!(opcao.equals("O")));

    }

    private void cadastraAluno() {

        Scanner sc = new Scanner(System.in);

        String matricula;
        String nome;
        String curso;

        System.out.print("Matrícula: ");
        matricula = sc.nextLine();
        System.out.print("Nome: ");
        nome = sc.nextLine();
        System.out.print("Curso: ");
        curso = sc.nextLine();

       if(this.controlador.cadastraAluno(matricula, nome, curso)){
           System.out.println("CADASTRO REALIZADO!");
       }else {
           System.out.println("MATRICULA JA CADASTRADA!");
       }

    }

    private void exibirAluno() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Matrícula: ");
        String matricula = sc.nextLine();

        System.out.println(this.controlador.exibirAluno(matricula));

    }

    private void cadastraGrupo() {

        Scanner sc = new Scanner(System.in);

        String grupo;
        System.out.println("Scr.Grupo: ");
        grupo = sc.nextLine();

        if(this.controlador.cadastraGrupo(grupo)){
            System.out.println("CADASTRO REALIZADO!");
        }else {
            System.out.println("GRUPO JA CADASTRADO!");
        }
    }

    private void alocarOuImprimir() {

        Scanner sc = new Scanner(System.in);


        String grupo;

        System.out.println("(A)locar Scr.Aluno ou (I)mprimir Scr.Grupo?");
        String opcao = sc.nextLine().toUpperCase();

        if (opcao.equals("A")){
            String matricula;

            System.out.println("Matrícula: ");
            matricula = sc.nextLine();
            System.out.println("Scr.Grupo: ");
            grupo = sc.nextLine().toUpperCase();

            System.out.println(this.controlador.alocaAlunoEmGrupo(matricula, grupo));
        }else if (opcao.equals("I")){
            System.out.println("Scr.Grupo: ");
            grupo = sc.nextLine();

            System.out.println(this.controlador.imprimeGrupo(grupo));
        }
    }

    private void registrarResposta() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Matrícula: ");
        String matricula = sc.nextLine();
        System.out.println(this.controlador.registraResposta(matricula));
    }

    private void exibirAlunosResponderam() {
        System.out.println(this.controlador.exibirAlunosRespoderam());
    }
}
