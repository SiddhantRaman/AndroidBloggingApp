package com.example.ramansid.myapp1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.text.TextUtils;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

public class BlogActivity extends AppCompatActivity{
    // imports
    private ImageButton imageButton;
    private static final int GALLERY_REQUEST_CODE = 2;
    private EditText postTitle;
    private EditText postDesc;
    private BottomNavigationView navigationBlog;
    private Uri uri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        postTitle = (EditText) findViewById(R.id.postTitle1);
        postDesc = (EditText) findViewById(R.id.postDesc1);
        imageButton = (ImageButton) findViewById(R.id.imageButton1);
        navigationBlog = (BottomNavigationView) findViewById(R.id.navigationBlog);

        //picking image from the gallery
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, GALLERY_REQUEST_CODE);
            }
        });

        // Navigation Bar Activity Handler
        navigationBlog.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                Fragment frag = null;
                switch(item.getItemId()) {
                    // postAction option accessed
                    case R.id.postAction:
                        final String title = postTitle.getText().toString().trim();
                        final String desc = postDesc.getText().toString().trim();
                        if(!TextUtils.isEmpty(title) && !TextUtils.isEmpty(desc))
                        {
                            Toast.makeText(BlogActivity.this, "POSTING...", Toast.LENGTH_LONG).show();
                        }
                        else if(TextUtils.isEmpty(title))
                        {
                            Toast.makeText(BlogActivity.this, "Title Required", Toast.LENGTH_LONG).show();
                        }
                        else if(TextUtils.isEmpty(desc))
                        {
                            Toast.makeText(BlogActivity.this, "Write Something", Toast.LENGTH_LONG).show();
                        }
                        break;
                        // Save option accessed
                    case R.id.saveAction:
                        Toast.makeText(BlogActivity.this, "Saving...", Toast.LENGTH_LONG).show();
                        break;
                        // Back to Home Screen
                    case R.id.homeAction:
                        Intent intentMain = new Intent(BlogActivity.this, MainActivity.class);
                        startActivity(intentMain);
                        break;
                }
                return true;
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //image from gallery result
        if (requestCode == GALLERY_REQUEST_CODE && resultCode == RESULT_OK){
            uri = data.getData();
            imageButton.setImageURI(uri);
        }
    }
}
