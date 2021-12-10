package edu.neu.madsea.kristenhyman.data;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;


public class ProjectRepository {
    private static ProjectRepository singleton;
    private LiveData<List<Project>> mAllProjects;
    // private ProjectDao mProjectDao;
    private APIDaoImpl ProjectAPIDao;
    private ProjectDatabase db;
    private List<Project> reminderProjects;

    ProjectRepository(Context context) {

        //create a new class that goes to get the get Request stuff APIREquest
        // can have simliar interface as project Dao (this is the retreival functions etc)
        // Dao is used to access DB, so my class will be used to access the API

        //db = ProjectDatabase.getDatabase(context);


        APIDaoImpl mAPIDaoImpl = new APIDaoImpl();
        mAllProjects = mAPIDaoImpl.getAllGigs();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<Project>> getAllProjects() {
        return mAllProjects;
    }

    public static ProjectRepository getProjectRepository(Context app) {
        if (singleton == null) {
            singleton = new ProjectRepository(app);
        }
        return singleton;
    }

    public void insert(Project project) {
        ProjectDatabase.databaseWriteExecutor.execute(() -> {

            ProjectAPIDao.postProject(project);
           // mProjectDao.insert(project);
        });
    }

}
