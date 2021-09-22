package edu.neu.madsea.kristenhyman.TwoActivities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Add a public constant to define the key for type of response you're interested in:
    public static final int TEXT_REQUEST = 1;

    //Add two private variables to hold the reply header and reply TextView elements:
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;

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
        mMessageEditText = findViewById(R.id.editText_main);
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, SecondActivity.class);

        // get the text from the EditText as a string
        String message = mMessageEditText.getText().toString();

        // Add that string to the Intent as an extra with the EXTRA_MESSAGE
        // constant as the key and the string as the value:
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);

    }

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply =
                        data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }
}