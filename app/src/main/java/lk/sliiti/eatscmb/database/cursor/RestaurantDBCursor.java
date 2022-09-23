package lk.sliiti.eatscmb.database.cursor;

import android.database.Cursor;
import android.database.CursorWrapper;

import lk.sliiti.eatscmb.database.model.Restaurant;
import lk.sliiti.eatscmb.database.schema.RestaurantDBSchema;

public class RestaurantDBCursor extends CursorWrapper {
    public RestaurantDBCursor(Cursor cursor) {
        super(cursor);
    }

    public Restaurant getUser(){
        Integer restaurantID = getInt(getColumnIndex(RestaurantDBSchema.restaurantTable.Cols.RESTAURANTID));
        String restaurantName = getString(getColumnIndex(RestaurantDBSchema.restaurantTable.Cols.NAME));
        String location = getString(getColumnIndex(RestaurantDBSchema.restaurantTable.Cols.LOCATION));
        String distance = getString(getColumnIndex(RestaurantDBSchema.restaurantTable.Cols.DISTANCE));
        Integer restaurantPhoto = getInt(getColumnIndex(RestaurantDBSchema.restaurantTable.Cols.PHOTO));
        return new Restaurant(restaurantID,restaurantName,location,distance,restaurantPhoto);
    }

}
