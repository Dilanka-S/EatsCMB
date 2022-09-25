package lk.sliiti.eatscmb.database.data;

import android.util.Log;

import java.util.ArrayList;

import lk.sliiti.eatscmb.R;
import lk.sliiti.eatscmb.database.model.FoodItem;

public class FoodItemData {
    private static ArrayList<FoodItem> foodItemArrayList = new ArrayList<>();
    private static Boolean alreadySet = false;


    public static ArrayList<FoodItem> getFoodItemArrayList() {
        return foodItemArrayList;
    }

    public static ArrayList<FoodItem> getFoodItems(){
        while(!alreadySet){
            initializeList();
            alreadySet=true;
        }

        return foodItemArrayList;
    }

    private static void initializeList(){
        foodItemArrayList.add(new FoodItem(2001,"French Fries",1,
                "Mc Donald's",320,"Salted French Fries fried to perfection",
                R.drawable.mcdonald_frenchfries));
        foodItemArrayList.add(new FoodItem(2003,"Big Mac",1,
                "Mc Donald's",1350,"The perfect burger with two meat patties and a crunchy vege dressing",
                R.drawable.mcdonalds_big_mac_fries));
        foodItemArrayList.add(new FoodItem(2004,"Chicken Bucket",2,
                "KFC",3450,"12 Pieces of Colonel's special recipe Fried Chicken",
                R.drawable.kfc_chicken_bucket));
        foodItemArrayList.add(new FoodItem(2002,"Spicy Sandwich",3,
                "Popeyes",1200,"Crispy Fried Chicken with spicy seasoning on a glorious sandwich",
                R.drawable.popeyes_spicy_sandwich));
        foodItemArrayList.add(new FoodItem(2005,"Chicken Strips",3,
                "Popeyes",1400,"Crispy Fried Chicken with spicy seasoning on a glorious sandwich",
                R.drawable.popeyes_chicken_strips));
        foodItemArrayList.add(new FoodItem(2018,"Chicken Ham BLT",7,
                "Subway",850,"Chicken Ham BLT",
                R.drawable.subwaycaliturkeyfresh_lead));
        foodItemArrayList.add(new FoodItem(2007,"Classic Whopper",4,
                "Burgher King",900,"The Classic BK Beef Patty Whopper",
                R.drawable.impossible_whopper));
        foodItemArrayList.add(new FoodItem(2009,"French Fries",7,
                "Subway",320,"Salted French Fries fried to perfection",
                R.drawable.mcdonald_frenchfries));
        foodItemArrayList.add(new FoodItem(2011,"French Fries",9,
                "Starbucks",320,"Salted French Fries fried to perfection",
                R.drawable.mcdonald_frenchfries));
        foodItemArrayList.add(new FoodItem(2012,"French Fries",10,
                "Dunkin Donuts",320,"Salted French Fries fried to perfection",
                R.drawable.mcdonald_frenchfries));
        foodItemArrayList.add(new FoodItem(2014,"Impossible Whopper",4,
                "Burgher King",1200,"The classic, but Vegan",
                R.drawable.burgerkingimpossiblewhopper));
        foodItemArrayList.add(new FoodItem(2015,"French Fries",2,
                "KFC",320,"Salted French Fries fried to perfection",
                R.drawable.kfc_fries));
        foodItemArrayList.add(new FoodItem(2016,"McSpicy",1,
                "Mc Donald's",1100,"Burger with spicy crispy chicken fried to perfection",
                R.drawable.mcspicy));
        foodItemArrayList.add(new FoodItem(2017,"McNuggets",1,
                "Mc Donald's",800,"The famous McDonald's crispy nuggets.",
                R.drawable.mcnuggets));
        foodItemArrayList.add(new FoodItem(2019,"McBeef",1,
                "Mc Donald's",1250,"Beef burger with cheese and pickles",
                R.drawable.mcbeef));
        foodItemArrayList.add(new FoodItem(2020,"12Pc Bucket",2,
                "KFC",3400,"12 Pieces of delicious crispy fried chicken",
                R.drawable.kfcchickenbucket));
        foodItemArrayList.add(new FoodItem(2021,"Hot Drumlets",2,
                "KFC",900,"6 Pcs of seasoned crispy chicken",
                R.drawable.kfchotdrumlets));
        foodItemArrayList.add(new FoodItem(2022,"Snacker",2,
                "KFC",890,"For a snack on the go",
                R.drawable.kfcsnacker));
        foodItemArrayList.add(new FoodItem(2023,"Zinger Burger",2,
                "KFC",1300,"The famous KFC Zinger burger",
                R.drawable.kfczingerbuger));
        foodItemArrayList.add(new FoodItem(2024,"SnackerBox",2,
                "KFC",1150,"Mix of KFC specialties",
                R.drawable.kfcsnackerbox));
        foodItemArrayList.add(new FoodItem(2025,"Nuggets",3,
                "Popeyes",600,"Our special chicken nuggets",
                R.drawable.popeyesnuggets));
        foodItemArrayList.add(new FoodItem(2026,"Signature",3,
                "Popeyes",1000,"Popeyes' signature chicken",
                R.drawable.popeyessignaturechicken));
        foodItemArrayList.add(new FoodItem(2027,"BBQ Chicken",5,
                "Pizza Hut",2450,"Pizza with BBQ Chicken",
                R.drawable.pizzahutbbqchicken));
        foodItemArrayList.add(new FoodItem(2028,"Chicken Bacon",5,
                "Pizza Hut",2450,"Pizza with Chicken Bacon",
                R.drawable.pizzahutchickenbacon));
        foodItemArrayList.add(new FoodItem(2029,"Hawaiian",5,
                "Pizza Hut",3100,"Pizza with a hawaiian touch with pinapple and seafood",
                R.drawable.pizzahuthawaiian));
        foodItemArrayList.add(new FoodItem(2030,"Meat Lovers",5,
                "Pizza Hut",3200,"Pizza with a mix of different meat",
                R.drawable.pizzahutmeatlovers));
        foodItemArrayList.add(new FoodItem(2031,"Super Supreme",5,
                "Pizza Hut",3200,"Pizza with a mix of meat and seafood",
                R.drawable.pizzahutsupersupreme));
        foodItemArrayList.add(new FoodItem(2032,"Garlic Chicken",6,
                "Domino's Pizza",2430,"Pizza with garlic chicken",
                R.drawable.dominosgarlicchicken));
        foodItemArrayList.add(new FoodItem(2033,"Garlic prawn",6,
                "Domino's Pizza",2500,"Pizza with garlic prawn",
                R.drawable.dominosgarlicprawn));
        foodItemArrayList.add(new FoodItem(2034,"LoadedSupreme",6,
                "Domino's Pizza",2600,"Pizza with mix of meat and cheese",
                R.drawable.dominosloadedsupreme));
        foodItemArrayList.add(new FoodItem(2035,"Peri Peri",6,
                "Domino's Pizza",2700,"Pizza with chicken",
                R.drawable.dominosperiperi));
        foodItemArrayList.add(new FoodItem(2036,"ChickenTeriyaki",7,
                "Subway",1100,"Sandwich with fresh vegetables and chicken",
                R.drawable.subwaychickenteriyaki));
        foodItemArrayList.add(new FoodItem(2037,"Italian BMT",7,
                "Subway",1100,"Sandwich with fresh vegetables and meat",
                R.drawable.subwayitalianbmt));
        foodItemArrayList.add(new FoodItem(2038,"RoastBeef",7,
                "Subway",1200,"Sandwich with fresh vegetables and roast beef",
                R.drawable.subwayroastbeef));
        foodItemArrayList.add(new FoodItem(2039,"Tuna",7,
                "Subway",1500,"Sandwich with fresh vegetables and tuna",
                R.drawable.subwaytuna));

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
