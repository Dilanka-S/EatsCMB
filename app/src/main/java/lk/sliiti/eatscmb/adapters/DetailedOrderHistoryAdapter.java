package lk.sliiti.eatscmb.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import lk.sliiti.eatscmb.R;
import lk.sliiti.eatscmb.database.model.OrderHistoryItem;
import lk.sliiti.eatscmb.viewHolders.DetailedOrderHistoryVH;
import lk.sliiti.eatscmb.viewHolders.UserProfileVH;

public class DetailedOrderHistoryAdapter extends RecyclerView.Adapter<DetailedOrderHistoryVH> {
    private ArrayList<OrderHistoryItem> orderHistoryItemArrayList;
    private FragmentManager fragmentManager;

    public DetailedOrderHistoryAdapter(ArrayList<OrderHistoryItem> orderHistoryItemArrayList, FragmentManager fragmentManager) {
        this.orderHistoryItemArrayList = orderHistoryItemArrayList;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public DetailedOrderHistoryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.order_history_item,parent,false);
        DetailedOrderHistoryVH myDataVHolder = new DetailedOrderHistoryVH(view);
        return myDataVHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DetailedOrderHistoryVH holder, int position) {
        holder.bind(orderHistoryItemArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return orderHistoryItemArrayList.size();
    }
}
