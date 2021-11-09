package edu.neu.madsea.kristenhyman.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * adapted from Adrienne
 * https://github.com/ahope/cs5520_project/blob/main/todo-list/app/src/main/java/edu/northeastern/cs5520/todo_adrienne/data/ToDo.java
 */

@Entity(tableName = "todo_table")
public class ToDo {


    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "taskTitle")
    private String taskTitle;

    @ColumnInfo(name = "description")
    @NonNull
    private String description;


    @ColumnInfo(name = "dueDate")
    @NonNull
    private String dueDate;


    @ColumnInfo(name = "reminderDate")
    @NonNull
    private String reminderDate;


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


    public String getDueDate() {
        return dueDate;
    }
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }


    public String reminderDate() {
        return reminderDate;
    }
    public void setReminderDate(String reminderDate) {
        this.reminderDate = reminderDate;
    }

    // make sure to careful with formatting of the duedate/ reminder duedate
    // you have to tell it how to convert from string to a date

    public static ToDo createTodo(String title, String detail, String dueDate, String reminderDate) {
        ToDo todo = new ToDo();
        todo.setTaskTitle(title);
        todo.setDescription(detail);
        todo.setDueDate(dueDate);
        todo.setReminderDate(reminderDate);
        return todo;
    }


}
