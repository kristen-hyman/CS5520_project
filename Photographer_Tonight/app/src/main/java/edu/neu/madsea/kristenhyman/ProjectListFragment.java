package edu.neu.madsea.kristenhyman;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.io.IOException;
import java.util.List;

import edu.neu.madsea.kristenhyman.data.ProjectItemRecyclerViewAdapter;
import edu.neu.madsea.kristenhyman.data.ProjectRepository;
import edu.neu.madsea.kristenhyman.data.Project;
import edu.neu.madsea.kristenhyman.databinding.FragmentProjectListBinding;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 *  Adapted from Adrienne
 *  and https://blog.codavel.com/how-to-integrate-okhttp-on-an-android-project
 */
public class ProjectListFragment extends Fragment {

    private ProjectViewModel projectViewModel;
    private FragmentProjectListBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentProjectListBinding.inflate(inflater, container, false);
        ProjectRepository repository = ProjectRepository.getToDoRepository(binding.getRoot().getContext());
        LiveData<List<Project>> allProjects = repository.getAllProjects();


        binding.todoItemsRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));

        //create adapter
        ProjectItemRecyclerViewAdapter adapter = new ProjectItemRecyclerViewAdapter();

        // TODO: make sure repository.getAllProjects() is getting info from the API below
        // TODO: Where to implement the get request below to pull in the data? (test API)
        OkHttpClient client = new OkHttpClient();
        Request get = new Request.Builder()
                .url("https://reqres.in/api/users?page=2")
                .build();

        client.newCall(get).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                try {
                    ResponseBody responseBody = response.body();
                    if (!response.isSuccessful()) {
                        throw new IOException("Unexpected code " + response);
                    }

                    Log.i("data", responseBody.string());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //observe allProjects because that is the LiveData. (populate list)
        //so when the data changes we can send this to the adapter to make the change on the view

        allProjects.observe(getViewLifecycleOwner(), list -> adapter.submitList(list));



        // connecting the adapter and the recycler view so the data shows up
        binding.todoItemsRecyclerview.setAdapter(adapter);


        // Get an instance to the shared ViewModel
        // this must be the same between the activity and the layout
        projectViewModel = new ViewModelProvider(this).get(ProjectViewModel.class);
        /**
        binding.setViewmodel(projectViewModel);
        // finding the delete button
        ImageButton button = (ImageButton)findViewById(R.id.deleteTaskButton);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                projectViewModel.createProject();
            }
        });
         */

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}