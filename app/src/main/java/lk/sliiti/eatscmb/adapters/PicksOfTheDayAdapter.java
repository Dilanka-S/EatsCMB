package lk.sliiti.eatscmb.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import lk.sliiti.eatscmb.R;
import lk.sliiti.eatscmb.database.model.FoodItem;
import lk.sliiti.eatscmb.viewHolders.PicksOfTheDayVH;
import lk.sliiti.eatscmb.viewHolders.RestaurantVH;

public class PicksOfTheDayAdapter extends RecyclerView.Adapter<PicksOfTheDayVH> {
    private ArrayList<FoodItem> picksOfTheDayArrayList;

    public PicksOfTheDayAdapter(ArrayList<FoodItem> picksOfTheDayArrayList) {
        this.picksOfTheDayArrayList = picksOfTheDayArrayList;
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

    }

    @Override
    public int getItemCount() {
        return picksOfTheDayArrayList.size();
    }
}
