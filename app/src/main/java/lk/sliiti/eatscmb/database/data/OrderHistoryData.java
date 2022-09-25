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

    public static ArrayList<OrderHistoryItem> getOrderHistoryItemArrayList() {
        return orderHistoryItemArrayList;
    }

    public void setOrderHistoryItemArrayList(ArrayList<OrderHistoryItem> orderHistoryItemArrayList) {
        this.orderHistoryItemArrayList = orderHistoryItemArrayList;
    }

    public OrderHistoryData(ArrayList<OrderHistoryItem> orderHistoryItemArrayList) {
        this.orderHistoryItemArrayList = orderHistoryItemArrayList;
    }

    public static ArrayList<OrderHistoryItem> demoInitialise(){
        ArrayList<OrderHistoryItem> demoDataList = new ArrayList<>();
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
        String stringdate = format.format(date);

        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String stringtime = time.format(formatter);

        demoDataList.add(new OrderHistoryItem(10001,"dvsen",stringdate,stringtime,CartItemData.getDemoCartList(),9300));
        return demoDataList;
    }

    public static void addOrderHistory(OrderHistoryItem orderHistoryItem){
        orderHistoryItemArrayList.add(orderHistoryItem);
    }
}
