package lk.sliiti.eatscmb.viewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import lk.sliiti.eatscmb.R;
import lk.sliiti.eatscmb.database.model.FoodItem;

public class CartVH extends RecyclerView.ViewHolder {
    private TextView itemName, quantity, price;
    public CartVH(@NonNull View itemView) {
        super(itemView);
        itemName = itemView.findViewById(R.id.cartItemName);
        quantity = itemView.findViewById(R.id.cartItemQuantity);
        price = itemView.findViewById(R.id.CartItemTotal);
    }
    public void bind(FoodItem foodItem){
        itemName.setText(foodItem.getFoodName());
        quantity.setText("0");
        String tempPrice = String.valueOf(foodItem.getPrice());
        String price2="";
        price.setText(price2.concat("LKR "+tempPrice));
    }
}
