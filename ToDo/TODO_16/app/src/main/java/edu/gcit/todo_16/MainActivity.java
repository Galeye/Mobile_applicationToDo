package edu.gcit.todo_16;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private Adapter mAdapter;
    private RecyclerView mRecyclerView;
    private final LinkedList<String> mWOrdList = new LinkedList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //adding data
        for (int i=0;i<20; i++){
            mWOrdList.addLast("Word" +i);
        }

        mRecyclerView = findViewById(R.id.recycleview);
        wordListAdapter mAdapter = new wordListAdapter(this, mWOrdList);
        mRecyclerView.setAdapter(mAdapter);

        LinearLayoutManager obj = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(obj);

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wordListSize = mWOrdList.size();
                //add a new word to the word list
                mWOrdList.addLast("Word" + wordListSize);
                //Notify the adapter that the data has changed
                mRecyclerView.getAdapter().notifyItemInserted(wordListSize);
                //scroll to the bottom
                mRecyclerView.smoothScrollToPosition(wordListSize);
            }
        });
    }
}