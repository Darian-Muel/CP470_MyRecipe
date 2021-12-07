package com.code.darinmuellerchen.myrecipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
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
    int[] images = new int[n];

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);
        btnDelete = findViewById(R.id.btn_delete);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        for (int i = 0; i < RecipeLists.favList.size();i++){
            Recipe recipe = RecipeLists.favList.get(i);
            s1[i] = recipe.getTitle();
            s2[i] = recipe.getDescription();
            images[i] = R.drawable.turkey_food;
        }
        recyclerView = findViewById(R.id.recyclerViewFavourites);

        MyAdapter myAdapter = new MyAdapter( this, s1, s2, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
} 