package org.fasttrackit.persistance;

import org.fasttrackit.domain.Task;
import org.fasttrackit.transfer.CreateTaskRequest;
import org.fasttrackit.transfer.UpdateTaskRequest;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    public void createTask(CreateTaskRequest request) throws IOException, SQLException, ClassNotFoundException {
// PREVENTING SQL INJECTION by avoiding concatenation and using prepared statement
        String sql = " INSERT INTO task (description, deadline) VALUES ( ?,?) ";

        try (Connection connection = DatabaseConfiguration.getConnection();
             //statement should be used only for no parameter queries
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, request.getDescription());
            preparedStatement.setDate(2, Date.valueOf(request.getDeadLine()));

            preparedStatement.executeUpdate();
        }
    }

    public void updateTask(long id, UpdateTaskRequest request) throws IOException, SQLException, ClassNotFoundException {
// PREVENTING SQL INJECTION by avoiding concatenation and using prepared statement
            String sql = "  UPDATE task SET done =?  WHERE id = ? ";

                try (Connection connection = DatabaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setBoolean(1, request.isDone());
            preparedStatement.setLong(2, id);

            preparedStatement.executeUpdate();
        }
    }

    public void deleteTask(long id) throws IOException, SQLException, ClassNotFoundException {
// PREVENTING SQL INJECTION by avoiding concatenation and using prepared statement
                String sql = "DELETE FROM task WHERE id = ?";

                try (Connection connection = DatabaseConfiguration.getConnection();
                     PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                    preparedStatement.setLong(1, id);

                    preparedStatement.executeUpdate();
        }
    }

    public List<Task> getTask() throws IOException, SQLException, ClassNotFoundException {
        String sql = " SELECT id, description, deadline, done FROM task ";
        try (Connection connection = DatabaseConfiguration.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            List<Task> tasks = new ArrayList<>();
            while (resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getLong("id"));
                task.setDescription((resultSet.getString("description")));
                task.setDeadline(resultSet.getDate("deadline").toLocalDate());
                task.setDone(resultSet.getBoolean("done"));

                tasks.add(task);
            }
            return tasks;

        }
}

}
