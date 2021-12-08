package com.code.darinmuellerchen.myrecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
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
    TextView food_title, food_description, food_ingredients;

    String title, description, ingredients;
    Bitmap myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        food_picture = findViewById(R.id.food_picture);
        food_title = findViewById(R.id.food_title);
        food_description = findViewById(R.id.food_description);
        food_ingredients = findViewById(R.id.food_ingredients);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            title = extras.getString("Title");
            description = extras.getString("Description");
            ingredients = extras.getString("Ingredients");
            myImage = extras.getParcelable("Picture");


        }
        food_title.setText(title);
        food_description.setText(description);
        food_picture.setImageBitmap(myImage);
        food_ingredients.setText(ingredients);




    }


}