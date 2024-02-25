package br.inatel;

import br.inatel.usuarios.Aluno;
import br.inatel.usuarios.Professor;

public abstract class Usuario {

    protected String nome;
    protected String login;
    protected String senha;

    //Construtor:
    public Usuario(String nome,String login,String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    //Método para fazerLogin:
    public void fazerLogin(String login, String senha){
        this.login = login;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }
}
