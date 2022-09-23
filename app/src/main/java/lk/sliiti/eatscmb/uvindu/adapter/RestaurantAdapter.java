package lk.sliiti.eatscmb.uvindu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import lk.sliiti.eatscmb.R;
import lk.sliiti.eatscmb.database.model.Restaurant;
import lk.sliiti.eatscmb.uvindu.adapter.model.Restaurants;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.restaurantViewHolder> {

    Context context;
    List<Restaurants> restaurantsList;

    public RestaurantAdapter(Context context, List<Restaurants> restaurantsList) {
        this.context = context;
        this.restaurantsList = restaurantsList;
    }

    public RestaurantAdapter(ArrayList<Restaurant> restaurants) {
    }


    @NonNull
    @Override
    public restaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new restaurantViewHolder(LayoutInflater.from(context).inflate(R.layout.resaurant_main ,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull restaurantViewHolder holder, int position) {
        holder.itemImage.setImageResource(restaurantsList.get(position).getImageLink());
        holder.itemName.setText(restaurantsList.get(position).getName());
        holder.itemTime.setText(restaurantsList.get(position).getTime());

    }

    @Override
    public int getItemCount() {
        return restaurantsList.size();
    }

    public static final class restaurantViewHolder extends RecyclerView.ViewHolder{

        ImageView itemImage;
        TextView itemName, itemTime;

        public restaurantViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.restaurant_profilepic);
            itemName = itemView.findViewById(R.id.restaurantName);
            itemTime = itemView.findViewById(R.id.restaurantTime);


        }
    }
}
