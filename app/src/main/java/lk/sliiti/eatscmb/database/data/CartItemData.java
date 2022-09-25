package lk.sliiti.eatscmb.database.data;

import java.util.ArrayList;

import lk.sliiti.eatscmb.database.model.CartItem;
import lk.sliiti.eatscmb.database.model.FoodItem;

public class CartItemData {
    private static final Integer ORDER_ID = 1000001;
    private static ArrayList<CartItem> cartItemDataArrayList = new ArrayList<>();

    public static ArrayList<CartItem> getCartItemDataArrayList() {
        return cartItemDataArrayList;
    }

    public static void setCartItemDataArrayList(ArrayList<CartItem> cartItemDataArrayList) {
        CartItemData.cartItemDataArrayList = cartItemDataArrayList;
    }
    public static void addToCart(FoodItem foodItem){
        if(cartItemDataArrayList.contains(getCartItem(foodItem.getFoodID()))){
            int quantity = getCartItem(foodItem.getFoodID()).getQuantity() +1;
            int price = getCartItem(foodItem.getFoodID()).getFoodPrice();
            int total = getCartItem(foodItem.getFoodID()).getTotal() + price;
            getCartItem(foodItem.getFoodID()).setQuantity(quantity);
            getCartItem(foodItem.getFoodID()).setTotal(total);
        }else{
            cartItemDataArrayList.add(new CartItem(foodItem.getFoodID(),
                    foodItem.getFoodName(),
                    foodItem.getPrice(),
                    1,
                    foodItem.getPrice()));
        }

    }
    public static void removeItem(FoodItem foodItem){
        if(cartItemDataArrayList.contains(getCartItem(foodItem.getFoodID()))){
            if(getCartItem(foodItem.getFoodID()).getQuantity()==1){
                cartItemDataArrayList.remove(getCartItem(foodItem.getFoodID()));
            }else{
                int quantity = getCartItem(foodItem.getFoodID()).getQuantity() -1;
                int price = getCartItem(foodItem.getFoodID()).getFoodPrice();
                int total = getCartItem(foodItem.getFoodID()).getTotal() - price;
                getCartItem(foodItem.getFoodID()).setQuantity(quantity);
                getCartItem(foodItem.getFoodID()).setTotal(total);
            }
        }

    }
    public int size(){
       return cartItemDataArrayList.size();
    }
    public static CartItem getCartItem(int id){
        CartItem cartItem = null;
        for (int i = 0; i < cartItemDataArrayList.size(); i++) {
            if (id == cartItemDataArrayList.get(i).getFoodID()){
                cartItem = cartItemDataArrayList.get(i);
            }
        }
        return cartItem;
    }

    public static int getTotal(){
        int total=0;
        for (int i = 0; i < cartItemDataArrayList.size(); i++) {
            total = total+cartItemDataArrayList.get(i).getTotal();
        }
        return total;
    }
    public static ArrayList<CartItem> getDemoCartList(){
        ArrayList<CartItem> demoList = new ArrayList<>();

        demoList.add(new CartItem(1200,"Mc Burger",1200, 2,2400));
        demoList.add(new CartItem(1300,"Chicken Shawarma",1000, 3,3000));
        demoList.add(new CartItem(1400,"Mc Burger",1200, 2,2400));
        demoList.add(new CartItem(1500,"Chicken 6pc",1500, 1,1500));

        return demoList;
    }

    public static int getOrderID(){
        int something = 0;
        return something;
    }

    public static void clearCart(){
        cartItemDataArrayList.clear();
    }


}
