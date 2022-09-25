package lk.sliiti.eatscmb.database.dbModels;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import lk.sliiti.eatscmb.database.EatsCMBDBHelper;
import lk.sliiti.eatscmb.database.cursor.FoodItemDBCursor;
import lk.sliiti.eatscmb.database.cursor.RestaurantDBCursor;
import lk.sliiti.eatscmb.database.model.FoodItem;
import lk.sliiti.eatscmb.database.model.Restaurant;
import lk.sliiti.eatscmb.database.schema.FoodItemDBSchema;
import lk.sliiti.eatscmb.database.schema.RestaurantDBSchema.restaurantTable;

public class EatsCMBDBModel {
    SQLiteDatabase db;

    public void load(Context context){
        this.db = new EatsCMBDBHelper(context).getWritableDatabase();
    }
    public void addRestaurants(Restaurant restaurant){
        ContentValues contentValues = new ContentValues();

        contentValues.put(restaurantTable.Cols.NAME, restaurant.getRestaurantName());
        contentValues.put(restaurantTable.Cols.PHOTO, restaurant.getRestaurantPhoto());
        contentValues.put(restaurantTable.Cols.DISTANCE, restaurant.getDistance());
        contentValues.put(restaurantTable.Cols.RESTAURANTID, restaurant.getRestaurantID());
        contentValues.put(restaurantTable.Cols.LOCATION, restaurant.getLocation());
        db.insert(restaurantTable.NAME, null, contentValues);
    }

    public ArrayList<Restaurant> getAllRestaurants(){
        ArrayList<Restaurant> RestaurantList = new ArrayList<>();
        Cursor cursor = db.query(restaurantTable.NAME,null,null,null,null,null,null);
        RestaurantDBCursor restaurantDBCursor = new RestaurantDBCursor(cursor);

        try{
            restaurantDBCursor.moveToFirst();
            while(!restaurantDBCursor.isAfterLast()){
                RestaurantList.add(restaurantDBCursor.getRestaurant());
                restaurantDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return RestaurantList;
    }

    public void addFoodItems(FoodItem foodItem){
        ContentValues contentValues = new ContentValues();
        contentValues.put(FoodItemDBSchema.foodItemTable.Cols.FOOD_ID, foodItem.getFoodID());
        contentValues.put(FoodItemDBSchema.foodItemTable.Cols.FOOD_NAME, foodItem.getFoodName());
        contentValues.put(FoodItemDBSchema.foodItemTable.Cols.DESCRIPTION, foodItem.getDescription());
        contentValues.put(FoodItemDBSchema.foodItemTable.Cols.PRICE, foodItem.getPrice());
        contentValues.put(FoodItemDBSchema.foodItemTable.Cols.RESTAURANT, foodItem.getRestaurant());
        contentValues.put(FoodItemDBSchema.foodItemTable.Cols.RESTAURANT_ID, foodItem.getRestaurantID());
        contentValues.put(FoodItemDBSchema.foodItemTable.Cols.FOOD_PHOTO, foodItem.getFoodPhoto());
        db.insert(FoodItemDBSchema.foodItemTable.NAME, null, contentValues);
    }

    public ArrayList<FoodItem> getAllFoodItems(){
        ArrayList<FoodItem> foodItemArrayList = new ArrayList<>();
        Cursor cursor = db.query(restaurantTable.NAME,null,null,null,null,null,null);
        FoodItemDBCursor foodItemDBCursor = new FoodItemDBCursor(cursor);

        try{
            foodItemDBCursor.moveToFirst();
            while(!foodItemDBCursor.isAfterLast()){
                foodItemArrayList.add(foodItemDBCursor.getFoodItems());
                foodItemDBCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return foodItemArrayList;
    }
}
