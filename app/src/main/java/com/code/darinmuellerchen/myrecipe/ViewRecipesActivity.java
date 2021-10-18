package com.code.darinmuellerchen.myrecipe;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ViewRecipesActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "ViewRecipesActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.type_select_page);
    }
}
