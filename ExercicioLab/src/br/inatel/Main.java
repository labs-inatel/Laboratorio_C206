package br.inatel;

import br.inatel.usuarios.Aluno;
import br.inatel.usuarios.Professor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Usuario [] usuarios1 = new Usuario[2];

        Scanner sc = new Scanner(System.in);

        int entrada;

        /* while(true){
            if(condicao)
                break
        }*/
        for(int i = 0; i < usuarios1.length; i++) {

            System.out.println("Digite:");
            do {
                System.out.println("1 - Aluno\n2 - Professor\n3 - Sair");
                entrada = sc.nextInt();
                sc.nextLine();
            } while (!(entrada == 1 || entrada == 2 || entrada == 3));

            if (entrada == 1) {
                System.out.println("Insira seu nome:");
                String nome;
                nome = sc.nextLine();

                System.out.println("Insira sua matricula:");
                int mat;
                mat = sc.nextInt();
                sc.nextLine();

                System.out.println("Insira seu curso:");
                String curso;
                curso = sc.nextLine();

                System.out.println("Insira seu login:");
                String login;
                login = sc.nextLine();

                System.out.println("Insira sua senha:");
                String senha;
                senha = sc.nextLine();

                Aluno aluno = new Aluno(nome,login,senha,mat,curso);
                aluno.fazerLogin(login, senha);

                for(int j = 0; j < usuarios1.length; j++){
                    if(usuarios1[j] == null){
                        usuarios1[j] = aluno;
                        break;
                    }
                }
            }
            else if (entrada == 2) {
                System.out.println("Insira seu nome:");
                String nome;
                nome = sc.nextLine();

                System.out.println("Insira sua login:");
                String login;
                login = sc.nextLine();

                System.out.println("Insira sua senha:");
                String senha;
                senha = sc.nextLine();

                Professor professor = new Professor(nome,login,senha);
                professor.fazerLogin(login, senha);

                System.out.println("Insira sua matricula:");
                int mat;
                mat = sc.nextInt();
                sc.nextLine();

                System.out.println("Insira seu curso:");
                String curso;
                curso = sc.nextLine();

                Aluno aluno1 = buscaAluno(mat,curso,usuarios1);

                if(professor.autenticar(senha)){
                    professor.publicarNota(aluno1);
                }
            }
            else if (entrada == 3) {
                break;
            }
        }
    }
    public static Aluno buscaAluno (int matriculaOk,String cursoOk, Usuario [] usuarios){
        for(int i = 0; i < usuarios.length; i++){
            if(usuarios[i] instanceof Aluno){
                Aluno al1 = (Aluno) usuarios[i];
                if(al1.getMatricula()==matriculaOk && cursoOk.equals(al1.getCurso())){
                    return al1;
                }
            }
        }
       return null;
    }
}
