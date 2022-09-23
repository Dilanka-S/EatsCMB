package lk.sliiti.eatscmb.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import lk.sliiti.eatscmb.R;
import lk.sliiti.eatscmb.database.model.FoodItem;
import lk.sliiti.eatscmb.viewHolders.CartVH;
import lk.sliiti.eatscmb.viewHolders.FoodSelectionVH;

public class CartAdapter extends RecyclerView.Adapter<CartVH> {
    private ArrayList<FoodItem> foodItemArrayList;

    public CartAdapter(ArrayList<FoodItem> foodItemArrayList) {
        this.foodItemArrayList = foodItemArrayList;
    }

    @NonNull
    @Override
    public CartVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.cart_item,parent,false);
        return new CartVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartVH holder, int position) {
        holder.bind(foodItemArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return foodItemArrayList.size();
    }
}
