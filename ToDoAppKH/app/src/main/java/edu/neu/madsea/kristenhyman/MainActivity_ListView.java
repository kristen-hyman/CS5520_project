package edu.neu.madsea.kristenhyman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import edu.neu.madsea.kristenhyman.data.ToDoItemRecyclerViewAdapter;
import edu.neu.madsea.kristenhyman.databinding.ActivityMainListViewBinding;
/**
 * adapted from Adrienne
 * https://github.com/ahope/cs5520_project/blob/main/todo-list/app/src/main/java/edu/northeastern/cs5520/todo_adrienne
 */
public class MainActivity_ListView extends AppCompatActivity {

    private ActivityMainListViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // This is what we would do if we weren't using the ViewBinding (as we see below)
//        setContentView(R.layout.activity_main_list_view);

        // Use the ViewBinding instead of the layout directly
        binding = ActivityMainListViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.recyclerViewMain.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerViewMain.scrollToPosition(0);
        binding.recyclerViewMain.setAdapter(new ToDoItemRecyclerViewAdapter());

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity_ListView.this, NewToDoActivity.class);
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


}