package lk.sliiti.eatscmb.database.schema;

import lk.sliiti.eatscmb.R;

public class RestaurantDBSchema {
    public static class restaurantTable{
        public static final String NAME = "restaurants";
        public static class Cols{
            public static final String RESTAURANTID = "restaurantID";
            public static final String NAME = "name";
            public static final String LOCATION = "location";
            public static final String DISTANCE = "distance";
            public static final String PHOTO = "photo";
        }
    }
}
