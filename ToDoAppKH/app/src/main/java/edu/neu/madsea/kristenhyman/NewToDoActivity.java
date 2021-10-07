package edu.neu.madsea.kristenhyman;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.neu.madsea.kristenhyman.data.ToDo;
import edu.neu.madsea.kristenhyman.data.ToDoRepository;
import edu.neu.madsea.kristenhyman.databinding.ActivityNewToDoBinding;


/**
 *  Adapted from Adrienne
 *  https://github.com/ahope/cs5520_project/tree/main/todo-list
 */
public class NewToDoActivity extends AppCompatActivity {

    private ToDoViewModel toDoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_new_to_do);

        // use binding to set the data for the view
        // jetpack generates this class for you for binding
        ActivityNewToDoBinding binding = ActivityNewToDoBinding.inflate(getLayoutInflater());
        // this is the instance associated w/ the binding to make sure i'm using hte asme
        // viewmodel and layout between activity and lauyout
        setContentView(binding.getRoot());

        // Get an instance to the shared ViewModel
        // this must be the same between the activity and the layout
        toDoViewModel = new ViewModelProvider(this).get(ToDoViewModel.class);
        binding.setViewmodel(toDoViewModel);

        // finding the create button
        Button button = (Button)findViewById(R.id.buttonCreate);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toDoViewModel.createTodo();
            }
        });


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