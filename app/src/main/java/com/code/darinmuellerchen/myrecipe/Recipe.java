package com.code.darinmuellerchen.myrecipe;

public class Recipe {
    private String title;
    private String description;
    private String ingredients;

    //recipe object creator
    public Recipe(String title, String description, String ingredients){
        this.title = title;
        this.description = description;
        this.ingredients = ingredients;
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
}
