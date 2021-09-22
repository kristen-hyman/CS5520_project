package edu.neu.madsea.kristenhyman.TwoActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY =
            "edu.neu.madsea.kristenhyman.TwoActivities.MainActivity.extra.MESSAGE";
    private EditText mReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mReply = findViewById(R.id.editText_second);

        // get the intent that created this activity
        Intent intent = getIntent();

        //Get the string containing the message from the Intent extras using the
        // MainActivity.EXTRA_MESSAGE static variable as the ke
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //Use findViewByID() to get a reference to the TextView for the message from the layout:
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);


    }

    public void returnReply(View view) {
        String reply = mReply.getText().toString();

        // create a new intent for the response—
        // don't reuse the Intent object that you received from the original request.
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);

        //Set the result to RESULT_OK to indicate that the response was successful.
        setResult(RESULT_OK,replyIntent);
        finish();
    }

}