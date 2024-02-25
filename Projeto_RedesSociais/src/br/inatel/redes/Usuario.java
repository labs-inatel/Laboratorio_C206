package br.inatel.redes;

public class Usuario{

/*/A Classe "Usuario" está associada/agregada a Superclasse "RedeSocial, ou seja o usuario pode ter nenhuma ou mais de uma rede social
e ainda existir mesmo se a SuperClasse "RedeSocial" não existir /*/

//O modificador (private) permite apenas que os métodos da Classe Usuario os modifique
    private String nome;
    private String email;

//Array para receber/armazenar as redes sociais que o usuario possui
    RedeSocial [] redes = new RedeSocial[4];

//O método abaixo está recebendo as redes sociais de acordo com a entrada (input) do usuario no menu:
    public Usuario(RedeSocial [] redeSociais) {
        for(int i = 0;  i < redeSociais.length; i++ ){ //Varrendo array de redes sociais
            if(redeSociais[i] == null){ //Verifica se não existe rede social
                redes[i] = redeSociais[i];
                break; //Adiciona e sai do metodo
            }
            else{
                System.out.println("Não é possível adcionar mais Redes Sociais!");
            }
        }
    }

//Para setar/definir os atributos "nome" e "email" de forma segura, utiliza-se o set:
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//Para buscar/pegar os atributos "nome" e "email" de forma segura, utiliza-se o get:
    public String getNome(){
        return this.nome;
    }

    public String getEmail(){
        return this.email;
    }
}
