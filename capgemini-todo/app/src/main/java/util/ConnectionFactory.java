package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {

    // Attributes    
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/projectmanager";
    public static final String USER = "root";
    public static final String PASS = "";

    // Connection with Database
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER); // Loaded Driver
            return DriverManager.getConnection(URL, USER, PASS); // Connection
        } catch (Exception ex) {
            throw new RuntimeException("Erro de conexão de banco de dados", ex);
        }
    }

    // Close Connection with Database
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Falha para fechar a conexão com banco de dados", ex);
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement statement) {
        try {
            if (connection != null) {
                connection.close();
            }

            if (statement != null) {
                statement.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Falha para fechar a conexão com banco de dados", ex);
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Falha para fechar a conexão com banco de dados", ex);
        }
    }
}
