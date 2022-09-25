package lk.sliiti.eatscmb.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import lk.sliiti.eatscmb.R;
import lk.sliiti.eatscmb.database.data.CartItemData;
import lk.sliiti.eatscmb.database.model.CartItem;
import lk.sliiti.eatscmb.database.model.FoodItem;

public class FoodSelectionVH extends RecyclerView.ViewHolder {
    private ImageView foodItemPhoto, placeHolder,foodCountBackground;
    private TextView foodTitle, foodDescripion, foodPrice, foodCount;
    public FoodSelectionVH(@NonNull View itemView) {
        super(itemView);
        foodItemPhoto = itemView.findViewById(R.id.foodItem_Photo);
        placeHolder = itemView.findViewById(R.id.foodItem_placeHolder);
        foodCountBackground = itemView.findViewById(R.id.food_count_background);
        foodTitle = itemView.findViewById(R.id.food_title);
        foodDescripion = itemView.findViewById(R.id.food_descriptiom);
        foodPrice = itemView.findViewById(R.id.food_price);
        foodCount = itemView.findViewById(R.id.food_count);
    }
    public void bind(FoodItem foodItem){
        placeHolder.setImageResource(R.drawable.rectangle_1);
        foodCountBackground.setImageResource(R.drawable.rectangle_5);
        foodItemPhoto.setImageResource(foodItem.getFoodPhoto());
        foodTitle.setText(foodItem.getFoodName());
        foodDescripion.setText(foodItem.getDescription());
        String tempPrice = String.valueOf(foodItem.getPrice());
        String price="";
        foodPrice.setText(price.concat("LKR "+tempPrice));
        if(CartItemData.getCartItem(foodItem.getFoodID())!=null){
            foodCount.setText(String.valueOf(CartItemData.getCartItem(foodItem.getFoodID()).getQuantity()));
        }else{
            foodCount.setText(String.valueOf(0));
        }

    }
}
