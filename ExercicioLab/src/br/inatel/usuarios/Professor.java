package br.inatel.usuarios;

import br.inatel.Usuario;
import br.inatel.interfaces.Funcionario;

public class Professor extends Usuario implements Funcionario {

    public Professor (String nome, String login, String senha){
        super(nome,login,senha);
    }

    public void publicarNota (Aluno aluno){
        System.out.println("Aluno: " + aluno.getNome() + "\nMatricula: " + aluno.getMatricula() + "\nCurso: " + aluno.getCurso());
        System.out.println("NP1: " + 60 + "\nNP2: " + 60 + "\nNPT: " + 60 + "\nNPL1: " + 60 + "\nNPL2: " + 60 + "\nNPL: " + 60);
    }

    // Interface para autenticar senha:
    @Override
    public boolean autenticar(String senha) {
        if(senha.equals("senhaook")){
            System.out.println("Senha autenticada!");
        }
        return true;
    }
}
