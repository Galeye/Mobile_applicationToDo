package edu.gcit.todo_15;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tabt1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tabt2));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tabt3));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        ViewPager viewPager = findViewById(R.id.viewpager);
        pagerAdapter adapter = new pagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
}