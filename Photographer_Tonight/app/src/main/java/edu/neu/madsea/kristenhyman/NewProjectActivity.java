package edu.neu.madsea.kristenhyman;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.neu.madsea.kristenhyman.databinding.ActivityNewProjectBinding;


/**
 *  Adapted from Adrienne
 *  https://github.com/ahope/cs5520_project/tree/main/todo-list
 */
public class NewProjectActivity extends AppCompatActivity {

    private ProjectViewModel projectViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_new_to_do);

        // use binding to set the data for the view
        // jetpack generates this class for you for binding
        ActivityNewProjectBinding binding = ActivityNewProjectBinding.inflate(getLayoutInflater());
        // this is the instance associated w/ the binding to make sure i'm using hte asme
        // viewmodel and layout between activity and layout
        setContentView(binding.getRoot());

        // Get an instance to the shared ViewModel
        // this must be the same between the activity and the layout
        projectViewModel = new ViewModelProvider(this).get(ProjectViewModel.class);
        binding.setViewmodel(projectViewModel);

        // finding the create button
        Button button = (Button)findViewById(R.id.buttonCreate);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                projectViewModel.createProject();
            }
        });

        // "no such instance projectViewModel
        projectViewModel.getProjectCreated().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean todoCreated) {
                if (todoCreated) {
//                    setResult();
                    finish();
                }
            }
        });

        Button cancelButton = (Button)findViewById(R.id.buttonCancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                projectViewModel.cancelNewTodo();
            }
        });
        binding.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewProjectActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


}