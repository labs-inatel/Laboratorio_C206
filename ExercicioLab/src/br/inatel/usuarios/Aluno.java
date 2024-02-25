package br.inatel.usuarios;

import br.inatel.Usuario;

public class Aluno extends Usuario {

    //Herdando de Usuario:
    public Aluno (String nome, String login, String senha,int matricula,String curso){
        super(nome,login,senha);
        this.matricula = matricula;
        this.curso = curso;
    }

    private int matricula;
    private String curso;

    public int getMatricula() {
        return matricula;
    }
    public String getCurso() {
        return curso;
    }
}
