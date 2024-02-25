package br.inatel.sistema.BD;

import br.inatel.sistema.Database;
import br.inatel.sistema.usuarios.Coordenador;
import java.sql.SQLException;
import java.util.ArrayList;

public class CoordenadorBD extends Database {
    //------------------------------------INSERINDO NOVO REGISTRO---------------------------------------------//
    public void insertCoordenador(Coordenador coordenador) {
        connect();
        String sql = "INSERT INTO Coordenador (idCoordenador,nomeCoordenador,cpfCoordenador,rgCoordenador, dataNascC, " +
                "naturalidadeCoordenador,enderecoCoordenador,contatoCoordenador, Escola_idEscola) VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, coordenador.getId());                    //concatena nome na 1 ? do comando
            pst.setString(2, coordenador.getNome());               //concatena nome na 2 ? do comando
            pst.setString(3, coordenador.getCpf());                //concatena nome na 3 ? do comando
            pst.setString(4, coordenador.getRg());                 //concatena nome na 4 ? do comando
            pst.setString(5, coordenador.getDataNasc());           //concatena nome na 5 ? do comando
            pst.setString(6, coordenador.getNaturalidade());       //concatena nome na 6 ? do comando
            pst.setString(7, coordenador.getEndereco());           //concatena nome na 7 ? do comando
            pst.setString(8, coordenador.getContato());            //concatena nome na 8 ? do comando
            pst.setInt(9,coordenador.getIdEscola());               //concatena nome na 9 ? do comando
            pst.execute();                                                      //executa o comando
            System.out.println("Coordenador cadastrado com sucesso!\n");
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
    //----------------------------------------BUSCANDO TODOS OS REGISTROS-------------------------------------------//
    public void researchCoordenador(){
        connect();
        ArrayList<Coordenador> coordenadores = new ArrayList<>();
        String sql = "SELECT * FROM Coordenador";

        try{
            statement =connection.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()){
                Coordenador coordenadorTemp = new Coordenador(result.getString("nomeCoordenador"),
                        result.getString("cpfCoordenador"), result.getString("rgCoordenador"),
                        result.getString("dataNascC"), result.getString("naturalidadeCoordenador"),
                        result.getString("enderecoCoordenador"), result.getString("contatoCoordenador"),
                        result.getInt("Escola_idEscola"));

                coordenadorTemp.setId(result.getInt("idCoordenador"));

                System.out.println("Número de id: " + coordenadorTemp.getId());
                System.out.println("Nome do Coordenador: " + coordenadorTemp.getNome());
                System.out.println("Cpf do Coordenador: " + coordenadorTemp.getCpf());
                System.out.println("Rg do Coordenador: " + coordenadorTemp.getRg());
                System.out.println("Data de Nascimento: " + coordenadorTemp.getDataNasc());
                System.out.println("Naturalidade: " + coordenadorTemp.getNaturalidade());
                System.out.println("Endereço: " + coordenadorTemp.getEndereco());
                System.out.println("Contato: " + coordenadorTemp.getContato());
                System.out.println("-------------------------------------------------------------------------");
                coordenadores.add(coordenadorTemp);
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
    public void updateCoordenadorEnd(int  id, String endereco){
        connect();
        String sqlend = "UPDATE Coordenador SET enderecoCoordenador=? WHERE idCoordenador=?";
        try {
            pst = connection.prepareStatement(sqlend);
            pst.setString(1, endereco);
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
    public void updateCoordenadorCont(int  id, String contato){
        connect();
        String sqlcot = "UPDATE Coordenador SET contatoCoordenador=?  WHERE idCoordenador=?";
        try {
            pst = connection.prepareStatement(sqlcot);
            pst.setString(  1,contato);
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
    public void deleteCoordenador(int id){
        connect();
        String sql = "DELETE FROM Coordenador WHERE idCoordenador=?";

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

