
package br.inatel.sistema.BD;

import br.inatel.sistema.Database;
import br.inatel.sistema.usuarios.Escola;
import java.sql.SQLException;
import java.util.ArrayList;

public class EscolaBD extends Database {
    //-----------------------------------VALIDANDO O ACESSO AO SISTEMA----------------------------------------//
    public boolean validacao (int acesso){
        int id = 0;
        boolean validou = false;
        try {
            String sql = "SELECT idEscola FROM Escola";
            connect();
            pst = connection.prepareStatement(sql);
            result = pst.executeQuery();
            while (result.next()) {
                id = result.getInt("idEscola");
                if(acesso == id)
                    validou = true;
            }
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
        return validou;
    }
    //------------------------------------INSERINDO NOVO REGISTRO---------------------------------------------//
    public void insertEscola(Escola escola) {
        connect();
        String sql = "INSERT INTO Escola (idEscola,nomeEscola,cnpjEscola,localizacao,contato) VALUES (?,?,?,?,?)";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, escola.getId());                   //concatena nome na 1 ? do comando
            pst.setString(2, escola.getNome());              //concatena nome na 2 ? do comando
            pst.setString(3, escola.getCnpj());              //concatena nome na 3 ? do comando
            pst.setString(4, escola.getLocalizacao());       //concatena nome na 4 ? do comando
            pst.setString(5, escola.getContato());           //concatena nome na 5 ? do comando
            pst.execute();                                                //executa o comando
            System.out.println("Escola cadastrada com sucesso!\n");
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
    //---------------------------------------AUTO INCREMENT_ID--------------------------------------------//
    public int getLastId() {
        int id = 0;
        try {
            String sql = "SELECT idEscola FROM Escola ORDER BY idEscola DESC LIMIT 1";
            connect();
            pst = connection.prepareStatement(sql);
            result = pst.executeQuery();
            while (result.next())
                id = result.getInt("idEscola");
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
    public void researchEscola(){
        connect();
        ArrayList<Escola> escolas = new ArrayList<>();
        String sql = "SELECT * FROM Escola";

        try{
            statement =connection.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()){
                Escola escolaTemp = new Escola(result.getString("nomeEscola"),
                        result.getString("cnpjEscola"), result.getString("localizacao"),
                        result.getString("contato"));

                escolaTemp.setId(result.getInt("idEscola"));

                System.out.println("Número de identificação: " + escolaTemp.getId());
                System.out.println("Nome da escola: " + escolaTemp.getNome());
                System.out.println("CNPJ do escola: " + escolaTemp.getCnpj());
                System.out.println("Endereço: " + escolaTemp.getLocalizacao());
                System.out.println("Contato: " + escolaTemp.getContato());
                System.out.println("-------------------------------------------------------------------------");
                escolas.add(escolaTemp);
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
    //----------------------------------ATUALIZANDO ENDERECO NO REGISTRO-------------------------------------//
    public void updateEscolaEnd(int  id, String localizacao){
        connect();
        String sqlend = "UPDATE escola SET localizacao=? WHERE idEscola=?";
        try {
            pst = connection.prepareStatement(sqlend);
            pst.setString(1,localizacao);
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
    //----------------------------------ATUALIZANDO CONTATO NO REGISTRO-------------------------------------//
    public void updateEscolaCont(int  id, String contato){
        connect();
        String sqlcot = "UPDATE aluno SET contato=?  WHERE id=?";
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
    public void deleteEscola(int id){
        connect();
        String sql = "DELETE FROM Escola WHERE idEscola=?";

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
