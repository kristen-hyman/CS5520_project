package edu.neu.madsea.kristenhyman.data;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * adapted from Adrienne
 * https://github.com/ahope/cs5520_project/blob/main/todo-list/app/src/main/java/edu/northeastern/cs5520/todo_adrienne/data/ToDoItemRepository.java
 */

public class ToDoRepository implements Iterable<ToDo>{

    private static List<ToDo> todoSet;

    private static ToDoRepository singleton;

    private ToDoRepository() {
        todoSet = new ArrayList<ToDo>();

    }

    public List<ToDo> asList() {
        return todoSet;
    }

    public static ToDoRepository getAllTodos() {
        if (singleton == null) {
            singleton = new ToDoRepository();
            addToDo(ToDo.createTodo("task1", "details1"));
        }
        return singleton;
    }

    public static void addToDo(ToDo newToDo) {
        getAllTodos().todoSet.add(newToDo);
    }

    @NonNull
    @Override
    public Iterator<ToDo> iterator() {
        return todoSet.iterator();
    }

    @Override
    public void forEach(@NonNull Consumer<? super ToDo> action) {
        todoSet.forEach(action);
    }

    @NonNull
    @Override
    public Spliterator<ToDo> spliterator() {
        return todoSet.spliterator();
    }
}