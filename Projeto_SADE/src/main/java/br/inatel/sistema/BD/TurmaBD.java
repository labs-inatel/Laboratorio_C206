package br.inatel.sistema.BD;

import br.inatel.sistema.Database;
import br.inatel.sistema.usuarios.Turmas;
import java.sql.SQLException;
import java.util.ArrayList;

public class TurmaBD extends Database {
    //------------------------------------INSERINDO NOVO REGISTRO---------------------------------------------//
    public void insertTurma(Turmas turmas) {
        int quant = turmas.getNumTurma();

        while(quant != 0) {

            connect();
            String sql = "INSERT INTO Turma (serie,numTurma,Escola_idEscola) VALUES (?,?,?)";

            try {
                pst = connection.prepareStatement(sql);
                pst.setInt(1, turmas.getSerie());                //concatena nome na 1 ? do comando
                pst.setInt(2, quant);                            //concatena nome na 2 ? do comando
                pst.setInt(3, turmas.getId());                   //concatena nome na 3 ? do comando
                pst.execute();                                               //executa o comando
                System.out.println("Turma cadastrada com sucesso!\n");
            }
            catch (SQLException e) {
                System.out.println("Erro na operação: " + e.getMessage() + "\n");
            } finally {
                try {
                    connection.close();
                    pst.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar a conexão: " + e.getMessage() + "\n");
                }
            } quant--;
        }
    }
    //----------------------------------------BUSCANDO TODOS OS REGISTROS-------------------------------------------//
    public void researchTurmas(){
        connect();
        ArrayList<Turmas> turmas = new ArrayList<>();
        String sql = "SELECT * FROM Turma";

        try{
            statement =connection.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()){
                Turmas turmaTemp = new Turmas(result.getInt("serie"), result.getInt("numTurma"),
                result.getInt("Escola_idEscola"));

                turmaTemp.setId(result.getInt("idTurma"));

                System.out.println("Número de identificação: " + turmaTemp.getId());
                System.out.println("Série: " + turmaTemp.getSerie());
                System.out.println("Turma: " + turmaTemp.getNumTurma());
                System.out.println("-------------------------------------------------------------------------");
                turmas.add(turmaTemp);
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
    //----------------------------------------VALIDANDO TURMA CADASTRADA-------------------------------------------//
    public int validaTurma (int serie, int numTurma, int idEscola){

        int idTurma = 0;
        try {
            String sql = "SELECT idTurma FROM Turma WHERE Escola_idEscola = ? AND serie = ? AND numTurma = ?";

            connect();
            pst = connection.prepareStatement(sql);
            pst.setInt(1,idEscola);
            pst.setInt(2,serie);
            pst.setInt(3,numTurma);
            result = pst.executeQuery();
            while (result.next())
                idTurma = result.getInt("idTurma");
        }
        catch (SQLException e) {
            System.out.println("Erro na operação: " + e.getMessage() + "\n");
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage() + "\n");
            }
        }
        return idTurma;
    }
    public void updateCoordenador(int idCoordenador, int  id){
        connect();
        String sqlend = "UPDATE Turma SET Coordenador_idCoordenador=? WHERE Escola_idEscola=?";
        try {
            pst = connection.prepareStatement(sqlend);
            pst.setInt(1,idCoordenador);
            pst.setInt(2,id);
            pst.execute();
            System.out.println("Entrou!");
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
