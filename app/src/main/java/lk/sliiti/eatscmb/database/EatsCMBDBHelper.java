package lk.sliiti.eatscmb.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import lk.sliiti.eatscmb.database.schema.CartItemDBSchema;
import lk.sliiti.eatscmb.database.schema.FoodItemDBSchema;
import lk.sliiti.eatscmb.database.schema.LoginDBSchema;
import lk.sliiti.eatscmb.database.schema.RestaurantDBSchema;

public class EatsCMBDBHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "eatscmb.db";
    public EatsCMBDBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ LoginDBSchema.userTable.NAME+"" + "("
                +LoginDBSchema.userTable.Cols.USERNAME+" Text PRIMARY KEY, "
                +LoginDBSchema.userTable.Cols.NAME+" Text NOT NULL, "
                +LoginDBSchema.userTable.Cols.LOG_STATUS+" Text NOT NULL, "
                +LoginDBSchema.userTable.Cols.PASSWORD+ " Text NOT NULL);");
        db.execSQL("create table "+ RestaurantDBSchema.restaurantTable.NAME+"("
                +RestaurantDBSchema.restaurantTable.Cols.NAME+" Text NOT NULL, "
                +RestaurantDBSchema.restaurantTable.Cols.PHOTO+ " Integer NOT NULL, "
                +RestaurantDBSchema.restaurantTable.Cols.DISTANCE+ " Text, "
                +RestaurantDBSchema.restaurantTable.Cols.RESTAURANTID+" Integer PRIMARY KEY,"
                +RestaurantDBSchema.restaurantTable.Cols.LOCATION+ " Text);");
        db.execSQL("create table "+ FoodItemDBSchema.foodItemTable.NAME+"("
                +FoodItemDBSchema.foodItemTable.Cols.FOOD_ID+" Integer PRIMARY KEY,"
                +FoodItemDBSchema.foodItemTable.Cols.FOOD_NAME+" Text NOT NULL, "
                +FoodItemDBSchema.foodItemTable.Cols.DESCRIPTION+" Text NOT NULL, "
                +FoodItemDBSchema.foodItemTable.Cols.PRICE+" Integer NOT NULL, "
                +FoodItemDBSchema.foodItemTable.Cols.RESTAURANT_ID+" Integer NOT NULL, "
                +FoodItemDBSchema.foodItemTable.Cols.RESTAURANT+" Text NOT NULL, "
                +FoodItemDBSchema.foodItemTable.Cols.FOOD_PHOTO+ " Integer NOT NULL, "
                +"FOREIGN KEY (" + FoodItemDBSchema.foodItemTable.Cols.RESTAURANT_ID+") REFERENCES "+
                        RestaurantDBSchema.restaurantTable.NAME+"("+ RestaurantDBSchema.restaurantTable.Cols.RESTAURANTID+"));");
        db.execSQL("create table "+ CartItemDBSchema.cartItemTable.NAME+"" + "("
                +CartItemDBSchema.cartItemTable.Cols.FOOD_ID+" Text PRIMARY KEY, "
                +CartItemDBSchema.cartItemTable.Cols.FOOD_NAME+" Text NOT NULL, "
                +CartItemDBSchema.cartItemTable.Cols.FOOD_PRICE+" Text NOT NULL, "
                +CartItemDBSchema.cartItemTable.Cols.QUANTITY+ " Text );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
