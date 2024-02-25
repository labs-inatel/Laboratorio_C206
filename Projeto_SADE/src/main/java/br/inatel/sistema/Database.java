package br.inatel.sistema;

import java.sql.*;

public abstract class Database {
    protected Connection connection; // objeto responsavel por fazer a conexão com o servidor do MySQL
    protected Statement statement; // objeto responsavel por preparar consultas "SELECT"
    protected ResultSet result; // objeto responsavel por executar consultas "SELECT"
    protected PreparedStatement pst; // objeto responsavel por preparar querys de manipulação dinâmicas (INSERT, UPDATE< DELETE)

    private static final String user = "root"; // usuario de instancia local do servidor
    private static final String password = "rootroot"; // senha do usuario da instancia local do servidor
    private static final String database = "mydb"; // nome do banco de dados a ser utilizado

    //string com URL de conexão com servidor:
    private static final String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false";

    public void connect(){
        try{
            connection = DriverManager.getConnection(url, user,password);
            System.out.println("Conexão feita com sucesso: " + connection + "\n");
        }catch (SQLException e){
            System.out.println("Erro de conexão: " + e.getMessage() + "\n");
        }
    }
}
