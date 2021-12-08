package com.code.darinmuellerchen.myrecipe;

import android.graphics.Bitmap;

public class Recipe {
    private String title;
    private String description;
    private String ingredients;
    private Bitmap imageBitmap;

    //recipe object creator
    public Recipe(String title, String description, String ingredients, Bitmap imageBitmap){
        this.title = title;
        this.description = description;
        this.ingredients = ingredients;
        this.imageBitmap = imageBitmap;
    }

    public String getTitle() {
        return this.title.toString();
    }

    public String getDescription() {
        return this.description.toString();
    }

    public String getIngredients() {
        return ingredients;
    }

    public Bitmap getImageBitmap() {
        return imageBitmap;
    }
}
