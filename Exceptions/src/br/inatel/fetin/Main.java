package br.inatel.fetin;

public class Main {
    static Organizacao organizacao = new Organizacao();

    public static void main(String[] args){

        //Cadastrando projetos no sistema:
        novoProjeto("Helperbot",100.0);
        novoProjeto("Inacoin",-10.0); // Nota negativa -> invalida
        novoProjeto("Helperbot",50.0); // Nome repetido de projeto -> invalido
        novoProjeto("Rankme", 80.0);

        organizacao.mostraProjetos(); // mostrando projetos válidos cadastrados no sistema
    }
    /*/Nesse metodo, ele tenta, a cada vez que a função é chamada, inserir apenas um novo projeto no HashMap
    dentro de organizações. Como a função foi chamada quatro vezes, ele vai executar quatro vezes a mesma função,
    cada vez com parâmetros diferentes.*/

    // Ele vai tentar encontrar exceções no momento de adcionar os projetos:
    public static void novoProjeto(String nome, double nota){
        try{
            organizacao.addProjeto(nome,nota);
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Erro: " + e);
        }
    }
    //O try catch possibilita a execução do código, mesmo se houver algum erro encontrado (Irá tratar a exceção se possível)
}
