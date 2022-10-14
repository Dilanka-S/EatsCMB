package lk.sliiti.eatscmb.database.data;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import lk.sliiti.eatscmb.database.model.OrderHistoryItem;

public class OrderHistoryData {
    private static ArrayList<OrderHistoryItem> orderHistoryItemArrayList = new ArrayList<>();
    public static Boolean demoAlreadySet = false;


    public static ArrayList<OrderHistoryItem> getOrderHistoryItemArrayList() {
        return orderHistoryItemArrayList;
    }



    public void setOrderHistoryItemArrayList(ArrayList<OrderHistoryItem> orderHistoryItemArrayList) {
        this.orderHistoryItemArrayList = orderHistoryItemArrayList;
    }

    public OrderHistoryData(ArrayList<OrderHistoryItem> orderHistoryItemArrayList) {
        this.orderHistoryItemArrayList = orderHistoryItemArrayList;
    }

    public static void demoInitialise(){
        while (!demoAlreadySet){
            demoAlreadySet = true;
            ArrayList<OrderHistoryItem> demoDataList = new ArrayList<>();
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
            String stringdate = format.format(date);

            LocalTime time = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String stringtime = time.format(formatter);

            demoDataList.add(new OrderHistoryItem(10001,"dvsen",stringdate,stringtime,CartItemData.getDemoCartList(),9300));
            orderHistoryItemArrayList.add(new OrderHistoryItem(10001,"dvsen",stringdate,stringtime,CartItemData.getDemoCartList(),9300));
        }

    }

    public static ArrayList<OrderHistoryItem> getAllOrders(){
        return orderHistoryItemArrayList;
    }

    public static void addOrder(OrderHistoryItem orderHistoryItem){
        for (int i = 0; i < orderHistoryItemArrayList.size(); i++) {
            if (orderHistoryItemArrayList.get(i).getOrderID()==orderHistoryItem.getOrderID()){
                //do nothing
            }else{
                orderHistoryItemArrayList.add(orderHistoryItem);
            }
        }

    }

    public static Integer getNewOrderID(){
        int orderId = 100001;
        if (orderHistoryItemArrayList.size()!=0){
            orderId  = orderHistoryItemArrayList.get(orderHistoryItemArrayList.size()-1).getOrderID();
            orderId+=1;
        }
        return orderId;
    }

    public static void addOrderHistory(OrderHistoryItem orderHistoryItem){
        orderHistoryItemArrayList.add(orderHistoryItem);
    }
}
