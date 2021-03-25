package edu.gcit.todo_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    public static final String EXTRA_REPLY = "edu.gcit.todo_4_message";
    private TextView mText;
    private EditText nReply;
    private static final String LOG_TAG = MainActivity2.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        nReply = findViewById(R.id.editTextMessage2);
        Intent intent = getIntent();
        mText = findViewById(R.id.textDisplayin2);
        String message = intent.getStringExtra(edu.gcit.todo_6.MainActivity.EXTRA_MESSAGE);
        mText.setText(message);
    }

    public void reply(View view) {
        String message = nReply.getText().toString();
        Intent intent = new Intent();
        intent.putExtra(EXTRA_REPLY,message);
        setResult(RESULT_OK,intent);
        finish();
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG,"onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG,"onRestart");
    }
}