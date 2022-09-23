package lk.sliiti.eatscmb.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import lk.sliiti.eatscmb.R;
import lk.sliiti.eatscmb.database.data.FoodItemData;
import lk.sliiti.eatscmb.database.data.RestaurantData;
import lk.sliiti.eatscmb.database.model.FoodItem;
import lk.sliiti.eatscmb.database.model.Restaurant;
import lk.sliiti.eatscmb.fragments.FoodSelectionFragment;
import lk.sliiti.eatscmb.viewHolders.RestaurantVH;

public class RestaurantsAdapter extends RecyclerView.Adapter<RestaurantVH> {
    private ArrayList<Restaurant> restaurants;
    private FragmentManager fragmentManager;

    public RestaurantsAdapter(ArrayList<Restaurant> restaurants, FragmentManager fragmentManager) {
        this.restaurants = restaurants;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public RestaurantVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.resaurant_main,parent,false);
        RestaurantVH myDataVHolder = new RestaurantVH(view);
        return myDataVHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantVH holder, int position) {
        holder.bind(restaurants.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id =restaurants.get(holder.getAdapterPosition()).getRestaurantID();
                FoodSelectionFragment foodSelectionFragment = new FoodSelectionFragment(FoodItemData.fillFoodList(id),id);
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_view,foodSelectionFragment)
                        .addToBackStack("foodSelectionpass").commit();

            }
        });

    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

}
