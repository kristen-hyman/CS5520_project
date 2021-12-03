package edu.neu.madsea.kristenhyman.data;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;


public class ProjectRepository {
    private static ProjectRepository singleton;
    private LiveData<List<Project>> mAllProjects;
    private ProjectDao mProjectDao;
    private ProjectDatabase db;
    private List<Project> reminderProjects;

    ProjectRepository(Context context) {
        db = ProjectDatabase.getDatabase(context);
        mProjectDao = db.toDoDao();
        mAllProjects = mProjectDao.getAlphabetizedWords();
    }

    public void addFakeToDo() {
        mProjectDao.insert(Project.createProject("Task todo 1", "do something, already",
                "11/4/2021", "11/2/2021"));
    }


    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<Project>> getAllProjects() {
        return mAllProjects;
    }


    public static ProjectRepository getToDoRepository(Context app) {
        if (singleton == null) {
            singleton = new ProjectRepository(app);
        }
        return singleton;
    }

    public void insert(Project project) {
        ProjectDatabase.databaseWriteExecutor.execute(() -> {
            mProjectDao.insert(project);
        });
    }

    public void delete(Project project) {
        ProjectDatabase.databaseWriteExecutor.execute(() -> {
            mProjectDao.deleteByTaskTitle(project.getArtistName());
        });
    }
}
