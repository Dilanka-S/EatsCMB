package lk.sliiti.eatscmb.database.model;

public class FoodItem {
    public FoodItem(int foodID, String foodName, int restaurantID, String restaurant, int price, String description, int foodPhoto) {
        this.foodID = foodID;
        this.foodName = foodName;
        this.restaurantID = restaurantID;
        this.restaurant = restaurant;
        this.price = price;
        this.description = description;
        this.foodPhoto = foodPhoto;
    }

    int foodID;
    String foodName;
    int restaurantID;
    String restaurant;
    int price;
    String description;
    int foodPhoto;

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFoodPhoto() {
        return foodPhoto;
    }

    public void setFoodPhoto(int foodPhoto) {
        this.foodPhoto = foodPhoto;
    }
}
