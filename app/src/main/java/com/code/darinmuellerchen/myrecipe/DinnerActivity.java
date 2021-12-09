package com.code.darinmuellerchen.myrecipe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DinnerActivity extends AppCompatActivity {

    private Button btnDelete;
    BottomNavigationView bottomNavigationView;

    RecyclerView recyclerView;
    int n = RecipeLists.dinnerList.size();
    String[] s1 = new String[n];
    String[] s2 = new String[n];
    String[] s3 = new String[n];
    Bitmap[] images = new Bitmap[n];
    private MyAdapter.RecyclerViewCLickListener listener;
    private MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner);

        bottomNavigationView = findViewById(R.id.bottom_navigator);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.create_navbar:
                        startActivity(new Intent(getApplicationContext(), AddRecipesActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home_navbar:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.help_navbar:
                        startActivity(new Intent(getApplicationContext(), HelpActivity.class));
                        overridePendingTransition(0,0);
                }
                return false;
            }
        });

        for (int i = 0; i < RecipeLists.dinnerList.size();i++){
            Recipe recipe = RecipeLists.dinnerList.get(i);
            s1[i] = recipe.getTitle();
            s2[i] = recipe.getDescription();
            s3[i] = recipe.getIngredients();
            images[i] = recipe.getImageBitmap();


            //images[i] = R.drawable.turkey_food;
        }

        setAdapter();

    }

    private void setAdapter() {

        FavouritesOnClickListener();
        recyclerView = findViewById(R.id.recyclerViewFavourites);
        myAdapter = new MyAdapter( this, s1, images, listener);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void FavouritesOnClickListener() {
        listener = new MyAdapter.RecyclerViewCLickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), PopupActivity.class);
                intent.putExtra("Title", RecipeLists.dinnerList.get(position).getTitle());
                intent.putExtra("Description", RecipeLists.dinnerList.get(position).getDescription());
                intent.putExtra("Picture", RecipeLists.dinnerList.get(position).getImageBitmap());
                intent.putExtra("Ingredients", RecipeLists.dinnerList.get(position).getIngredients());
                startActivity(intent);
            }

            @Override
            public void onDeleteClick(int position) {
                RecipeLists.dinnerList.remove(position);
                Intent intent = new Intent(DinnerActivity.this, DinnerActivity.class);
                startActivity(intent);
            }
        };
    }
}
