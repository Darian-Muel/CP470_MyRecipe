package com.code.darinmuellerchen.myrecipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class FavouritesActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    int n = RecipeLists.favList.size();
    String[] s1 = new String[n];
    String s2[];

    ArrayList<String> ar = new ArrayList<String>();
    int images[] = {R.drawable.turkey_food,R.drawable.turkey_food,R.drawable.turkey_food,
            R.drawable.turkey_food,R.drawable.turkey_food,R.drawable.turkey_food};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);
        for (int i = 0; i < RecipeLists.favList.size();i++){
            Recipe recipe = RecipeLists.favList.get(i);

            s1[i] = recipe.getTitle().toString();

        }
        recyclerView = findViewById(R.id.recyclerViewFavourites);

        s1 = getResources().getStringArray(R.array.programming_languages);
        s2 = getResources().getStringArray(R.array.description);

        MyAdapter myAdapter = new MyAdapter( this, s1, s2, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}