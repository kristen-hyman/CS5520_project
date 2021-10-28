package edu.neu.madsea.kristenhyman.data;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * adapted from Adrienne
 * https://github.com/ahope/cs5520_project/blob/main/todo-list/app/src/main/java/edu/northeastern/cs5520/todo_adrienne/data/ToDoItemRepository.java
 */

public class ToDoRepository {
    private static ToDoRepository singleton;
    private LiveData<List<ToDo>> mAllToDos;
    private ToDoDao mToDoDao;
    private ToDoDatabase db;

    ToDoRepository(Context context) {
        db = ToDoDatabase.getDatabase(context);
        mToDoDao = db.toDoDao();
        mAllToDos = mToDoDao.getAlphabetizedWords();
    }

    public void addFakeToDo() {
        mToDoDao.insert(ToDo.createTodo("Task todo 1", "do something, already"));
    }


    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<ToDo>> getAllTodos() {
        return mAllToDos;
    }

    public static ToDoRepository getToDoRepository(Context app) {
        if (singleton == null) {
            singleton = new ToDoRepository(app);
        }
        return singleton;
    }

    public void insert(ToDo todo) {
        ToDoDatabase.databaseWriteExecutor.execute(() -> {
            mToDoDao.insert(todo);
        });
    }
}


    /**
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
     **/
