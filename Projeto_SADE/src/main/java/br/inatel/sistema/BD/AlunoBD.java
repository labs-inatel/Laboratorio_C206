package br.inatel.sistema.BD;

import br.inatel.sistema.Database;
import br.inatel.sistema.usuarios.Aluno;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlunoBD extends Database {
    //------------------------------------INSERINDO NOVO REGISTRO---------------------------------------------//
    public void insertAluno(Aluno aluno) {
        connect();
        String sql = "INSERT INTO aluno (matriculaAluno,escolaOrigem,nomeAluno,cpfAluno,rgAluno,dataNasc, " +
                "naturalidadeAluno,sexoAluno,nomeFiliacao1,nomeFiliacao2,enderecoAluno,contatoAluno," +
                "Turma_idTurma, Escola_idEscola) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, aluno.getMatricula());             //concatena nome na 1 ? do comando
            pst.setString(2, aluno.getEscolaOrigem());       //concatena nome na 2 ? do comando
            pst.setString(3, aluno.getNome());               //concatena nome na 3 ? do comando
            pst.setString(4, aluno.getCpf());                //concatena nome na 4 ? do comando
            pst.setString(5, aluno.getRg());                 //concatena nome na 5 ? do comando
            pst.setString(6, aluno.getDataNasc());           //concatena nome na 6 ? do comando
            pst.setString(7, aluno.getNaturalidade());       //concatena nome na 7 ? do comando
            pst.setString(8, aluno.getSexo());               //concatena nome na 8 ? do comando
            pst.setString(9, aluno.getNomeFiliacao1());      //concatena nome na 9 ? do comando
            pst.setString(10, aluno.getNomeFiliacao2());     //concatena nome na 10 ? do comando
            pst.setString(11, aluno.getEndereco());          //concatena nome na 11 ? do comando
            pst.setString(12, aluno.getContato());           //concatena nome na 12 ? do comando
            pst.setInt(13, aluno.getIdTurma());              //concatena nome na 13 ? do comando
            pst.setInt(14, aluno.getIdEscola());             //concatena nome na 14 ? do comando
            pst.execute();                                                //executa o comando
            System.out.println("Aluno cadastrado com sucesso!\n");
        } catch (SQLException e) {
            System.out.println("Erro na operação: " + e.getMessage() + "\n");
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage() + "\n");
            }
        }
    }
    //-----------------------------------BUSCANDO TODOS OS REGISTROS-------------------------------------------//
    public void researchAluno(){
        connect();
        ArrayList<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM aluno";

        try{
            statement =connection.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()){
                Aluno alunoTemp = new Aluno(result.getString("escolaOrigem"),
                        result.getString("nomeAluno"), result.getString("cpfAluno"),
                        result.getString("rgAluno"), result.getString("dataNasc"),
                        result.getString("naturalidadeAluno"), result.getString("sexoAluno"),
                        result.getString("nomeFiliacao1"), result.getString("nomeFiliacao2"),
                        result.getString("enderecoAluno"), result.getString("contatoAluno"),
                        result.getInt("Turma_idTurma"), result.getInt("Escola_idEscola"));

                alunoTemp.setMatricula(result.getInt("matriculaAluno"));

                System.out.println("Número de matrícula: " + alunoTemp.getMatricula());
                System.out.println("Escola de Origem: " + alunoTemp.getEscolaOrigem());
                System.out.println("Nome do aluno: " + alunoTemp.getNome());
                System.out.println("Cpf do aluno: " + alunoTemp.getCpf());
                System.out.println("Rg do aluno: " + alunoTemp.getRg());
                System.out.println("Data de Nascimento: " + alunoTemp.getDataNasc());
                System.out.println("Naturalidade: " + alunoTemp.getNaturalidade());
                System.out.println("Sexo: " + alunoTemp.getSexo());
                System.out.println("Nome da filiação 1 (mãe): " + alunoTemp.getNomeFiliacao1());
                System.out.println("Nome da filiação 2 (pai): " + alunoTemp.getNomeFiliacao2());
                System.out.println("Endereço: " + alunoTemp.getEndereco());
                System.out.println("Contato: " + alunoTemp.getContato());
                System.out.println("-------------------------------------------------------------------------");
                alunos.add(alunoTemp);
            }
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage() + "\n");
        }finally {
            try {
                connection.close();
                statement.close();
                result.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar conexão: " + e.getMessage() + "\n");
            }
        }
    }
    //-----------------------------------ATUALIZANDO ENDERECO NO REGISTRO----------------------------------------//
    public void updateAlunoEnd(int  matricula, String endereco){
        connect();
        String sql = "UPDATE aluno SET enderecoAluno=? WHERE matriculaAluno=?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, endereco);
            pst.setInt(2,matricula);
            pst.execute();
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage() + "\n");
        }finally {
            try {
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage() + "\n");
            }
        }
    }
    //-----------------------------------ATUALIZANDO CONTATO NO REGISTRO----------------------------------------//
    public void updateAlunoCont(int  matricula, String contato){
        connect();
        String sql = "UPDATE aluno SET contatoAluno=?  WHERE matriculaAluno=?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(  1,contato);
            pst.setInt(2,matricula);
            pst.execute();
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage() + "\n");
        }finally {
            try {
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage() + "\n");
            }
        }
    }
    //-----------------------------------ATUALIZANDO TURMA NO REGISTRO----------------------------------------//
    public void updateTurma (int  matricula, int id){
        connect();
        String sql = "UPDATE Aluno SET Turma_idTurma=?  WHERE matriculaAluno=?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt( 1,id);
            pst.setInt(2,matricula);
            pst.execute();
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage() + "\n");
        }finally {
            try {
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage() + "\n");
            }
        }
    }
    //-----------------------------------------EXCLUINDO REGISTRO----------------------------------------------//
    public void deleteAluno(int id){
        connect();
        String sql = "DELETE FROM aluno WHERE matriculaAluno=?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1,id);
            pst.execute();
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage() + "\n");
        }finally {
            try {
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage() + "\n");
            }
        }
    }
}
