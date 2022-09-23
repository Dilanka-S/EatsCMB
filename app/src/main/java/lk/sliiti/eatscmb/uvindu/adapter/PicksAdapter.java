package lk.sliiti.eatscmb.uvindu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import lk.sliiti.eatscmb.R;
import lk.sliiti.eatscmb.uvindu.adapter.model.PicksForYou;

public class PicksAdapter extends RecyclerView.Adapter<PicksAdapter.oicksForYouViewHolder> {

    Context context;
    List<PicksForYou> picksForYouList;

    public PicksAdapter(Context context, List<PicksForYou> picksForYouList) {
        this.context = context;
        this.picksForYouList = picksForYouList;
    }

    @NonNull
    @Override
    public oicksForYouViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new oicksForYouViewHolder(LayoutInflater.from(context).inflate(R.layout.picks_for_you_row ,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull oicksForYouViewHolder holder, int position) {
        holder.itemImage.setImageResource(picksForYouList.get(position).getImageUrl());
        holder.itemName.setText(picksForYouList.get(position).getName());
        holder.itemPrice.setText(picksForYouList.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return picksForYouList.size();
    }

    public static final class oicksForYouViewHolder extends RecyclerView.ViewHolder{

        ImageView itemImage;
        TextView itemName, itemPrice;

        public oicksForYouViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.itemImage);
            itemName = itemView.findViewById(R.id.forYouName);
            itemPrice = itemView.findViewById(R.id.forYouPrice);


        }
    }
}
