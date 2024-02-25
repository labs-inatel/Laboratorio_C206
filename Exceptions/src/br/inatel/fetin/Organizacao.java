package br.inatel.fetin;

import br.inatel.exceptions.NomeRepetidoException;
import br.inatel.exceptions.NotaInvalidaException;

import java.util.HashMap;
import java.util.Map;

public class Organizacao {

    //HashMap para guardar informações dos projetos, como nome e nota:
    private Map<String, Double> projetos = new HashMap<String, Double>();

    //Quem invocar o metodo "addProjeto" será obrigado a tratar as exceções Nota Inválida e Nome Repetido:
    public void addProjeto(String nome, double nota) throws NotaInvalidaException, NomeRepetidoException {
        // Verificando se há nota inválida:
        if(nota < 0 || nota > 100){
            throw new NotaInvalidaException("Nota precisa ser positiva e menor que 100!\n"); // erro customizado
        }

        // Verificando se há nome repetido:
        if(projetos.get(nome) != null){
            throw new NomeRepetidoException("Nome repetido cadastrado!\n"); // erro customizado
        }

        //inserindo os projetos no HashMap:
        projetos.put(nome,nota);
        System.out.println("Projeto cadastrado com sucesso!\n");

    }

    //Mostrando informações dos projetos cadastrados:
    public void mostraProjetos(){
        System.out.println("PROJETOS CADASTRADOS NO SISTEMA:\n");
        for (String nome: projetos.keySet()) {
            System.out.println("Nome do Projeto: " + nome );
            System.out.println("Nota do Projeto: " + projetos.get(nome) + " pontos");
            System.out.println("\n");
        }
    }

}
