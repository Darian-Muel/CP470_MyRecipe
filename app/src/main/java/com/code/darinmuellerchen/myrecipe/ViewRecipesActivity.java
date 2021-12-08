package com.code.darinmuellerchen.myrecipe;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.LuhnChecksumValidator;
import android.view.View;
import android.widget.Button;

public class ViewRecipesActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "ViewRecipesActivity";
    private Button btnFavourites;
    private Button btnBreakfast;
    private Button btnLunch;
    private Button btnDinner;
    private Button btnOther;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.type_select_page);
        btnFavourites = findViewById(R.id.btnFavourites);
        btnBreakfast = findViewById(R.id.btnBreakFast);
        btnLunch = findViewById(R.id.btnLunch);
        btnDinner = findViewById(R.id.btnDinner);
        btnOther = findViewById(R.id.btnOther);
        btnFavourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewRecipesActivity.this, FavouritesActivity.class);
                startActivity(intent);
            }
        });
        btnBreakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewRecipesActivity.this, BreakfastActivity.class);
                startActivity(intent);
            }
        });
        btnLunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewRecipesActivity.this, LunchActivity.class);
                startActivity(intent);
            }
        });
    }
}
