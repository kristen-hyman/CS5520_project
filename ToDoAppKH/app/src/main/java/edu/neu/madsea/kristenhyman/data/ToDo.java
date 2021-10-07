package edu.neu.madsea.kristenhyman.data;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * adapted from Adrienne
 * https://github.com/ahope/cs5520_project/blob/main/todo-list/app/src/main/java/edu/northeastern/cs5520/todo_adrienne/data/ToDo.java
 */
public class ToDo {

    private String taskTitle;
    private String description;
    private Set tags;
    private LocalDateTime deadline;
    private boolean remindMe;
    private LocalDateTime reminderDateTime;

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set getTags() {
        return tags;
    }

    public void setTags(Set tags) {
        this.tags = tags;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public boolean isRemindMe() {
        return remindMe;
    }

    public void setRemindMe(boolean remindMe) {
        this.remindMe = remindMe;
    }

    public LocalDateTime getReminderDateTime() {
        return reminderDateTime;
    }

    public void setReminderDateTime(LocalDateTime reminderDateTime) {
        this.reminderDateTime = reminderDateTime;
    }

    public static ToDo createTodo(String title, String detail) {
        ToDo todo = new ToDo();
        todo.setTaskTitle(title);
        todo.setDescription(detail);
        return todo;
    }
}
