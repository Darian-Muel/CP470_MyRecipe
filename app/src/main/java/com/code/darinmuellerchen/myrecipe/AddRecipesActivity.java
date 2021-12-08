package com.code.darinmuellerchen.myrecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
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
    private ImageButton btnTakePic;
    private Bitmap imageBitmap;


    protected static final String ACTIVITY_NAME = "AddRecipesActivity";
    private static final int REQUEST_IMAGE_CAPTURE = 1;


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
        btnTakePic = findViewById(R.id.imgBtnTakePic);


        final Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        btnTakePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePic(takePictureIntent);
            }
        });

        createReciepe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = getTitle.getText().toString();
                String description = getDescription.getText().toString();
                String ingredients = getIngredients.getText().toString();
                //new Recipe(title,description,ingredients,fav,breakfast,lunch,dinner,other);
                Recipe recipe = new Recipe(title,description,ingredients, imageBitmap);
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

    public void onBackPressed() {

        super.onBackPressed();

        setResult(Activity.RESULT_CANCELED);

        finish();

    }

    @Override
    protected void onActivityResult(int requestCode, int responseCode, Intent data) {
        super.onActivityResult(requestCode, responseCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && responseCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            btnTakePic.setImageBitmap(imageBitmap);
        }
    }
    private void takePic(Intent takePicIntent) {
        try {
            startActivityForResult(takePicIntent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e) {
            Log.e(ACTIVITY_NAME, "Failed to open camera.");
        }
    }
}