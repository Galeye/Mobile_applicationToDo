package edu.gcit.todo_8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText openWeb;
    private EditText openLtn;
    private EditText shareTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openWeb = findViewById(R.id.editTexthost);
        openLtn = findViewById(R.id.editTextlocation);
        shareTxt = findViewById(R.id.editTextshare);

    }

    public void openWebsite(View view) {
        String msg = openWeb.getText().toString();
        Uri uri = Uri.parse(msg);
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
        else{
            Log.d("implicit", "An error occured");
        }


    }

    public void openLocation(View view) {
        String msg = openLtn.getText().toString();
        Uri uri = Uri.parse("geo:0,0?q="+msg);
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
        else{
            Log.d("implicit", "An error occured");
        }
    }

    public void shareText(View view) {
        String msg = shareTxt.getText().toString();
//        Uri uri = Uri.parse(msg);
//        Intent intent = new Intent(Intent.ACTION_SEND, uri);
//        if (intent.resolveActivity(getPackageManager())!=null){
//            startActivity(intent);
//        }
//        else{
//            Log.d("implicit", "An error occured");
//        }

        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setText(msg)
                .setChooserTitle("Share this text with: ")
                .startChooser();
    }
}