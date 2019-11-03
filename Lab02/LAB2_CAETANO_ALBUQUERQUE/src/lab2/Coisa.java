package lab2;

public class Coisa {

    public static void main(String[] args) {



            ContaLaboratorio contaLCC2 = new ContaLaboratorio("LCC2");

            contaLCC2.consomeEspaco(1999);

            System.out.println(contaLCC2.atingiuCota());

            contaLCC2.consomeEspaco(2);

            System.out.println(contaLCC2.atingiuCota());

            contaLCC2.liberaEspaco(1);

            System.out.println(contaLCC2.atingiuCota());

            contaLCC2.liberaEspaco(1);

            System.out.println(contaLCC2.atingiuCota());

            System.out.println(contaLCC2.toString());




            Disciplina prog2 = new Disciplina("PROGRAMACAO 2");

            prog2.cadastraHoras(4);

            prog2.cadastraNota(1, 5.0);

            prog2.cadastraNota(2, 6.0);

            prog2.cadastraNota(3, 7.0);

            System.out.println(prog2.aprovado());

            prog2.cadastraNota(4, 10.0);

            System.out.println(prog2.aprovado());

            System.out.println(prog2.toString());

            //Teste do construtor que recebe os pesos da notas.
            int[] pesosDasNotas = {4, 4, 12, 5, 5};

            Disciplina lp2 = new Disciplina("LP2", 5, pesosDasNotas);

            lp2.cadastraHoras(12);

            lp2.cadastraHoras(6);

            lp2.cadastraNota(1, 7.0);

            lp2.cadastraNota(2, 9.0);

            lp2.cadastraNota(3, 8.0);

            lp2.cadastraNota(4, 9.0);

            lp2.cadastraNota(5, 4.0);

            System.out.println(lp2.aprovado());

            System.out.println(lp2.toString());




            ContaCantina cantinaSeuMatias = new ContaCantina("Seu Matias");

            cantinaSeuMatias.cadastraLanche(2, 500);

            cantinaSeuMatias.cadastraLanche(1, 500);

            cantinaSeuMatias.pagaConta(200);

            System.out.println(cantinaSeuMatias.getFaltaPagar());

            System.out.println(cantinaSeuMatias.toString());

            // Teste do metodo cadastraLanche, com a entrade de um detalhe.
            cantinaSeuMatias.cadastraLanche(1, 500, "Cafe pequeno");

            cantinaSeuMatias.cadastraLanche(5, 500, "balas");

            cantinaSeuMatias.cadastraLanche(1, 1000, "agua");

            cantinaSeuMatias.cadastraLanche(2, 1000, "Cafe grande");

            // Teste do metodo listarDetalhes
            System.out.println(cantinaSeuMatias.listarDetalhes());






            Saude saude = new Saude();

            System.out.println(saude.getStatusGeral());

            saude.defineSaudeMental("boa");

            saude.defineSaudeFisica("boa");

            System.out.println(saude.getStatusGeral());

            saude.defineSaudeMental("fraca");

            saude.defineSaudeFisica("fraca");

            //teste do metodo definirEmoji.
            saude.definirEmoji(";-;");

            System.out.println(saude.getStatusGeral());

            saude.defineSaudeMental("boa");

            saude.defineSaudeFisica("fraca");

            System.out.println(saude.getStatusGeral());



            //Teste de alguns metodos da clase Aluno
            Aluno a1 = new Aluno(11911599);

            a1.cadastraLaboratorio("LCC_2");
            a1.consomeEspaco("LCC_2", 500);
            System.out.println(a1.atingiuCota("LCC_2"));
            System.out.println(a1.laboratorioToString("LCC_2"));

            a1.cadastraDisciplina("P2");
            a1.cadastraDisciplina("FMCC2");
            a1.cadastraHoras("P2", 30);
            a1.cadastraNota("P2", 1, 10);
            a1.cadastraNota("P2", 2, 0);
            a1.cadastraNota("P2", 3, 9.7);
            a1.cadastraNota("P2", 4, 8.5);
            a1.cadastraNota("FMCC2", 1, 3);
            a1.cadastraNota("FMCC2", 2, 5);
            a1.cadastraNota("FMCC2", 3, 10);
            a1.cadastraNota("FMCC2", 4, 8.2);
            System.out.println(a1.disciplinaToString("P2"));
            System.out.println(a1.disciplinaToString("FMCC2"));

            a1.defineSaudeFisica("fraca");
            System.out.println(a1.getStatusGeral());



    }

}