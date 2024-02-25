package br.inatel.redes;

import br.inatel.redes.sociais.Facebook;
import br.inatel.redes.sociais.GooglePlus;
import br.inatel.redes.sociais.Instagram;
import br.inatel.redes.sociais.Twitter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        RedeSocial [] novaRede = new RedeSocial[4]; // Array para receber input de redes sociais do usuario

        Usuario us1 = new Usuario(novaRede); // Inserindo o nome do usuario e seu email
        us1.setNome("Iza Lopes");
        us1.setEmail("izalopes123@gmail.com");

        Scanner sc = new Scanner(System.in); // Scanner para input da senha e numAmigos do usuario

        int entrada; // aux para receber input

        // Inserindo as respectivas redes sociais no array:
        for(int i = 0; i < novaRede.length; i++){

            //Apresentando um menu com opções de redes sociais para o usuario:
            System.out.println("Rede Social a ser criada:");
            do{
                System.out.println("1 - Facebook\n2 - GooglePlus\n3 - Twitter\n4 - Instagram\n5 - Sair");
                entrada = sc.nextInt();
                sc.nextLine();
            }while(!(entrada == 1 || entrada == 2 || entrada == 3 || entrada == 4 || entrada == 5));

            // se a escolha for 1 (Facebook), o usuario insere senha e numAmigos:
            if(entrada == 1){
                System.out.println("Insira sua senha:");
                String senha;
                senha = sc.nextLine();

                System.out.println("Insira número de seguidores:");
                int numAmigos;
                numAmigos = sc.nextInt();

                Facebook facebook = new Facebook(senha,numAmigos);
                us1.redes[i] = facebook; // array de redes na Classe Usuario recebe a rede social Facebook
            }
            // se a escolha for 2 (GooglePlus), o usuario insere senha e numAmigos:
            else if(entrada == 2){
                System.out.println("Insira sua senha:");
                String senha;
                senha = sc.nextLine();

                System.out.println("Insira número de seguidores:");
                int numAmigos;
                numAmigos = sc.nextInt();

                GooglePlus googlePlus = new GooglePlus (senha,numAmigos);
                us1.redes[i] = googlePlus; // array de redes na Classe Usuario recebe a rede social GooglePlus
            }
            // se a escolha for 3 (Twitter), o usuario insere senha e numAmigos:
            else if(entrada == 3){
                System.out.println("Insira sua senha:");
                String senha;
                senha = sc.nextLine();

                System.out.println("Insira número de seguidores:");
                int numAmigos;
                numAmigos = sc.nextInt();

                Twitter twitter = new Twitter (senha,numAmigos);
                us1.redes[i] = twitter; // array de redes na Classe Usuario recebe a rede social Twitter
            }
            // se a escolha for 1 (Instagram), o usuario insere senha e numAmigos:
            else if(entrada == 4){
                System.out.println("Insira sua senha:");
                String senha;
                senha = sc.nextLine();

                System.out.println("Insira número de seguidores:");
                int numAmigos;
                numAmigos = sc.nextInt();

                Instagram instagram = new Instagram (senha,numAmigos);
                us1.redes[i] = instagram; // array de redes na Classe Usuario recebe a rede social Instagram
            }
            // se a escolha for 5 (Sair), sai do loop:
            else if (entrada == 5){
                break;
            }
        }

        //Apresentacao do nome do usuario e seu email:
        System.out.println("Usuário:" + us1.getNome() + "\nEmail do Usuário:" + us1.getEmail());

        //Apresentacao das ações do usuario em suas redes sociais:
        System.out.println("Ações do Usuario nas Redes Sociais:\n");
        for(int i = 0; i < us1.redes.length; i++){ //percorrendo array de redes
            if(us1.redes[i] != null){
                if(us1.redes[i] instanceof Facebook) // Verificação se a instancia é do tipo Facebook
                {
                    //Apresentação as ações na Rede Social Facebook:
                    System.out.println("Facebook:\n");
                    us1.redes[i].postarFoto();
                    us1.redes[i].postarVideo();
                    us1.redes[i].postarComentario();
                }
                else if(us1.redes[i] instanceof GooglePlus) // Verificação se a instancia é do tipo GooglePlus
                {
                    //Apresentação as ações na Rede Social GooglePlus:
                    System.out.println("\nGooglePlus:\n");
                    ((GooglePlus) us1.redes[i]).fazStreaming();
                    ((GooglePlus) us1.redes[i]).compartilhar();
                    us1.redes[i].curtirPublicacao();
                }
                else if(us1.redes[i] instanceof Twitter) // Verificação se a instancia é do tipo Twitter
                {
                    //Apresentação as ações na Rede Social Twitter:
                    System.out.println("\nTwitter:\n");
                    us1.redes[i].curtirPublicacao();
                    us1.redes[i].postarFoto();
                    ((Twitter) us1.redes[i]).compartilhar();
                }
                else if(us1.redes[i] instanceof Instagram) // Verificação se a instancia é do tipo Instagram
                {
                    //Apresentação as ações na Rede Social Instagram:
                    System.out.println("\nInstagram:\n");
                    us1.redes[i].postarVideo();
                    us1.redes[i].postarComentario();
                    us1.redes[i].curtirPublicacao();
                }
            }
        }
    }
}
