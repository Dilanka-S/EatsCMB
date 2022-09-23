package lk.sliiti.eatscmb.database.schema;

public class FoodItemDBSchema {
    public static class foodItemTable{
        public static final String NAME = "foodItems";
        public static class Cols{
            public static final String FOOD_ID = "food_ID";
            public static final String FOOD_NAME = "food_name";
            public static final String RESTAURANT_ID = "restaurant_ID";
            public static final String RESTAURANT = "restaurant";
            public static final String PRICE = "price";
            public static final String DESCRIPTION = "description";
            public static final String FOOD_PHOTO = "food_photo";
        }

    }
}
