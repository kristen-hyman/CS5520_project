package edu.neu.madsea.kristenhyman;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import edu.neu.madsea.kristenhyman.data.ToDo;
import edu.neu.madsea.kristenhyman.data.ToDoRepository;

/**
 *  Adapted from Adrienne
 *  https://github.com/ahope/cs5520_project/tree/main/todo-list
 */
public class ToDoViewModel extends AndroidViewModel {

    public MutableLiveData<String> todoTitle = new MutableLiveData<>();
    public MutableLiveData<String> todoDescription = new MutableLiveData<>();
    private MutableLiveData<Boolean> todoCreated = new MutableLiveData<>();
    private ToDoRepository repository;
    private final LiveData<List<ToDo>> mAllToDos;

    public ToDoViewModel(Application app) {
        super(app);

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
        mAllToDos = repository.getAllTodos();
        todoCreated.setValue(Boolean.FALSE);
    }

    public LiveData<Boolean> getTodoCreated() {
        return todoCreated;
    }

    public void createTodo() {
        repository.insert(ToDo.createTodo(todoTitle.getValue(), todoDescription.getValue()));
        todoCreated.setValue(Boolean.TRUE);
    }

    public LiveData<List<ToDo>> getAllToDos() {
        return mAllToDos;
    }

}