package com.code.darinmuellerchen.myrecipe;

public class Recipe {
    private String title;
    private String description;
    private String ingredients;
    private int photo;


    //recipe object creator
    public Recipe(String title, String description, String ingredients){
        this.title = title;
        this.description = description;
        this.ingredients = ingredients;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getIngredients() {
        return ingredients;
    }
}
