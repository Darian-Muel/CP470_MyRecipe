package com.code.darinmuellerchen.myrecipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FavouritesActivity extends AppCompatActivity {
    private Button btnDelete;

    RecyclerView recyclerView;
    int n;//RecipeLists.favList.size();
    String[] s1;//new String[n];
    String[] s2;//new String[n];
    String[] s3;//new String[n];
    Bitmap[] images;//new Bitmap[n];
    private MyAdapter.RecyclerViewCLickListener listener;
    private MyAdapter myAdapter;

    private ArrayList<Recipe> favourites;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);



        prefs = getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString("Favourites", "");
        Type type = new TypeToken<List<Recipe>>(){}.getType();
        favourites = gson.fromJson(json, type);
        Log.i("TAG", "List obtained.");

        /*try {
            favourites = (ArrayList<Recipe>) ObjectSerializer.deserialize(prefs.getString("Favourites", ObjectSerializer.serialize(new ArrayList<Recipe>())));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

        /*for (int i = 0; i < RecipeLists.favList.size();i++){
            Recipe recipe = RecipeLists.favList.get(i);
            s1[i] = recipe.getTitle();
            s2[i] = recipe.getDescription();
            s3[i] = recipe.getIngredients();
            images[i] = recipe.getImageBitmap();


            //images[i] = R.drawable.turkey_food;
        }*/
        Log.i("TAG", "Breakpoint passed.");
        if (favourites != null) {
            Log.i("TAG", "Favourites not null.");
            n = favourites.size();
            s1 = new String[n];
            s2 = new String[n];
            s3 = new String[n];
            images = new Bitmap[n];

            for (int i = 0; i < n; i++) {
                Log.i("TAG", "Started iteration " + String.valueOf(i));
                Recipe recipe = favourites.get(i);
                Log.i("TAG", "Recipe obtained.");
                s1[i] = recipe.getTitle();
                Log.i("TAG", "Title obtained.");
                s2[i] = recipe.getDescription();
                Log.i("TAG", "Description obtained.");
                s3[i] = recipe.getIngredients();
                Log.i("TAG", "Ingredients obtained.");
                images[i] = null;//recipe.getImageBitmap();
                Log.i("TAG", "Image obtained.");
                Log.i("TAG", "Ended iteration " + String.valueOf(i));

                //images[i] = R.drawable.turkey_food;
            }
        } else {
            Log.i("TAG", "Favourites null.");
            n = RecipeLists.favList.size();
            s1 = new String[n];
            s2 = new String[n];
            s3 = new String[n];
            images = new Bitmap[n];

            for (int i = 0; i < n; i++) {
                Recipe recipe = RecipeLists.favList.get(i);
                s1[i] = recipe.getTitle();
                s2[i] = recipe.getDescription();
                s3[i] = recipe.getIngredients();
                images[i] = null;//recipe.getImageBitmap();


                //images[i] = R.drawable.turkey_food;
            }
        }

        Log.i("TAG", "n = " + String.valueOf(n));
        setAdapter();

    }

    private void setAdapter() {
        Log.i("TAG", "setAdapter started.");
        FavouritesOnClickListener();
        Log.i("TAG", "FavouritesOnClickListener call complete.");
        recyclerView = findViewById(R.id.recyclerViewFavourites);
        Log.i("TAG", "View found.");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Log.i("TAG", "LayoutManager set.");
        myAdapter = new MyAdapter( this, s1, s2, images, listener);
        Log.i("TAG", "Adapter created.");
        recyclerView.setAdapter(myAdapter);
        Log.i("TAG", "Adapter set to view.");

        Log.i("TAG", "setAdapter finished.");
    }

    private void FavouritesOnClickListener() {
        listener = new MyAdapter.RecyclerViewCLickListener() {



            @Override
            public void onClick(View v, int position) {

                Gson gson = new Gson();
                String json = prefs.getString("Favourites", "");
                Type type = new TypeToken<List<Recipe>>(){}.getType();
                favourites = gson.fromJson(json, type);

                // changed RecipeLists.favList -> favourites
                Intent intent = new Intent(getApplicationContext(), PopupActivity.class);
                intent.putExtra("Title", favourites.get(position).getTitle());
                intent.putExtra("Description", favourites.get(position).getDescription());
                /*try {
                    intent.putExtra("Picture", favourites.get(position).getImageBitmap());
                } catch (Exception e) {
                    Log.i("TAG", "Not locally saved image.");
                }*/
                intent.putExtra("Ingredients", favourites.get(position).getIngredients());
                startActivity(intent);
            }

            @Override
            public void onDeleteClick(int position) {

                Gson gson = new Gson();
                String json = prefs.getString("Favourites", "");
                Type type = new TypeToken<List<Recipe>>(){}.getType();
                favourites = gson.fromJson(json, type);

                // changed RecipeLists.favList -> favourites
                favourites.remove(position);
                Intent intent = new Intent(FavouritesActivity.this, FavouritesActivity.class);
                startActivity(intent);
            }
        };
    }
} 