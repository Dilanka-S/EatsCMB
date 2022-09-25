package lk.sliiti.eatscmb.database.data;

import java.util.ArrayList;

import lk.sliiti.eatscmb.database.model.CartItem;
import lk.sliiti.eatscmb.database.model.FoodItem;

public class CartItemData {
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
}
