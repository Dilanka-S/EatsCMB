package lk.sliiti.eatscmb.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import lk.sliiti.eatscmb.R;
import lk.sliiti.eatscmb.adapters.FoodSelectionAdapter;
import lk.sliiti.eatscmb.adapters.PicksOfTheDayAdapter;
import lk.sliiti.eatscmb.database.data.FoodItemData;
import lk.sliiti.eatscmb.database.model.FoodItem;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class FoodSelectionFragment extends Fragment {
    private ArrayList<FoodItem> foodItemArrayList;
    private Integer id;

    public FoodSelectionFragment(ArrayList<FoodItem> foodItemArrayList, int id) {
        this.foodItemArrayList = foodItemArrayList;
        this.id = id;
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FoodSelectionFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food_selection, container, false);

        RecyclerView foodSelectionRecyclerView = view.findViewById(R.id.foodSelectionRecyclerView);
        foodSelectionRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        foodSelectionRecyclerView.setAdapter(new FoodSelectionAdapter(foodItemArrayList));

        TextView restaurantName = view.findViewById(R.id.foodSelectionTitle);
        restaurantName.setText(foodItemArrayList.get(0).getRestaurant());

        return view;

    }
}