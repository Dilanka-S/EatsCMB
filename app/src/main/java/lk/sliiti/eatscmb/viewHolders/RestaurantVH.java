package lk.sliiti.eatscmb.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import lk.sliiti.eatscmb.R;
import lk.sliiti.eatscmb.database.model.Restaurant;

public class RestaurantVH extends RecyclerView.ViewHolder {
    private ImageView profilePic, placeHolder;
    private TextView restaurantName, restaurantTime;
    private int placeHolderID = R.drawable.restaurent_rectangle;
    public RestaurantVH(@NonNull View itemView) {
        super(itemView);
        profilePic = itemView.findViewById(R.id.restaurant_profilepic);
        placeHolder = itemView.findViewById(R.id.restaurant_placeholder);
        restaurantName = itemView.findViewById(R.id.restaurantName);
        restaurantTime = itemView.findViewById(R.id.restaurantTime);
    }
    public void bind(Restaurant restaurant){
        profilePic.setImageResource(restaurant.getRestaurantPhoto());
        placeHolder.setImageResource(placeHolderID);
        restaurantName.setText(restaurant.getRestaurantName());
        restaurantTime.setText(restaurant.getLocation());

    }
}
