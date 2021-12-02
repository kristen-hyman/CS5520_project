package edu.neu.madsea.kristenhyman.data;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * adapted from Adrienne
 * https://github.com/ahope/cs5520_project/blob/main/todo-list/app/src/main/java/edu/northeastern/cs5520/todo_adrienne/data/ToDoItemRepository.java
 */

public class ToDoRepository {
    private static ToDoRepository singleton;
    private LiveData<List<Project>> mAllProjects;
    private ProjectDao mProjectDao;
    private ProjectDatabase db;
    private List<Project> reminderProjects;

    ToDoRepository(Context context) {
        db = ProjectDatabase.getDatabase(context);
        mProjectDao = db.toDoDao();
        mAllProjects = mProjectDao.getAlphabetizedWords();
    }

    public void addFakeToDo() {
        mProjectDao.insert(Project.createTodo("Task todo 1", "do something, already",
                "11/4/2021", "11/2/2021"));
    }


    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<Project>> getAllProjects() {
        return mAllProjects;
    }


    public static ToDoRepository getToDoRepository(Context app) {
        if (singleton == null) {
            singleton = new ToDoRepository(app);
        }
        return singleton;
    }

    public void insert(Project todo) {
        ProjectDatabase.databaseWriteExecutor.execute(() -> {
            mProjectDao.insert(todo);
        });
    }

    public void delete(Project todo) {
        ProjectDatabase.databaseWriteExecutor.execute(() -> {
            mProjectDao.deleteByTaskTitle(todo.getTaskTitle());
        });
    }
}
