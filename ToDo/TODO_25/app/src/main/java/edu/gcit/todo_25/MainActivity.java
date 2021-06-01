package edu.gcit.todo_25;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper myDb;
    EditText editName, editSurname, editMarks, editID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);
        editName = findViewById(R.id.stdName);
        editSurname = findViewById(R.id.stdLName);
        editMarks = findViewById(R.id.stdMarks);
        editID = findViewById(R.id.stdId);
    }

    public void addData(View view) {
        boolean isInserted = myDb.insertData(editID.getText().toString(),
        editName.getText().toString(),
        editSurname.getText().toString(),
        editMarks.getText().toString());
        if (isInserted==true){
            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(MainActivity.this, "Data not inserted", Toast.LENGTH_LONG).show();
        }
    }

    public void viewData(View view) {
        Cursor res = myDb.getAllData();
        if (res.getCount()==0){
            showMessage("Error", "Nothing Found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()){
            buffer.append("Student ID: "+ res.getString(0)+"\n");
            buffer.append("First Name: "+ res.getString(1)+"\n");
            buffer.append("Last Name: "+ res.getString(2)+"\n");
            buffer.append("ITW202: "+ res.getString(3)+"\n\n");
        }

        showMessage("List of Students ", buffer.toString());
    }

    public void showMessage(String title, String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();

    }
    public void updataData(View view) {
        boolean isUpdate = myDb.updateData(editID.getText().toString(),
                editName.getText().toString(),
                editSurname.getText().toString(),
                editMarks.getText().toString());

        if (isUpdate==true){
            Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(MainActivity.this, "Data not updated!", Toast.LENGTH_LONG).show();
        }
    }

    public void deleteData(View view) {
        Integer deletedRows = myDb.deleteData(editID.getText().toString());
        if (deletedRows>0){
            Toast.makeText(MainActivity.this, "Data deleted", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(MainActivity.this, "Data not deleted", Toast.LENGTH_LONG).show();
        }
    }
}