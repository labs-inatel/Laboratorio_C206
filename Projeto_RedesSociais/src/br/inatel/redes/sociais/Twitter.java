package br.inatel.redes.sociais;

import br.inatel.redes.interfaces.Compartilhamento;
import br.inatel.redes.RedeSocial;

/*/A Subclasse "Twitter" herda (extends) dos atributos e métodos da Superclasse Abstrata "RedeSocial"
Esta Subclasse também está implementando (implements) a Interface "Compartilhamento"
Foi utilizado o @Override para especificar o comportamento/método na Subclasse /*/
public class Twitter extends RedeSocial implements Compartilhamento {

    public Twitter (String senha, int numAmigos){
        super(senha,numAmigos);
    }

//Os métodos "postarFoto", "postarVideo", "postarComentario" são abstratos herdadados da Superclasse Abstrata "RedeSocial":
    @Override
    public void postarFoto() {
        System.out.println("Postou uma nova foto no Twitter!");
    }

    @Override
    public void postarVideo() {
        System.out.println("Postou um novo video no Twitter!");
    }

    @Override
    public void postarComentario() {
        System.out.println("Postou um novo comentario no Twitter!");
    }

//O método "compartilhar" é um método da Interface "Compartilhamento"
    @Override
    public void compartilhar() {
        System.out.println("Compartilhou um post no Twitter!");
    }
}
