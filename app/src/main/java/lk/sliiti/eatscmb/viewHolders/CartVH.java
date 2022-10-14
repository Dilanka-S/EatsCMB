package lk.sliiti.eatscmb.viewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import lk.sliiti.eatscmb.R;
import lk.sliiti.eatscmb.database.model.CartItem;

public class CartVH extends RecyclerView.ViewHolder {
    private TextView itemName, quantity, itemTotal;
    public CartVH(@NonNull View itemView) {
        super(itemView);
        itemName = itemView.findViewById(R.id.historyItemName);
        quantity = itemView.findViewById(R.id.cartItemQuantity);
        itemTotal = itemView.findViewById(R.id.historyItemTotal);
    }
    public void bind(CartItem cartItem){
        itemName.setText(cartItem.getFoodName());
        quantity.setText(String.valueOf(cartItem.getQuantity()));
        String tempPrice = String.valueOf(cartItem.getTotal());
        String price2="";
        itemTotal.setText(price2.concat("LKR "+tempPrice));
    }
}
