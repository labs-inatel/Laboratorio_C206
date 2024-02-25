package br.inatel.sistema.BD;

import br.inatel.sistema.Database;
import br.inatel.sistema.usuarios.Diretor;
import java.sql.SQLException;
import java.util.ArrayList;

public class DiretorBD extends Database {
    //------------------------------------INSERINDO NOVO REGISTRO---------------------------------------------//
    public void insertDiretor(Diretor diretor) {
        connect();
        String sql = "INSERT INTO Diretor (idDiretor,nomeDiretor,cpfDiretor,rgDiretor,dataNascD,naturalidadeDiretor," +
                "endereco,contato,Escola_idEscola) VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, diretor.getId());                    //concatena nome na 1 ? do comando
            pst.setString(2, diretor.getNome());               //concatena nome na 2 ? do comando
            pst.setString(3, diretor.getCpf());                //concatena nome na 3 ? do comando
            pst.setString(4, diretor.getRg());                 //concatena nome na 4 ? do comando
            pst.setString(5, diretor.getDataNasc());           //concatena nome na 5 ? do comando
            pst.setString(6, diretor.getNaturalidade());       //concatena nome na 6 ? do comando
            pst.setString(7, diretor.getEndereco());           //concatena nome na 7 ? do comando
            pst.setString(8, diretor.getContato());            //concatena nome na 8 ? do comando
            pst.setInt(9, diretor.getIdEscola());              //concatena nome na 9 ? do comando
            pst.execute();                                                  //executa o comando
            System.out.println("Diretor cadastrado com sucesso!\n");
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
    public void researchDiretor(){
        connect();
        ArrayList<Diretor> diretores = new ArrayList<>();
        String sql = "SELECT * FROM Diretor";

        try{
            statement =connection.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()){
                Diretor diretorTemp = new Diretor(result.getString("nomeDiretor"),
                        result.getString("cpfDiretor"), result.getString("rgDiretor"),
                        result.getString("dataNascD"), result.getString("naturalidadeDiretor"),
                        result.getString("endereco"), result.getString("contato"),
                        result.getInt("Escola_idEscola"));

                diretorTemp.setId(result.getInt("idDiretor"));

                System.out.println("Número de id: " + diretorTemp.getId());
                System.out.println("Nome do diretor: " + diretorTemp.getNome());
                System.out.println("Cpf do diretor: " + diretorTemp.getCpf());
                System.out.println("Rg do diretor: " + diretorTemp.getRg());
                System.out.println("Data de Nascimento: " + diretorTemp.getDataNasc());
                System.out.println("Naturalidade: " + diretorTemp.getNaturalidade());
                System.out.println("Endereço: " + diretorTemp.getEndereco());
                System.out.println("Contato: " + diretorTemp.getContato());
                System.out.println("-------------------------------------------------------------------------");
                diretores.add(diretorTemp);
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
    public void updateDiretorEnd(int  id, String endereco){
        connect();
        String sqlend = "UPDATE Diretor SET endereco=? WHERE idDiretor=?";
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
    public void updateDiretorCont(int  id, String contato){
        connect();
        String sqlcot = "UPDATE Diretor SET contato=?  WHERE idDiretor=?";
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
    public void deleteDiretor(int id){
        connect();
        String sql = "DELETE FROM Diretor WHERE idDiretor=?";

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
