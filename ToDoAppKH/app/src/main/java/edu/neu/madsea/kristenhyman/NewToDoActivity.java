package edu.neu.madsea.kristenhyman;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;


/**
 *  Adapted from Adrienne
 *  https://github.com/ahope/cs5520_project/tree/main/todo-list
 */
public class NewToDoActivity extends AppCompatActivity {

    private ToDoViewModel toDoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_to_do);

        // Get an instance to the shared ViewModel
        toDoViewModel = new ViewModelProvider(this).get(ToDoViewModel.class);

        // Observe a flag we use to say the new ToDo has been created
        // This is a bit of a hack; there's a slightly better way to do this (observe an
        //   event rather than a Boolean), but this is okay for now.
        toDoViewModel.getTodoCreated().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean todoCreated) {
                if (todoCreated) {
//                    setResult();
                    finish();
                }
            }
        });
    }

}