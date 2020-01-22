package org.fasttrackit.transfer;

import java.time.LocalDate;

//DTO= data transfer object
public class UpdateTaskRequest {

    private String description;
    private LocalDate deadLine;
    private boolean done;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    @Override
    public String toString() {
        return "UpdateTaskRequest{" +
                "description='" + description + '\'' +
                ", deadLine=" + deadLine +
                ", done=" + done +
                '}';
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
