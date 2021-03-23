package edu.gcit.todo_5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "edu.gcit.todo_4_message";
    public static final int TEXT_REQUEST = 1;
    private EditText nmessageEditText;
    private TextView nDisplayHeader;
    private TextView nReplyDisplay;
    private static final String LOG_TAG = MainActivity2.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nmessageEditText = findViewById(R.id.editTextMessage1);
        nDisplayHeader = findViewById(R.id.replyReceivedMainactivity);
        nReplyDisplay = findViewById(R.id.textDisplayin1);
    }

    public void send(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        String message = nmessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                String reply = data.getStringExtra(MainActivity2.EXTRA_REPLY);
                nDisplayHeader.setVisibility(View.VISIBLE);
                nReplyDisplay.setText(reply);
                nReplyDisplay.setVisibility(View.VISIBLE);
            }
        }
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