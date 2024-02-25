package br.inatel.sistema.BD;

import br.inatel.sistema.Database;
import br.inatel.sistema.usuarios.Professor;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfessorBD extends Database {
    //------------------------------------INSERINDO NOVO REGISTRO---------------------------------------------//
    public void insertProfessor(Professor professor) {
        connect();
        String sql = "INSERT INTO professor(idProfessor,nomeProfessor,cpfProfessor,rgProfessor,dataNascP," +
                "naturalidadeProfessor,sexoProfessor,cargo,disciplina,endereco,contato) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1,professor.getId());                    //concatena nome na 1 ? do comando
            pst.setString(2, professor.getNome());              //concatena nome na 2 ? do comando
            pst.setString(3, professor.getCpf());               //concatena nome na 3 ? do comando
            pst.setString(4, professor.getRg());                //concatena nome na 4 ? do comando
            pst.setString(5, professor.getDataNasc());          //concatena nome na 5 ? do comando
            pst.setString(6, professor.getNaturalidade());      //concatena nome na 6 ? do comando
            pst.setString(7, professor.getSexo());              //concatena nome na 7 ? do comando
            pst.setString(8, professor.getCargo());             //concatena nome na 8 ? do comando
            pst.setString(9, professor.getDisciplina());        //concatena nome na 9 ? do comando
            pst.setString(10, professor.getEndereco());         //concatena nome na 10 ? do comando
            pst.setString(11, professor.getContato());          //concatena nome na 11 ? do comando
            pst.execute();                                                   //executa o comando
            System.out.println("Professor cadastrado com sucesso!\n");
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
    //------------------------------------AUTO INCREMENT_ID---------------------------------------------//
    public int getLastId() {
        int id = 0;
        try {
            String sql = "SELECT idProfessor FROM Professor ORDER BY idProfessor DESC LIMIT 1";
            connect();
            pst = connection.prepareStatement(sql);
            result = pst.executeQuery();
            while (result.next())
                id = result.getInt("idProfessor");
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
        return id;
    }
    //-----------------------------------BUSCANDO TODOS OS REGISTROS-------------------------------------------//
    public void researchProfessor(){
        connect();
        ArrayList<Professor> professores = new ArrayList<>();
        String sql = "SELECT * FROM professor";

        try{
            statement =connection.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()){
                Professor professorTemp = new Professor(result.getString("nomeProfessor"),
                        result.getString("cpfProfessor"), result.getString("rgProfessor"),
                        result.getString("dataNascP"),  result.getString("naturalidadeProfessor"),
                        result.getString("sexoProfessor"), result.getString("cargo"),
                        result.getString("disciplina"), result.getString("endereco"),
                        result.getString("contato"));

                professorTemp.setId(result.getInt("idProfessor"));

                System.out.println("Número de Identificação: " + professorTemp.getId());
                System.out.println("Nome do professor: " + professorTemp.getNome());
                System.out.println("Cpf do professor: " + professorTemp.getCpf());
                System.out.println("Rg do professor: " + professorTemp.getRg());
                System.out.println("Data de Nascimento: " + professorTemp.getDataNasc());
                System.out.println("Naturalidade: " + professorTemp.getNaturalidade());
                System.out.println("Sexo: " + professorTemp.getSexo());
                System.out.println("Cargo: " + professorTemp.getCargo());
                System.out.println("Disciplina: " + professorTemp.getDisciplina());
                System.out.println("Endereço: " + professorTemp.getEndereco());
                System.out.println("Contato: " + professorTemp.getContato());
                System.out.println("-------------------------------------------------------------------------");
                professores.add(professorTemp);
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
    //-----------------------------------ATUALIZANDO ENDEREÇO NO REGISTRO----------------------------------------//
    public void updateProfessorEnd(int  id, String endereco){
        connect();
        String sql = "UPDATE professor SET endereco=? WHERE idProfessor=?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1,endereco);
            pst.setInt(2,id);
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
    public void updateProfessorCont(int  id, String contato){
        connect();
        String sql = "UPDATE professor SET contato=? WHERE idProfessor=?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1,contato);
            pst.setInt(2,id);
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
    public void deleteProfessor(int id){
        connect();
        String sql = "DELETE FROM professor WHERE idProfessor=?";

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
    //----------------------------------ASSOCIAÇÃO PROFESSOR E ESCOLA----------------------------------------------//
    public void ProfessorEscola(int idProfessor, int idEscola) {
        connect();
        String sql = "INSERT INTO Professor_has_Escola (Escola_idEscola, Professor_idProfessor) VALUES (?,?)";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1,idEscola);                    //concatena nome na 1 ? do comando
            pst.setInt(2, idProfessor);                //concatena nome na 2 ? do comando
            pst.execute();                                          //executa o comando
            System.out.println("ADCIONADO NO BD!");
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
    //----------------------------------ASSOCIAÇÃO PROFESSOR E TURMA----------------------------------------------//
    public void ProfessorTurma(int idProfessor, int idTurma) {
        connect();
        String sql = "INSERT INTO Professor_has_Turma (Turma_idTurma, Professor_idProfessor) VALUES (?,?)";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1,idTurma);                     //concatena nome na 1 ? do comando
            pst.setInt(2, idProfessor);                //concatena nome na 2 ? do comando
            pst.execute();                                          //executa o comando
            System.out.println("ADCIONADO NO BD!\n");
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
}
