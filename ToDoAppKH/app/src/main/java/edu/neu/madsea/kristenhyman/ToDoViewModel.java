package edu.neu.madsea.kristenhyman;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import edu.neu.madsea.kristenhyman.data.TimeConverter;
import edu.neu.madsea.kristenhyman.data.ToDo;
import edu.neu.madsea.kristenhyman.data.ToDoRepository;


/**
 * Adapted from Adrienne
 * https://github.com/ahope/cs5520_project/tree/main/todo-list
 */
public class ToDoViewModel extends AndroidViewModel {

    private WorkManager mWorkManager;
    public MutableLiveData<String> todoTitle = new MutableLiveData<>();
    public MutableLiveData<String> todoDescription = new MutableLiveData<>();
    public MutableLiveData<String> todoDueDate = new MutableLiveData<>();
    public MutableLiveData<String> todoReminderDate = new MutableLiveData<>();

    private MutableLiveData<Boolean> todoCreated = new MutableLiveData<>();
    private ToDoRepository repository;
    private final LiveData<List<ToDo>> mAllToDos;

    public ToDoViewModel(Application app) {
        super(app);
        mWorkManager = WorkManager.getInstance(app);

        repository = ToDoRepository.getToDoRepository(app);
        //todoTitle = savedStateHandle.get("title");
        if (todoTitle == null) {
            todoTitle = new MutableLiveData<>();
            todoTitle.setValue("");
        }
        // todoDescription = savedStateHandle.get("description");
        if (todoDescription == null) {
            todoDescription = new MutableLiveData<>();
            todoDescription.setValue("");
        }

        if (todoDueDate == null) {
            todoDueDate = new MutableLiveData<>();
            todoDueDate.setValue("");
        }

        if (todoReminderDate == null) {
            todoReminderDate = new MutableLiveData<>();
            todoReminderDate.setValue("");
        }
        mAllToDos = repository.getAllTodos();
        todoCreated.setValue(Boolean.FALSE);
    }

    public LiveData<Boolean> getTodoCreated() {
        return todoCreated;
    }

    public ToDo createTodo() {
        ToDo createdTodo = ToDo.createTodo(todoTitle.getValue(), todoDescription.getValue(),
                todoDueDate.getValue(),
                todoReminderDate.getValue());

        repository.insert(createdTodo);
        // pass todo into schedule work method
        ReminderWorker.scheduleWork(getApplication().getApplicationContext(), createdTodo);

        todoCreated.setValue(Boolean.TRUE);

        return createdTodo;
    }

    public LiveData<List<ToDo>> getAllToDos() {
        return mAllToDos;
    }

}