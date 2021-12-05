package edu.neu.madsea.kristenhyman;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.List;

import edu.neu.madsea.kristenhyman.data.ProjectItemRecyclerViewAdapter;
import edu.neu.madsea.kristenhyman.databinding.ActivityMainBinding;

/**
 * adapted from Adrienne
 * https://github.com/ahope/cs5520_project/blob/main/todo-list/app/src/main/java/edu/northeastern/cs5520/todo_adrienne/
 */
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private List<ProjectViewModel> models = new ArrayList<>();
    private ProjectViewModel mProjectViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mProjectViewModel = new ViewModelProvider(this).get(ProjectViewModel.class);

        // This is what we would do if we weren't using the ViewBinding (as we see below)
        //setContentView(R.layout.activity_main);


         // Use the ViewBinding instead of the layout directly
         binding = ActivityMainBinding.inflate(getLayoutInflater());
         setContentView(binding.getRoot());
         //binding.recyclerViewMain.setLayoutManager(new LinearLayoutManager(this));
         //binding.recyclerViewMain.scrollToPosition(0);

         final ProjectItemRecyclerViewAdapter adapter =
         new ProjectItemRecyclerViewAdapter();

         mProjectViewModel.getAllGigs().observe(this, todos -> {
         adapter.submitList(todos);
         });

         //binding.recyclerViewMain.setAdapter(adapter);


        Button addProjectButton = (Button) findViewById(R.id.AddProjectButton);
        addProjectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewProjectActivity.class);
                startActivity(intent);
            }
        });


        Button viewProjectButton = (Button) findViewById(R.id.ViewProjectsButton);
        viewProjectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProjectActivity.class);
                startActivity(intent);
            }
        });
    }
}


