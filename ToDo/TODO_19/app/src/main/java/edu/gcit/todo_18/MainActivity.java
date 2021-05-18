package edu.gcit.todo_18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private SportsAdapter mAdapter;
    private ArrayList<Sport> mSportData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));

        //initialize the layout manager
        mSportData = new ArrayList<>();

        mAdapter = new SportsAdapter(this, mSportData);
        mRecyclerView.setAdapter(mAdapter);

        //get the data
        initializeData();

    }

    private void initializeData() {
        TypedArray sportsImageResources = getResources().obtainTypedArray(R.array.sportsImage);
        String[] sportsList = getResources().getStringArray(R.array.SportsTitle);
        String[] sportsInfo = getResources().getStringArray(R.array.SportInfo);

        //clear the existing data(to avoid duplication)
        mSportData.clear();

        //create the arraylist of sports objects with the titles and info about each sport
        for (int i=0; i<sportsList.length;i++){

            mSportData.add(new Sport(sportsList[i], sportsInfo[i], sportsImageResources.getResourceId(i, 1)));
        }

        //Notify the adapter of the change
        mAdapter.notifyDataSetChanged();
        sportsImageResources.recycle();
    }

}