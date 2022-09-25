package lk.sliiti.eatscmb.viewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import lk.sliiti.eatscmb.R;
import lk.sliiti.eatscmb.database.model.OrderHistoryItem;

public class UserProfileVH extends RecyclerView.ViewHolder {
    private TextView orderID, date, time, price;

    public UserProfileVH(@NonNull View itemView) {
        super(itemView);
        orderID = itemView.findViewById(R.id.order_history_id);
        date = itemView.findViewById(R.id.order_history_item_date);
        time = itemView.findViewById(R.id.order_history_item_time);
        price = itemView.findViewById(R.id.order_history_total);
    }
    public void bind(OrderHistoryItem orderHistoryItem){
        orderID.setText(String.valueOf(orderHistoryItem.getOrderID()));
        date.setText(orderHistoryItem.getDate());
        time.setText(orderHistoryItem.getTime());
        price.setText(String.valueOf(orderHistoryItem.getTotal_price()));

    }
}
