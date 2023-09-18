package servlets.model;

import java.time.LocalDate;

public class Task {
    private Long id;
    private String name;
    private String description;
    private LocalDate deadlineDate;
    private boolean isDone;

    public Task() {
    }

    public Task(Long id, String name, String description, LocalDate deadlineDate,boolean isDone) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.deadlineDate = deadlineDate;
        this.isDone = isDone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(LocalDate deadlineDate) {
        this.deadlineDate = deadlineDate;
    }
    public boolean getIsDone(){
        return isDone;
    }
    public void setIsDone(boolean isDone){
        this.isDone = isDone;
    }
}
