package lk.sliiti.eatscmb.database.data;

import java.util.ArrayList;

import lk.sliiti.eatscmb.R;
import lk.sliiti.eatscmb.database.model.Restaurant;

public class RestaurantData {
    private static ArrayList<Restaurant> restaurantArrayList = new ArrayList<>();
    private static Boolean alreadySet = false;


    public static ArrayList<Restaurant> getRestaurants(){
        while (!alreadySet){
            initialiseList();
            alreadySet = true;
        }
        return restaurantArrayList;
    }

    private static void initialiseList(){
        restaurantArrayList.add(new Restaurant(1,"McDonald's","Rajagiriya","10-15 mins", R.drawable.mcdonalds_big_mac_fries_1));
        restaurantArrayList.add(new Restaurant(2,"KFC","Rajagiriya","15-25 mins", R.drawable.kfc_review));
        restaurantArrayList.add(new Restaurant(3,"Popeyes","Wellawatte","40 mins", R.drawable.popeyes_restaurant));
        restaurantArrayList.add(new Restaurant(4,"Burger King","Rajagiriya","10 mins", R.drawable.burgerking_restaurant));
        restaurantArrayList.add(new Restaurant(5,"Pizza Hut","Rajagiriya","12 mins", R.drawable.pizzahut_restaurant));
        restaurantArrayList.add(new Restaurant(6,"Domino's Pizza","Rajagiriya","14 mins", R.drawable.dominos_restaurant));
        restaurantArrayList.add(new Restaurant(7,"Subway","Rajagiriya","11 mins", R.drawable.subway_restaurant));
        restaurantArrayList.add(new Restaurant(8,"Taco Bell","Colombo 07","20 mins", R.drawable.tacobell_restaurant));
        restaurantArrayList.add(new Restaurant(9,"Starbucks","Bambalapitiya","30 mins", R.drawable.starbucks_restaurent));
        restaurantArrayList.add(new Restaurant(10,"Dunkin Donuts","Kollupitiya","12 mins", R.drawable.dunkindonuts_restaurant));

    }

    public Restaurant getRestaurant(int id){
        return restaurantArrayList.get(id);
    }

    public int size(){
        return restaurantArrayList.size();
    }

    public void add(Restaurant restaurant){
        int index = size()+1;
        restaurantArrayList.add(index,restaurant);
    }


}
