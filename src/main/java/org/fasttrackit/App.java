package org.fasttrackit;

import org.fasttrackit.persistance.TaskRepository;
import org.fasttrackit.transfer.CreateTaskRequest;
import org.fasttrackit.transfer.UpdateTaskRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, SQLException {
        TaskRepository taskRepository = new TaskRepository();
           CreateTaskRequest request = new CreateTaskRequest();
        request.setDescription("Learn JDBC");
        request.setDeadLine(LocalDate.now().plusWeeks(1));
////
        taskRepository.createTask(request);

//        UpdateTaskRequest request = new UpdateTaskRequest();
//        request.setDone(true);
//
//        taskRepository.updateTask(1, request);

//        taskRepository.deleteTask(1);


}
}
