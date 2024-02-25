package br.inatel.redes;

public abstract class RedeSocial {

/*/A Superclasse "RedeSocial" é abstrata, ou seja, ela é uma referência para as subclasses "Facebook", "GooglePlus", "Twitter" e "Instagram"
As Subclasses herdam os atributos e métodos desta Superclasse /*/

//O modificador (protected) permite apenas que a Superclasse "RedeSocial" e suas Subclasses tenham acesso:
    protected String senha;
    protected int numAmigos;

//Construtor para receber parâmetros "senha" e "numAmigos" (números de amigos nas Redes Sociais):
    public RedeSocial(String senha, int numAmigos){
        this.senha = senha;
        this.numAmigos = numAmigos;
    }

//Os métodos "postarFoto", "postarVideo" e "postarComentario" são abstratos:
    public abstract void postarFoto ();

    public abstract void postarVideo ();

    public abstract void postarComentario ();

//O método "curtir publicação não é abstrato:
    public void curtirPublicacao(){
        System.out.println("Curtiu uma publicacao!");
    }
}
