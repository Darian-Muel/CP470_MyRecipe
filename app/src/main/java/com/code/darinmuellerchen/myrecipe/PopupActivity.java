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

    String data1, data2;
    int myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        food_picture = findViewById(R.id.food_picture);
        food_title = findViewById(R.id.food_title);
        food_description = findViewById(R.id.food_description);

        getData();
        setData();

    }

    private void getData(){
        if(getIntent().hasExtra("myImage") && getIntent().hasExtra("data1") && getIntent().hasExtra("data2")){
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            myImage = getIntent().getIntExtra("myImage", 1);
        }else{
            Toast.makeText(this,"No Data. ", Toast.LENGTH_SHORT).show();
        }
    }
    private void setData(){
        food_title.setText(data1);
        food_description.setText(data2);
        food_picture.setImageResource((myImage));
    }
}