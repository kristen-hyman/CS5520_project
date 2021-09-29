package edu.neu.madsea.kristenhyman.ToDoApp3;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Add a public constant to define the key for type of response you're interested in:
    public static final int TEXT_REQUEST = 1;

    //Add  variables to hold the task list
    ArrayAdapter adapter;
    ListView listView;
    ArrayList<String> taskList;

    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();

    public static final String EXTRA_MESSAGE =
            "edu.neu.madsea.kristenhyman.TwoActivities.MainActivity.extra.MESSAGE";
    private EditText mMessageEditText;
    private ActivityResultLauncher<Intent> launchSecondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listView);
        taskList = new ArrayList<>();

    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, AddNewTask.class);
        startActivityForResult(intent, TEXT_REQUEST);

    }

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String task =
                        data.getStringExtra(AddNewTask.EXTRA_REPLY);

                taskList.add(task);
                adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_checked, taskList);
                listView.setAdapter(adapter);
                listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

            }
        }
    }
}