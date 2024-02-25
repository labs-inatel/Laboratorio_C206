package br.inatel.teste;

import br.inatel.teste.exceptions001.Exceptions;

import java.io.*;
import java.util.*;

public class Fabrica {
    private final ArrayList<Crianca> criancas = new ArrayList<>();
    private final ArrayList<Elfo> elfos = new ArrayList<>();
    private final ArrayList<Crianca> listaBonzinhos = new ArrayList<>();

    public void novaElfo(Elfo elfo){ //-----------------------ADCIONANDO ELFO---------------------------
        elfos.add(elfo);
    }
    public void mostraElfo(){
        for (Elfo elfinho : elfos){
            System.out.println("\nNome do elfo: " + elfinho.getNome() + "\nFunção do elfo: " + elfinho.getFuncao() + "\n");
        }
    }
    public void novaCrianca(Crianca crianca){ //-----------------------ADCIONANDO CRIANÇA---------------------------
        criancas.add(crianca);
    }

    public void mostraCrianca(){
        for (Crianca crianca1 : criancas){
            System.out.println("\nNome: " + crianca1.getNome() + "\nIdade: " + crianca1.getIdade() +
                    "\nNacionalidade: " + crianca1.getNacionalidade() + "\nPresente desejado: " + crianca1.getPresenteDesejado() + "\n");
        }
    }
    // Escrita de arquivo
    // Caso não seja encontarada nenhuma criança boazinha, lançar exception customizada dizendo que nao achou
    // Tratar a exception para o código continuar rodando no terminal
    public void addBonzinho(Crianca crianca1) throws Exceptions{
        //-----------------------ESCREVENDO A LISTA NO ARQUIVO---------------------------
        // Instanciando os objetos que permitirão a escrita de dados
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;

        try{
            // Abrindo a saída de dados
            os = new FileOutputStream("bonzinhos.txt",true); // Nome do arquivo onde será salvo
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);

            // Flag que indica onde começa as informações
            bw.write("Criança:\n");
            bw.write(crianca1.getNome()+"\n");
            bw.write(crianca1.getIdade()+"\n");
            bw.write(crianca1.getNacionalidade()+"\n");
            bw.write(crianca1.getPresenteDesejado()+"\n");
        }catch(Exception e){
            System.out.println("ERRO: " + e);
        }finally{
            // Fechando a entrada de dados
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //-----------------------FAZENDO LEITURA DO ARQUIVO---------------------------
    public void listarBonzinhos(){
        // Classes que permitem leitura de dados do arquivo
        InputStream is=null;
        InputStreamReader isr=null;
        BufferedReader br=null;

        // Variável auxiliar que servirá de flag para o while
        String linhaLer;

        try{
            // Instanciando os objetos
            is=new FileInputStream("bonzinhos.txt");
            isr=new InputStreamReader(is);
            br=new BufferedReader(isr);

            // Colocando o cursor no inicio do arquivo
            linhaLer=br.readLine();

            while(linhaLer!=null){
                // Comparando se o que está em linhaLer é igual a minha flag
                if(linhaLer.contains("Criança:")){
                    String nome, nacionalidade, presenteDesejado;
                    int idade;

                    nome = br.readLine();
                    idade = Integer.parseInt(br.readLine());
                    nacionalidade = br.readLine();
                    presenteDesejado = br.readLine();

                    Crianca crianca1 = new Crianca(nome,idade,nacionalidade,presenteDesejado);

                    // Adicionando o funcionario no array
                    listaBonzinhos.add(crianca1);
                }else{
                    throw new Exceptions("Não foi encontrada nenhuma criança boazinha!");
                }
                linhaLer=br.readLine();
            }
        }catch(Exception e){
            System.out.println("ERRO: "+e);
        }finally{
            try{
                br.close();
            }catch(Exception e){
                System.out.println("ERRO: "+e);
            }
        }
        for (int i=0; i<listaBonzinhos.size();i++){
            System.out.println("Nome: " + listaBonzinhos.get(i).getNome());
            System.out.println("Idade: " + listaBonzinhos.get(i).getIdade());
            System.out.println("Nacionalidade: " + listaBonzinhos.get(i).getNacionalidade());
            System.out.println("Presente desejado: " + listaBonzinhos.get(i).getPresenteDesejado() + "\n");
        }
    }
}
