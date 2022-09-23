package lk.sliiti.eatscmb.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import lk.sliiti.eatscmb.R;
import lk.sliiti.eatscmb.database.model.FoodItem;
import lk.sliiti.eatscmb.viewHolders.FoodSelectionVH;
import lk.sliiti.eatscmb.viewHolders.PicksOfTheDayVH;

public class FoodSelectionAdapter extends RecyclerView.Adapter<FoodSelectionVH> {
    private ArrayList<FoodItem> foodItemArrayList;

    public FoodSelectionAdapter(ArrayList<FoodItem> foodItemArrayList) {
        this.foodItemArrayList = foodItemArrayList;
    }

    @NonNull
    @Override
    public FoodSelectionVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.restaurent_food_item_recycler,parent,false);
        return new FoodSelectionVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodSelectionVH holder, int position) {
        holder.bind(foodItemArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        Log.i("arrayList size",String.valueOf(foodItemArrayList.size()));
        return foodItemArrayList.size();
    }
}
