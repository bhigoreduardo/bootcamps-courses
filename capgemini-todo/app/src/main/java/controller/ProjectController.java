package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;

public class ProjectController {

    // Variables
    private static int id;
    private static String name;
    private static String description;
    private static Date createdAt;
    private static Date updatedAt;
    private static String query;

    // Attributes of Connection
    private static Connection connection = null;
    private static PreparedStatement statement = null;

    // Method INSERT
    public static void insertInto(Project project) {
        // SET VALUES in Variables of Project
        name = project.getName();
        description = project.getDescription();
        createdAt = new Date(project.getCreatedAt().getTime());
        updatedAt = new Date(project.getUpdatedAt().getTime());

        // Create QUERY
        query = "INSERT INTO `PROJECTS` (`NAME`"
                + ", `DESCRIPTION`"
                + ", `CREATEDAT`"
                + ", `UPDATEDAT`"
                + ") VALUES (?, ?, ?, ?)";

        // Connection with Database
        try {
            connection = ConnectionFactory.getConnection();

            // Prepare QUERY and Block SQL Injection
            statement = connection.prepareStatement(query);

            // SET VALUES in QUERY
            statement.setString(1, name);
            statement.setString(2, description);
            statement.setDate(3, createdAt);
            statement.setDate(4, updatedAt);

            // Execute QUERY
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Falha no cadastro do projeto", ex);
        } finally {
            // Close connection
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    // Method SELECT
    public static List<Project> selectAll() {
        // Create QUERY
        query = "SELECT * FROM `PROJECTS`";

        // Connection with Database
        ResultSet resultSet = null;
        List<Project> projectsResult = new ArrayList();

        try {
            connection = ConnectionFactory.getConnection();

            // Prepare QUERY and Block SQL Injection
            statement = connection.prepareStatement(query);

            // Execute QUERY
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Project project = new Project();

                // SET VALUES in Project Instance
                project.setId(resultSet.getInt("ID"));
                project.setName(resultSet.getString("NAME"));
                project.setDescription(resultSet.getString("DESCRIPTION"));
                project.setCreatedAt(resultSet.getDate("CREATEDAT"));
                project.setUpdatedAt(resultSet.getDate("UPDATEDAT"));

                // Add Project in projectsResult
                projectsResult.add(project);
            }

            return projectsResult;
        } catch (Exception ex) {
            throw new RuntimeException("Falha na consulta dos projetos", ex);
        } finally {
            // Close connection with Database
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
    }

    // Method UPDATE
    public static void update(Project project) {
        // SET VALUES in Variables of Project
        id = project.getId();
        name = project.getName();
        description = project.getDescription();
        createdAt = new Date(project.getCreatedAt().getTime());
        updatedAt = new Date(project.getUpdatedAt().getTime());

        // Create QUERY
        query = "UPDATE `PROJECTS` SET `NAME` = ?"
                + ", `DESCRIPTION` = ?"
                + ", `CREATEDAT` = ?"
                + ", `UPDATEDAT` = ?"
                + " WHERE `ID` = ?";

        // Connection with Database
        try {
            connection = ConnectionFactory.getConnection();

            // Prepare QUERY and Block SQL Injection
            statement = connection.prepareStatement(query);

            // SET VALUES in QUERY
            statement.setString(1, name);
            statement.setString(2, description);
            statement.setDate(3, createdAt);
            statement.setDate(4, updatedAt);
            statement.setInt(5, id);

            // Execute QQUERY
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Falha na atualização do projeto", ex);
        } finally {
            // Close connection
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    // Method DELETE
    public static void delete(int idProject) {
        // Create QUERY
        query = "DELETE FROM `PROJECTS` WHERE `ID` = ?";

        // Connection with Database
        try {
            connection = ConnectionFactory.getConnection();

            // Preapare QUERY and Block SQL Injection
            statement = connection.prepareStatement(query);

            // SET VALUES in QUERY
            statement.setInt(1, idProject);

            // Execute QUERY
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Falha na exclusão do projeto");
        } finally {
            // Close connection
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
}
