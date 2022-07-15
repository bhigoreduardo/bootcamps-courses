package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.User;
import util.ConnectionFactory;

public class UserController {

    // Attributes
    private static int id;
    private static String user;
    private static String password;
    private static String query;
    private static ResultSet resultSet;
    private static User userResult;

    // Attributes of Connection
    Connection connection;
    PreparedStatement statement;

    // Method INSERT
    public void insertInto(User user) {
        // Variables
        this.user = user.getUser();
        this.password = user.getPassword();

        // Create QUERY
        query = "INSERT INTO `USERS` (`USER`"
                + ", `PASSWORD`) VALUES (?, ?)";

        // Connection with Database
        try {
            connection = ConnectionFactory.getConnection();

            // Prepare QUERY and Block SQL Injection
            statement = connection.prepareStatement(query);

            // SET VALUES in QUERY
            statement.setString(1, this.user);
            statement.setString(2, this.password);

            // Execute QUERY
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Falha no cadastro de usuário" + ex.getMessage());
        } finally {
            // Close connection with Database
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    // Method SELECT
    public User selectAll(int id) {
        // Create QUERY
        query = "SELECT * FROM `USERS` WHERE `ID` = ?";

        // Connection with Database
        try {
            connection = ConnectionFactory.getConnection();

            // Prepare QUERY and Block SQL Injection
            statement = connection.prepareStatement(query);

            // SET VALUES in QUERY
            statement.setInt(1, id);

            // Execute QUERY
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                this.id = resultSet.getInt("ID");
                this.user = resultSet.getString("USER");
                this.password = resultSet.getString("PASSWORD");

                userResult = new User(this.id, this.user, password);
            }

        } catch (Exception ex) {
            throw new RuntimeException("Falha na consulta do usuário" + ex.getMessage());
        } finally {
            // Close connection with Database
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }

        return userResult;
    }

    // Method UPDATE
    public void update(User user) {

        // Variables
        this.id = user.getId();
        this.user = user.getUser();
        this.password = user.getPassword();

        // Create QUERY
        query = "UPDATE `USERS` SET "
                + "`USER` = ? "
                + ", `PASSWORD` = ? WHERE `ID` = ?";

        // Connection with Database
        try {
            connection = ConnectionFactory.getConnection();

            // Prepare QUERY and Block SQL Injection
            statement = connection.prepareStatement(query);

            // SET VALUES in QUERY
            statement.setString(1, this.user);
            statement.setString(2, this.password);
            statement.setInt(3, this.id);

            // Execute QUERY
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Falha na atualização do usuário" + ex.getMessage());
        } finally {
            // Close connection with Database
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    // Method DELETE
    public void delete(int id) {
        // Create QUERY
        query = "DELETE FROM `USERS` WHERE `ID` = ?";

        // Connection with Database
        try {
            connection = ConnectionFactory.getConnection();

            // Prepare QUERY and Block SQL Injection
            statement = connection.prepareStatement(query);

            // SET VALUES in QUERY
            statement.setInt(1, id);

            // Execute QUERY
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Falha na exclusão do usuário" + ex.getMessage());
        } finally {
            // Close connection with Database
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    // Method Login/Register
    public User selectUser(String user) {
        // Create QUERY
        query = "SELECT * FROM `USERS` WHERE `USER` = ?";

        // Connection with Database
        try {
            connection = ConnectionFactory.getConnection();

            // Prepare QUERY and Block SQL Injection
            statement = connection.prepareStatement(query);

            // SET VALUES in QUERY
            statement.setString(1, user);

            // Execute QUERY
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                this.id = resultSet.getInt("ID");
                this.user = resultSet.getString("USER");
                this.password = resultSet.getString("PASSWORD");

                userResult = new User(this.id, this.user, this.password);
            }

        } catch (Exception ex) {
            throw new RuntimeException("Falha na consulta do usuário" + ex.getMessage());
        } finally {
            // Close connection with Database
            ConnectionFactory.closeConnection(connection, statement);
        }

        return userResult;
    }
}
