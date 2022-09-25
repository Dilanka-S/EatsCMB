package lk.sliiti.eatscmb.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import lk.sliiti.eatscmb.R;
import lk.sliiti.eatscmb.database.data.CartItemData;
import lk.sliiti.eatscmb.database.data.FoodItemData;
import lk.sliiti.eatscmb.database.model.CartItem;
import lk.sliiti.eatscmb.viewHolders.CartVH;

public class CartAdapter extends RecyclerView.Adapter<CartVH> {
    private ArrayList<CartItem> cartItems;
    private FragmentManager fragmentManager;
    private ImageButton plusButton,removeButton;

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
        plusButton = holder.itemView.findViewById(R.id.checkout_add_btn);
        removeButton = holder.itemView.findViewById(R.id.checkout_remove_btn);

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = cartItems.get(holder.getAdapterPosition()).getFoodID();
                CartItemData.addToCart(FoodItemData.getFoodItem(id));
                notifyDataSetChanged();
//                String popUp="";
//                Toast.makeText(v.getContext(),popUp.concat(FoodItemData.getFoodItem(id).getFoodName()+" added to Cart!") ,Toast.LENGTH_SHORT).show();
            }
        });
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = cartItems.get(holder.getAdapterPosition()).getFoodID();
                CartItemData.removeItem(FoodItemData.getFoodItem(id));
                String popUp="";
                Toast.makeText(v.getContext(),popUp.concat(FoodItemData.getFoodItem(id).getFoodName()+" removed from Cart!") ,Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }
}
