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
import lk.sliiti.eatscmb.database.model.CartItem;
import lk.sliiti.eatscmb.database.model.OrderHistoryItem;
import lk.sliiti.eatscmb.fragments.DetailedOrderHistoryFragment;
import lk.sliiti.eatscmb.fragments.FoodSelectionFragment;
import lk.sliiti.eatscmb.viewHolders.RestaurantVH;
import lk.sliiti.eatscmb.viewHolders.UserProfileVH;

public class UserProfileAdapter extends RecyclerView.Adapter<UserProfileVH> {
    private ArrayList<OrderHistoryItem> orderHistoryItemArrayList;
    private FragmentManager fragmentManager;

    public UserProfileAdapter(ArrayList<OrderHistoryItem> orderHistoryItemArrayList, FragmentManager fragmentManager) {
        this.orderHistoryItemArrayList = orderHistoryItemArrayList;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public UserProfileVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.order_history_item,parent,false);
        UserProfileVH myDataVHolder = new UserProfileVH(view);
        return myDataVHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserProfileVH holder, int position) {
        holder.bind(orderHistoryItemArrayList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String totalPrice = String.valueOf(orderHistoryItemArrayList.get(holder.getAdapterPosition()).getTotal_price());
                ArrayList<CartItem> cartItems = orderHistoryItemArrayList.get(holder.getAdapterPosition()).getCartItems();
                DetailedOrderHistoryFragment orderHistoryFragment = new DetailedOrderHistoryFragment(cartItems,totalPrice);
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_view,orderHistoryFragment)
                        .addToBackStack("foodSelectionpass").commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return orderHistoryItemArrayList.size();
    }
}
