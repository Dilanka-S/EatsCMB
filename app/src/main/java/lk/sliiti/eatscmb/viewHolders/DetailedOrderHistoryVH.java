package lk.sliiti.eatscmb.viewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import lk.sliiti.eatscmb.R;
import lk.sliiti.eatscmb.database.data.FoodItemData;
import lk.sliiti.eatscmb.database.model.CartItem;

public class DetailedOrderHistoryVH extends RecyclerView.ViewHolder {
    private TextView foodName, restaurant, foodPrice, foodCount;
    private static int count = 0;
    public DetailedOrderHistoryVH(@NonNull View itemView) {
        super(itemView);
        foodCount = itemView.findViewById(R.id.history_item_count);
        foodName = itemView.findViewById(R.id.history_item_name);
        foodPrice = itemView.findViewById(R.id.history_item_price);
        //restaurant = itemView.findViewById(R.id.history_item_restaurant);
    }
    public void bind(CartItem cartItem){
        foodName.setText(cartItem.getFoodName());
        foodPrice.setText(String.valueOf(cartItem.getFoodPrice()));
        foodCount.setText(String.valueOf(cartItem.getQuantity()));
        //restaurant.setText(cartItem.get);

    }
}
