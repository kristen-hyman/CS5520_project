package edu.neu.madsea.kristenhyman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.neu.madsea.kristenhyman.data.ProjectItemRecyclerViewAdapter;
import edu.neu.madsea.kristenhyman.databinding.ActivityProjectListViewBinding;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * adapted from Adrienne
 * https://github.com/ahope/cs5520_project/blob/main/todo-list/app/src/main/java/edu/northeastern/cs5520/todo_adrienne
 */
public class ProjectActivity_ListView extends AppCompatActivity {

    private ActivityProjectListViewBinding binding;
    private List<ProjectViewModel> models = new ArrayList<>();
    private ProjectViewModel mProjectViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mProjectViewModel = new ViewModelProvider(this).get(ProjectViewModel.class);

        // This is what we would do if we weren't using the ViewBinding (as we see below)
//        setContentView(R.layout.activity_main_list_view);

        // Use the ViewBinding instead of the layout directly
        binding = ActivityProjectListViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.recyclerViewMain.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerViewMain.scrollToPosition(0);

        final ProjectItemRecyclerViewAdapter adapter =
                new ProjectItemRecyclerViewAdapter();

        mProjectViewModel.getAllGigs().observe(this, todos -> {
            adapter.submitList(todos);
        });



        binding.recyclerViewMain.setAdapter(adapter);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProjectActivity_ListView.this, NewProjectActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    //tell the adapter that the data has changed
    // activity is created, populated, plus button to to open a new activity and pauses the existing
    // crates a new instance and then goes away... because we go back to the original activity is it resumed
    // so - add this to tell teh adapter that the data changed so it repopulates UI
    public void onResume() {
        super.onResume();
        binding.recyclerViewMain.getAdapter().notifyDataSetChanged();
    }


    public void deleteTodo(View view) {
        mProjectViewModel = new ViewModelProvider(this).get(ProjectViewModel.class);

        // Use the ViewBinding instead of the layout directly
        binding = ActivityProjectListViewBinding.inflate(getLayoutInflater());

    }

}