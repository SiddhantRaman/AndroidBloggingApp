package com.example.ramansid.myapp1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.text.TextUtils;

public class MainActivity extends AppCompatActivity {
    // imports
    public Button writeBlog;
    //public Button myBlogs;
    //public Button browseBlogs;


    //myBlogs =(Button)findViewById(R.id.myBlogs);
    //browseBlogs =(Button)findViewById(R.id.browseBlogs);

    public void blogActivityInit(){
        writeBlog =findViewById(R.id.startBlog);
        writeBlog.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
            Intent intent = new Intent(MainActivity.this, BlogActivity.class);
            startActivity(intent);
    }
    });
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        blogActivityInit();
    }
}
