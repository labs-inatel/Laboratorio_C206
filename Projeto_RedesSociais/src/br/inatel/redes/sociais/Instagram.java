package br.inatel.redes.sociais;

import br.inatel.redes.RedeSocial;

/*/ A Subclasse "Instagram" herda (extends) dos atributos e métodos da Superclasse Abstrata "RedeSocial"
Os métodos "postarFoto", "postarVideo", "postarComentario" são abstratos herdadados da Superclasse Abstrata "RedeSocial"
Foi utilizado o @Override para especificar o comportamento/método na Subclasse /*/
public class Instagram extends RedeSocial {

    public Instagram (String senha, int numAmigos){
        super(senha,numAmigos);
    }

    @Override
    public void postarFoto() {
        System.out.println("Postou uma nova foto no Instagram!");
    }

    @Override
    public void postarVideo() {
        System.out.println("Postou um novo video no Instagram!");
    }

    @Override
    public void postarComentario() {
        System.out.println("Postou um novo comentario no Instagram!");
    }
}
