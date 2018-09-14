package com.example.ramansid.myapp1;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    // imports
    private BottomNavigationView mBottomNavigation;

    //myBlogs =(Button)findViewById(R.id.myBlogs);
    //browseBlogs =(Button)findViewById(R.id.browseBlogs);

    public void ActivityInit(){
        mBottomNavigation = (BottomNavigationView)findViewById(R.id.navigationView);
        mBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                Fragment frag = null;
                switch(item.getItemId()) {
                    case R.id.startNewBlog:
                        Intent intentBlog = new Intent(MainActivity.this, BlogActivity.class);
                        startActivity(intentBlog);
                        break;
                    case R.id.browseBlogs:
                        Intent intentBrowse = new Intent(MainActivity.this, BrowseActivity.class);
                        startActivity(intentBrowse);
                        break;
                }
                return true;
    }
    });
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityInit();
    }
}
