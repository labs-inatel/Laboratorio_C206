package br.inatel.teste;

import br.inatel.teste.exceptions001.Exceptions;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exceptions {
        Fabrica fabrica = new Fabrica();

        //Input para crianças:
        Crianca crianca1 = new Crianca("Aninha",7,"brasileira","bicicleta");
        Crianca crianca2 = new Crianca("Jonas",5,"brasileiro","carrinho");
        Crianca crianca3 = new Crianca("Caio",10,"brasileiro","pc gamer");
        Crianca crianca4 = new Crianca("Kelly",1,"brasileira","chupeta");

        //Input para elfos:
        Elfo elfo1 = new Elfo("Ehon","Empacotador");
        Elfo elfo2 = new Elfo("Prismo","lider de Produção");
        Elfo elfo3 = new Elfo("Tingle","Apoio emocional da galera");

        //Adcionando nova criança no ArrayList:
        System.out.println("\nCRIANÇAS:");
        fabrica.novaCrianca(crianca1);
        fabrica.novaCrianca(crianca2);
        fabrica.novaCrianca(crianca3);
        fabrica.novaCrianca(crianca4);

        fabrica.mostraCrianca();

        //Adcionando novo elfo no ArrayList:
        System.out.println("\nELFOS:");
        fabrica.novaElfo(elfo1);
        fabrica.novaElfo(elfo2);
        fabrica.novaElfo(elfo3);

        fabrica.mostraElfo();

        //Adcionando as crianças na lista dos bonzinhos:
        System.out.println("\nCRIANÇAS ADCIONADAS NA LISTA DE BONZINHOS:\n");
        fabrica.addBonzinho(crianca1);
        fabrica.addBonzinho(crianca2);
        fabrica.addBonzinho(crianca4);

        //Apresentando a lista de bonzinhos:
        System.out.println("\nA SUPREMA LISTA DE BONZINHOS:\n");
        fabrica.listarBonzinhos();
    }
}
