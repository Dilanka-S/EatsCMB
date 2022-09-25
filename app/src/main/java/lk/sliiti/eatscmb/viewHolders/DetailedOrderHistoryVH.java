package lk.sliiti.eatscmb.viewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import lk.sliiti.eatscmb.R;
import lk.sliiti.eatscmb.database.data.FoodItemData;
import lk.sliiti.eatscmb.database.model.OrderHistoryItem;

public class DetailedOrderHistoryVH extends RecyclerView.ViewHolder {
    private TextView foodName, restaurant, foodPrice, foodCount;
    private static int count = 0;
    public DetailedOrderHistoryVH(@NonNull View itemView) {
        super(itemView);
        foodCount = itemView.findViewById(R.id.history_item_count);
        foodName = itemView.findViewById(R.id.history_item_name);
        foodPrice = itemView.findViewById(R.id.history_item_price);
        restaurant = itemView.findViewById(R.id.history_item_restaurant);
    }
    public void bind(OrderHistoryItem orderHistoryItem){
        foodName.setText(orderHistoryItem.getCartItems().get(1).getFoodName());
        foodPrice.setText(String.valueOf(orderHistoryItem.getTotal_price()));
        foodCount.setText(String.valueOf(orderHistoryItem.getCartItems().get(1).getQuantity()));
        restaurant.setText(FoodItemData.getFoodItem(orderHistoryItem.getCartItems().get(1).getFoodID()).getRestaurant());

    }
}
