package lk.sliiti.eatscmb.database.model;
public class Restaurant {
    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public int getRestaurantPhoto() {
        return restaurantPhoto;
    }

    public void setRestaurantPhoto(int restaurantPhoto) {
        this.restaurantPhoto = restaurantPhoto;
    }

    int restaurantID;
    String restaurantName;
    String location;
    String distance;
    int restaurantPhoto;

    public Restaurant(int restaurantID, String restaurantName, String location, String distance, int restaurantPhoto) {
        this.restaurantID = restaurantID;
        this.restaurantName = restaurantName;
        this.location = location;
        this.distance = distance;
        this.restaurantPhoto = restaurantPhoto;
    }
}
