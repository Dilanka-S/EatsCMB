package lk.sliiti.eatscmb.database.model;

import java.util.ArrayList;
import java.util.Date;

public class OrderHistoryItem {
    int orderID;
    String username;
    String date;
    String time;
    ArrayList<CartItem> cartItems;
    int total_price;

    public OrderHistoryItem(int orderID, String username, String date, String time, ArrayList<CartItem> cartItems, int total_price) {
        this.orderID = orderID;
        this.username = username;
        this.date = date;
        this.time = time;
        this.cartItems = cartItems;
        this.total_price = total_price;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }
}
