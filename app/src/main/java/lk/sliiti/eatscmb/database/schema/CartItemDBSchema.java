package lk.sliiti.eatscmb.database.schema;

public class CartItemDBSchema {
    public static class cartItemTable{
        public static final String NAME = "cartItems";
        public static class Cols {
            public static final String FOOD_ID = "food_ID";
            public static final String FOOD_NAME = "food_name";
            public static final String FOOD_PRICE = "food_price";
            public static final String QUANTITY = "quantity";
        }
    }
}
