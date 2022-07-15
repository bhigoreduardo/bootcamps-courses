package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

public class TaskController {

    // Variables
    private static int id;
    private static int projectId;
    private static String name;
    private static String description;
    private static boolean status;
    private static String notes;
    private static Date deadline;
    private static Date createdAt;
    private static Date updatedAt;
    private static String query;

    // Attributes of Connection
    Connection connection = null;
    PreparedStatement statement = null;

    // Method INSERT
    public void insertInto(Task task) {
        // SET VALUES in Variables of Project
        projectId = task.getProjectId();
        name = task.getName();
        description = task.getDescription();
        status = task.getStatus();
        notes = task.getNotes();
        deadline = new Date(task.getDeadline().getTime());
        createdAt = new Date(task.getCreatedAt().getTime());
        updatedAt = new Date(task.getUpdatedAt().getTime());

        // Create QUERY
        query = "INSERT INTO `TASKS` (`PROJECTID`"
                + ", `NAME`"
                + ", `DESCRIPTION`"
                + ", `STATUS`"
                + ", `NOTES`"
                + ", `DEADLINE`"
                + ", `CREATEDAT`"
                + ", `UPDATEDAT`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        // Connection with Database
        try {
            connection = ConnectionFactory.getConnection();

            // Prepare QUERY and Block SQL Injection
            statement = connection.prepareStatement(query);

            // SET VALUES in QUERY
            statement.setInt(1, projectId);
            statement.setString(2, name);
            statement.setString(3, description);
            statement.setBoolean(4, status);
            statement.setString(5, notes);
            statement.setDate(6, deadline);
            statement.setDate(7, createdAt);
            statement.setDate(8, updatedAt);

            // Execute QUERY
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Falha no cadastro da tarefa", ex);
        } finally {
            // Close connection with Database
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    // Method SELECT
    public List<Task> selectAll(int projectId) {
        // Create QUERY
        query = "SELECT * FROM `TASKS` WHERE `PROJECTID` = ?";

        // Connection with Database
        ResultSet resultSet = null;
        List<Task> tasksResult = new ArrayList();

        try {
            connection = ConnectionFactory.getConnection();

            // Prepare QUERY and Block SQL Injection
            statement = connection.prepareStatement(query);

            // SET VALUES in QUERY
            statement.setInt(1, projectId);

            // Execute QUERY
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Task task = new Task();

                task.setId(resultSet.getInt("ID"));
                task.setProjectId(resultSet.getInt("PROJECTID"));
                task.setName(resultSet.getString("NAME"));
                task.setDescription(resultSet.getString("DESCRIPTION"));
                task.setStatus(resultSet.getBoolean("STATUS"));
                task.setNotes(resultSet.getString("NOTES"));
                task.setDeadline(resultSet.getDate("DEADLINE"));
                task.setCreatedAt(resultSet.getDate("CREATEDAT"));
                task.setUpdatedAt(resultSet.getDate("UPDATEDAT"));

                tasksResult.add(task);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Falha na consulta das tarefas", ex);
        } finally {
            // Close connection with Database
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }

        return tasksResult;
    }

    // Method UPDATE
    public void update(Task task) {
        // SET VALUES in Variables of Project
        id = task.getId();
        projectId = task.getProjectId();
        name = task.getName();
        description = task.getDescription();
        status = task.getStatus();
        notes = task.getNotes();
        deadline = new Date(task.getDeadline().getTime());
        createdAt = new Date(task.getCreatedAt().getTime());
        updatedAt = new Date(task.getUpdatedAt().getTime());

        // Create QUERY
        query = "UPDATE `TASKS` SET `PROJECTID` = ?"
                + ", `NAME` = ?"
                + ", `DESCRIPTION` = ?"
                + ", `STATUS` = ?"
                + ", `NOTES` = ?"
                + ", `DEADLINE` = ?"
                + ", `CREATEDAT` = ?"
                + ", `UPDATEDAT` = ? WHERE `ID` = ?";

        // Connection with Database
        try {
            connection = ConnectionFactory.getConnection();

            // Prepare QUERY and Block SQL Injection
            statement = connection.prepareStatement(query);

            // SET VALUES in QUERY
            statement.setInt(1, projectId);
            statement.setString(2, name);
            statement.setString(3, description);
            statement.setBoolean(4, status);
            statement.setString(5, notes);
            statement.setDate(6, deadline);
            statement.setDate(7, createdAt);
            statement.setDate(8, updatedAt);
            statement.setInt(9, id);

            // Execute QUERY
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Falha na atualização da tarefa", ex);
        } finally {
            // Close connection with Database
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    // Method DELETE
    public void delete(int id) {
        // Create QUERY
        query = "DELETE FROM `TASKS` WHERE `ID` = ?";

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
            throw new RuntimeException("Falha na exclusão da tarefa", ex);
        } finally {
            // Close connection with Database
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
}
