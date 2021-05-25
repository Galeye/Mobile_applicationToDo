package edu.gcit.todo_21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mText = findViewById(R.id.text1);

    }

    public void startTask(View view) {
        mText.setText("Sleeping...");
        new SimpleAsyncTask(mText).execute();//to run the bg task
    }
}