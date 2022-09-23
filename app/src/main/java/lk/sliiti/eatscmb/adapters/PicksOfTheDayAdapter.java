package lk.sliiti.eatscmb.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import lk.sliiti.eatscmb.R;
import lk.sliiti.eatscmb.database.data.CartItemData;
import lk.sliiti.eatscmb.database.data.FoodItemData;
import lk.sliiti.eatscmb.database.model.CartItem;
import lk.sliiti.eatscmb.database.model.FoodItem;
import lk.sliiti.eatscmb.fragments.FoodSelectionFragment;
import lk.sliiti.eatscmb.viewHolders.PicksOfTheDayVH;
import lk.sliiti.eatscmb.viewHolders.RestaurantVH;

public class PicksOfTheDayAdapter extends RecyclerView.Adapter<PicksOfTheDayVH> {
    private ArrayList<FoodItem> picksOfTheDayArrayList;
    private FragmentManager fragmentManager;

    public PicksOfTheDayAdapter(ArrayList<FoodItem> picksOfTheDayArrayList, FragmentManager fragmentManager) {
        this.picksOfTheDayArrayList = picksOfTheDayArrayList;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public PicksOfTheDayVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.picks_for_you_row,parent,false);
        return new PicksOfTheDayVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PicksOfTheDayVH holder, int position) {
        holder.bind(picksOfTheDayArrayList.get(position));
        holder.itemView.setOnClickListener(v -> {
            int id = picksOfTheDayArrayList.get(holder.getAdapterPosition()).getFoodID();
            CartItemData.addToCart(FoodItemData.getFoodItem(id));

//                FoodSelectionFragment foodSelectionFragment = new FoodSelectionFragment(FoodItemData.fillFoodList(id),id);
//                fragmentManager.beginTransaction()
//                        .replace(R.id.fragment_container_view,foodSelectionFragment)
//                        .addToBackStack("foodSelectionpass").commit();

        });

    }

    @Override
    public int getItemCount() {
        return picksOfTheDayArrayList.size();
    }
}
