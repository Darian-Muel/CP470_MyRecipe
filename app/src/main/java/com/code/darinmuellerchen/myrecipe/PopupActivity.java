package com.code.darinmuellerchen.myrecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PopupActivity extends AppCompatActivity {
    ImageView food_picture;
    TextView food_title, food_description;

    String title, description;
    int myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        food_picture = findViewById(R.id.food_picture);
        food_title = findViewById(R.id.food_title);
        food_description = findViewById(R.id.food_description);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            title = extras.getString("Title");
        }
        food_title.setText(title);



    }


}