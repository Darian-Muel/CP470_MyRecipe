public class Recipe {
    private String title;
    private String description;
    private String ingredients;
    private String type;
    private int photo;

    //recipe object creator
    public Recipe(String title, String description, String ingredients,String type, int photo){
        this.title = title;
        this.description = description;
        this.ingredients = ingredients;
        this.type = type;
        this.photo = photo;
    }
    public String getTitle(){
        return title;
    }

    public String getDescription() {
        return description;
    }
    public String getIngredients(){
        return ingredients;
    }

    public String getType() {
        return type;
    }

    public int getPhoto() {
        return photo;
    }
}
