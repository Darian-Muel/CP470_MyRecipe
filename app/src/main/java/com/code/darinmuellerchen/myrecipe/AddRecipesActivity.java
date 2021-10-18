package com.code.darinmuellerchen.myrecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AddRecipesActivity extends AppCompatActivity {
    private Button createReciepe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipes);
        createReciepe = findViewById(R.id.btnCreateRecipe);

        createReciepe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(),"Recipe Created", Toast.LENGTH_LONG);
                toast.show();

            }
        });
    }
}