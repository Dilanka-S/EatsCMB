package lk.sliiti.eatscmb.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import lk.sliiti.eatscmb.R;
import lk.sliiti.eatscmb.database.model.CartItem;
import lk.sliiti.eatscmb.viewHolders.CartVH;

public class CartAdapter extends RecyclerView.Adapter<CartVH> {
    private ArrayList<CartItem> cartItems;
    private FragmentManager fragmentManager;

    public CartAdapter(ArrayList<CartItem> foodItemArrayList, FragmentManager fragmentManager) {
        this.cartItems = foodItemArrayList;
        this.fragmentManager = fragmentManager;
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
        holder.bind(cartItems.get(position));
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }
}
