package br.inatel.redes.sociais;

import br.inatel.redes.RedeSocial;
import br.inatel.redes.interfaces.Compartilhamento;
import br.inatel.redes.interfaces.VideoConferencia;

/*/ A Subclasse "GooglePlus" herda (extends) dos atributos e métodos da Superclasse Abstrata "RedeSocial"
Esta Subclasse também está implementando (implements) as Interfaces "VideoConferencia" e "Compartilhamento"
Foi utilizado o @Override para especificar o comportamento/método na Subclasse /*/
public class GooglePlus extends RedeSocial implements VideoConferencia, Compartilhamento {

    public GooglePlus (String senha, int numAmigos){
        super(senha,numAmigos);
    }

//Os métodos "postarFoto", "postarVideo", "postarComentario" são abstratos herdadados da Superclasse Abstrata "RedeSocial":
    @Override
    public void postarFoto() {
        System.out.println("Postou uma nova foto no GooglePlus!");
    }

    @Override
    public void postarVideo() {
        System.out.println("Postou um novo video no GooglePlus!");
    }

    @Override
    public void postarComentario() {
        System.out.println("Postou um novo comentario no GooglePlus!");
    }

//Os métodos "compartilhar" e "fazStreaming" são métodos das Interfaces:
    @Override
    public void fazStreaming() {
        System.out.println("Realizou uma video conferencia no GooglePlus!");
    }

    @Override
    public void compartilhar() {
        System.out.println("Compartilhou um post no GooglePlus!");
    }
}
