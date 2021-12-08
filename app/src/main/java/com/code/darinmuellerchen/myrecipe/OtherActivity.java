package com.code.darinmuellerchen.myrecipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OtherActivity extends AppCompatActivity {


    private Button btnDelete;

    RecyclerView recyclerView;
    int n = RecipeLists.otherList.size();
    String[] s1 = new String[n];
    String[] s2 = new String[n];
    String[] s3 = new String[n];
    Bitmap[] images = new Bitmap[n];
    private MyAdapter.RecyclerViewCLickListener listener;
    private MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);


        for (int i = 0; i < RecipeLists.otherList.size();i++){
            Recipe recipe = RecipeLists.otherList.get(i);
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
                intent.putExtra("Title", RecipeLists.otherList.get(position).getTitle());
                intent.putExtra("Description", RecipeLists.otherList.get(position).getDescription());
                intent.putExtra("Picture", RecipeLists.otherList.get(position).getImageBitmap());
                intent.putExtra("Ingredients", RecipeLists.otherList.get(position).getIngredients());
                startActivity(intent);
            }

            @Override
            public void onDeleteClick(int position) {
                RecipeLists.otherList.remove(position);
                Intent intent = new Intent(OtherActivity.this, OtherActivity.class);
                startActivity(intent);
            }
        };
    }
}