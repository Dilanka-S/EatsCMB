package lk.sliiti.eatscmb.database.cursor;

import android.database.Cursor;
import android.database.CursorWrapper;

import lk.sliiti.eatscmb.database.model.FoodItem;
import lk.sliiti.eatscmb.database.schema.FoodItemDBSchema;

public class FoodItemDBCursor extends CursorWrapper {
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public FoodItemDBCursor(Cursor cursor) {
        super(cursor);
    }

    public FoodItem getFoodItems(){
        int foodID = getInt(getColumnIndex(FoodItemDBSchema.foodItemTable.Cols.FOOD_ID));
        int restaurantID = getInt(getColumnIndex(FoodItemDBSchema.foodItemTable.Cols.RESTAURANT_ID));
        int price = getInt(getColumnIndex(FoodItemDBSchema.foodItemTable.Cols.PRICE));
        String restaurant = getString(getColumnIndex(FoodItemDBSchema.foodItemTable.Cols.RESTAURANT));
        String foodName = getString(getColumnIndex(FoodItemDBSchema.foodItemTable.Cols.FOOD_NAME));
        String description = getString(getColumnIndex(FoodItemDBSchema.foodItemTable.Cols.DESCRIPTION));
        int foodPhoto = getInt(getColumnIndex(FoodItemDBSchema.foodItemTable.Cols.FOOD_PHOTO));
        return new FoodItem(foodID,foodName,restaurantID,restaurant,price,description,foodPhoto);
    }
}
