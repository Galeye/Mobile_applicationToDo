package edu.gcit.todo_22ii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mBookInput;
    private TextView mTitleText;
    private TextView mAuthorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBookInput = findViewById(R.id.bookInput);
        mTitleText = findViewById(R.id.titleText);
        mAuthorText = findViewById(R.id.authorText);
    }

    public void searchBooks(View view) {
        String queryString = mBookInput.getText().toString();
        new fetchBook(mTitleText, mAuthorText).execute(queryString);
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if(connMgr!=null){
            networkInfo= connMgr.getActiveNetworkInfo();
        }
        if(networkInfo != null && networkInfo.isConnected() && queryString.length()!=0){
            new fetchBook(mTitleText, mAuthorText).execute(queryString);
            mAuthorText.setText(" ");
            mTitleText.setText("Loading...");
        }
        else{
           if(queryString.length()==0){
               mAuthorText.setText(" ");
               mTitleText.setText("No search Term");
           }
           else{
               mAuthorText.setText(" ");
               mTitleText.setText("No network");
           }

        }
    }
}