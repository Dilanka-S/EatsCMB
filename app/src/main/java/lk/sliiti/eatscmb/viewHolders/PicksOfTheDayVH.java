package lk.sliiti.eatscmb.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import lk.sliiti.eatscmb.R;
import lk.sliiti.eatscmb.database.model.FoodItem;

public class PicksOfTheDayVH extends RecyclerView.ViewHolder {
    private  ImageView placeHolder;
    private  ImageView podPhoto;
    private  ImageView addToCart;
    private  TextView podName;
    private  TextView podPrice;

    public PicksOfTheDayVH(@NonNull View itemView) {
        super(itemView);
        placeHolder = itemView.findViewById(R.id.itemPlaceholder);
        podPhoto = itemView.findViewById(R.id.itemImage);
        addToCart = itemView.findViewById(R.id.addToCartIcon);
        podName = itemView.findViewById(R.id.forYouName);
        podPrice = itemView.findViewById(R.id.forYouPrice);
    }
    public void bind(FoodItem foodItem){
        placeHolder.setImageResource(R.drawable.placeholder_picks_for_you);
        podPhoto.setImageResource(foodItem.getFoodPhoto());
        addToCart.setImageResource(R.drawable.ic_add_to_cart_svgrepo_com);
        podName.setText(foodItem.getFoodName());
        String tempPrice = String.valueOf(foodItem.getPrice());
        String price="";
        podPrice.setText(price.concat("LKR "+tempPrice));
    }
}
