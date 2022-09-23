package lk.sliiti.eatscmb.database.data;

import android.util.Log;

import java.util.ArrayList;

import lk.sliiti.eatscmb.R;
import lk.sliiti.eatscmb.database.model.FoodItem;
import lk.sliiti.eatscmb.database.model.Restaurant;
import lk.sliiti.eatscmb.database.model.User;

public class FoodItemData {
    private static ArrayList<FoodItem> foodItemArrayList = new ArrayList<>();
    private static Boolean alreadySet = false;


    public static ArrayList<FoodItem> getFoodItemArrayList() {
        return foodItemArrayList;
    }

    public static void getFoodItems(){
        while(!alreadySet){
            initializeList();
            alreadySet=true;
        }

        //return foodItemArrayList;
    }

    private static void initializeList(){
        foodItemArrayList.add(new FoodItem(2001,"French Fries",1,
                "Mc Donald's",320,"Salted French Fries fried to perfection",
                R.drawable.mcdonald_frenchfries));
        foodItemArrayList.add(new FoodItem(2002,"Spicy Sandwich",3,
                "Popeyes",1200,"Crispy Fried Chicken with spicy seasoning on a glorious sandwich",
                R.drawable.popeyes_spicy_sandwich));
        foodItemArrayList.add(new FoodItem(2003,"Big Mac",1,
                "Mc Donald's",1350,"The perfect burger with two meat patties and a crunchy vege dressing",
                R.drawable.mcdonalds_big_mac_fries));
        foodItemArrayList.add(new FoodItem(2004,"Chicken Bucket",2,
                "KFC",3450,"12 Pieces of Colonel's special recipe Fried Chicken",
                R.drawable.kfc_chicken_bucket));
        foodItemArrayList.add(new FoodItem(2005,"Chicken Strips",3,
                "Popeyes",1400,"Crispy Fried Chicken with spicy seasoning on a glorious sandwich",
                R.drawable.popeyes_chicken_strips));
        foodItemArrayList.add(new FoodItem(2006,"French Fries",4,
                "Burgher King",320,"Salted French Fries fried to perfection",
                R.drawable.mcdonald_frenchfries));
        foodItemArrayList.add(new FoodItem(2007,"French Fries",5,
                "Pizza Hut",320,"Salted French Fries fried to perfection",
                R.drawable.mcdonald_frenchfries));
        foodItemArrayList.add(new FoodItem(2008,"French Fries",6,
                "Domino's Pizza",320,"Salted French Fries fried to perfection",
                R.drawable.mcdonald_frenchfries));
        foodItemArrayList.add(new FoodItem(2009,"French Fries",7,
                "Subway",320,"Salted French Fries fried to perfection",
                R.drawable.mcdonald_frenchfries));
        foodItemArrayList.add(new FoodItem(2010,"French Fries",8,
                "Taco Bell",320,"Salted French Fries fried to perfection",
                R.drawable.mcdonald_frenchfries));
        foodItemArrayList.add(new FoodItem(2011,"French Fries",9,
                "Starbucks",320,"Salted French Fries fried to perfection",
                R.drawable.mcdonald_frenchfries));
        foodItemArrayList.add(new FoodItem(2012,"French Fries",10,
                "Dunkin Donuts",320,"Salted French Fries fried to perfection",
                R.drawable.mcdonald_frenchfries));
        addCocaCola();

    }
    public static FoodItem getFoodItem(int id){
        FoodItem foodItem = null;
        for (int i = 0; i < foodItemArrayList.size(); i++) {
            if (id == foodItemArrayList.get(i).getFoodID()){
                foodItem = foodItemArrayList.get(i);
            }
        }
        return foodItem;
    }

    public int size(){
        return foodItemArrayList.size();
    }
    public void add(FoodItem foodItem){
        int index = size()+1;
        foodItemArrayList.add(index,foodItem);
    }
    public static ArrayList<FoodItem> getPicksOfTheDay(){
        ArrayList<FoodItem> picksOfTheDayList = new ArrayList<>();
        getFoodItems();
        for (int i = 0; i < 5; i++) {
            int rand = (int) (10 * Math.random());
            picksOfTheDayList.add(foodItemArrayList.get(rand));
        }
        return picksOfTheDayList;
    }
    public static ArrayList<FoodItem> fillFoodList(int id){
        String testString="";
        ArrayList<FoodItem> foodList = new ArrayList<>();
        for (int i = 0; i < foodItemArrayList.size(); i++) {
            if(id == foodItemArrayList.get(i).getRestaurantID()){
                if(foodList.contains(foodItemArrayList.get(i))){

                }else{
                    foodList.add(foodItemArrayList.get(i));
                }
                Log.i("foodList",testString.concat(foodItemArrayList.get(i).getFoodName()
                        +String.valueOf(foodItemArrayList.get(i).getFoodID())+"size "+foodList.size())
                        +" ArrayList size = "+foodItemArrayList.size());
            }
        }
        return foodList;
    }
    public static void addCocaCola(){
        for (int i = 1; i <= 10; i++) {
            foodItemArrayList.add(new FoodItem(2100+i,"Coca Cola",i,
                    RestaurantData.getRestaurantName(i-1),250,"A refreshing can of original coca-cola",
                    R.drawable.coca_cola_can));
        }
    }

}
