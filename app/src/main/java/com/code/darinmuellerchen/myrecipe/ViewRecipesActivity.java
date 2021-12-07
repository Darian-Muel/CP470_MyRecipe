package com.code.darinmuellerchen.myrecipe;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewRecipesActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "ViewRecipesActivity";
    private Button btnFavourites;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.type_select_page);
        btnFavourites = findViewById(R.id.btnFavourites);
        btnFavourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewRecipesActivity.this, FavouritesActivity.class);
                startActivity(intent);
            }
        });
    }
}
