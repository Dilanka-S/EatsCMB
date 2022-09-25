package lk.sliiti.eatscmb.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import lk.sliiti.eatscmb.R;
import lk.sliiti.eatscmb.database.data.CartItemData;
import lk.sliiti.eatscmb.database.data.FoodItemData;
import lk.sliiti.eatscmb.database.model.FoodItem;
import lk.sliiti.eatscmb.viewHolders.FoodSelectionVH;
import lk.sliiti.eatscmb.viewHolders.PicksOfTheDayVH;

public class FoodSelectionAdapter extends RecyclerView.Adapter<FoodSelectionVH> {
    private ArrayList<FoodItem> foodItemArrayList;
    ImageButton plusButton;

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
        plusButton = holder.itemView.findViewById(R.id.food_add_btn);

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String popUp="";
                Toast.makeText(v.getContext(),popUp.concat(" added to Cart!") ,Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        Log.i("arrayList size",String.valueOf(foodItemArrayList.size()));
        return foodItemArrayList.size();
    }
}
