package com.code.darinmuellerchen.myrecipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class FavouritesActivity extends AppCompatActivity {
    private Button btnDelete;

    RecyclerView recyclerView;
    int n = RecipeLists.favList.size();
    String[] s1 = new String[n];
    String[] s2 = new String[n];
    Bitmap[] images = new Bitmap[n];
    private MyAdapter.RecyclerViewCLickListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);


        for (int i = 0; i < RecipeLists.favList.size();i++){
            Recipe recipe = RecipeLists.favList.get(i);
            s1[i] = recipe.getTitle();
            s2[i] = recipe.getDescription();
            images[i] = recipe.getImageBitmap();


            //images[i] = R.drawable.turkey_food;
        }

        setAdapter();

    }

    private void setAdapter() {
        setOnClickListener();
        recyclerView = findViewById(R.id.recyclerViewFavourites);
        MyAdapter myAdapter = new MyAdapter( this, s1, s2, images, listener);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setOnClickListener() {
        listener = new MyAdapter.RecyclerViewCLickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), PopupActivity.class);
                intent.putExtra("Title", RecipeLists.favList.get(position).getTitle());
                intent.putExtra("Description", RecipeLists.favList.get(position).getDescription());
                intent.putExtra("Picture", RecipeLists.favList.get(position).getImageBitmap());
                startActivity(intent);
            }
        };
    }
} 