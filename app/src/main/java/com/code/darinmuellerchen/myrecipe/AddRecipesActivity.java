package com.code.darinmuellerchen.myrecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class AddRecipesActivity extends AppCompatActivity {
    private Button createReciepe;
    private EditText getTitle;
    private EditText getDescription;
    private EditText getIngredients;
    private CheckBox cbFav;
    private CheckBox cbBreakfast;
    private CheckBox cbLunch;
    private CheckBox cbDinner;
    private CheckBox cbOther;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipes);
        createReciepe = findViewById(R.id.btnCreateRecipe);
        getTitle = findViewById(R.id.EditTextGetTitle);
        getDescription = findViewById(R.id.EditTextGetDescription);
        getIngredients = findViewById(R.id.EditTextGetIngredients);
        cbFav = findViewById(R.id.checkBoxFavourites);
        cbBreakfast = findViewById(R.id.checkBoxBreakFast);
        cbLunch = findViewById(R.id.checkBoxLunch);
        cbDinner = findViewById(R.id.checkBoxDinner);
        cbOther = findViewById(R.id.checkBoxOther);

        createReciepe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = getTitle.getText().toString();
                String description = getDescription.getText().toString();
                String ingredients = getIngredients.getText().toString();
                //new Recipe(title,description,ingredients,fav,breakfast,lunch,dinner,other);
                Recipe recipe = new Recipe(title,description,ingredients);
                if (cbFav.isChecked()) {
                    RecipeLists.favList.add(recipe);
                }
                if (cbBreakfast.isChecked()){
                    RecipeLists.breakfastList.add(recipe);
                }
                if (cbLunch.isChecked()){
                    RecipeLists.lunchList.add(recipe);
                }
                if (cbDinner.isChecked()){
                    RecipeLists.dinnerList.add(recipe);
                }
                if (cbOther.isChecked()){
                    RecipeLists.otherList.add(recipe);
                }
                Toast toast = Toast.makeText(getApplicationContext(),title + " created", Toast.LENGTH_LONG);
                toast.show();

            }
        });
    }
}