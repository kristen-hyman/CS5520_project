package edu.neu.madsea.kristenhyman;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.work.WorkManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import edu.neu.madsea.kristenhyman.data.Project;
import edu.neu.madsea.kristenhyman.data.ProjectRepository;

public class ProjectViewModel extends AndroidViewModel {

    private WorkManager mWorkManager;
    public MutableLiveData<String> projectArtist = new MutableLiveData<>();
    public MutableLiveData<String> projectLocation = new MutableLiveData<>();
    public MutableLiveData<String> projectVenue = new MutableLiveData<>();
    public MutableLiveData<String> projectDate = new MutableLiveData<>();
    public MutableLiveData<String> projectTime = new MutableLiveData<>();
    public MutableLiveData<String> projectBudget = new MutableLiveData<>();
    public MutableLiveData<String> projectDescription = new MutableLiveData<>();
    public MutableLiveData<String> projectEmail = new MutableLiveData<>();

    private MutableLiveData<Boolean> projectCreated = new MutableLiveData<>();
    private ProjectRepository repository;
    private final LiveData<List<Project>> mAllGigs;

    public ProjectViewModel(Application app) {
        super(app);
        mWorkManager = WorkManager.getInstance(app);

        repository = ProjectRepository.getProjectRepository(app);
        //projectArtist = savedStateHandle.get("title");
        if (projectArtist == null) {
            projectArtist = new MutableLiveData<>();
            projectArtist.setValue("");
        }

        if (projectLocation == null) {
            projectLocation = new MutableLiveData<>();
            projectLocation.setValue("");
        }


        if (projectVenue == null) {
            projectVenue = new MutableLiveData<>();
            projectVenue.setValue("");
        }
        if (projectDate == null) {
            projectDate = new MutableLiveData<>();
            projectDate.setValue(LocalDateTime.now().toString());
        }

        if (projectTime == null) {
            projectTime = new MutableLiveData<>();
            projectTime.setValue("");
        }

        if (projectBudget == null) {
            projectBudget = new MutableLiveData<>();
            projectBudget.setValue("");
        }
        // projectDescription = savedStateHandle.get("description");
        if (projectDescription == null) {
            projectDescription = new MutableLiveData<>();
            projectDescription.setValue("");
        }
        // projectDescription = savedStateHandle.get("description");
        if (projectEmail == null) {
            projectEmail = new MutableLiveData<>();
            projectEmail.setValue("");
        }

        mAllGigs = repository.getAllProjects();
        projectCreated.setValue(Boolean.FALSE);
    }

    public LiveData<Boolean> getProjectCreated() {
        return projectCreated;
    }

    public Project createProject() {
        Project createdProject = Project.createProject(projectArtist.getValue(), projectLocation.getValue(), projectVenue.getValue(),
                LocalDateTime.parse(projectDate.getValue()),projectBudget.getValue(), projectDescription.getValue(), projectEmail.getValue());

        repository.insert(createdProject);

        projectCreated.setValue(Boolean.TRUE);

        return createdProject;
    }

    public void deleteTodo(Project todoToDelete) {

        //repository.delete(todoToDelete);

        // remove todo from scheduled work...
        // ReminderWorker.scheduleWork(getApplication().getApplicationContext(), createdTodo);

    }

    public LiveData<List<Project>> getAllGigs() {
        return mAllGigs;
    }

    public void cancelNewTodo() {
        //return to mainActivity

    }
}