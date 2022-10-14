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
import lk.sliiti.eatscmb.adapters.DetailedOrderHistoryAdapter;
import lk.sliiti.eatscmb.adapters.UserProfileAdapter;
import lk.sliiti.eatscmb.database.data.OrderHistoryData;
import lk.sliiti.eatscmb.database.model.CartItem;
import lk.sliiti.eatscmb.database.model.OrderHistoryItem;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailedOrderHistoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailedOrderHistoryFragment extends Fragment {

    private static ArrayList<CartItem> cartItems;
    private static String totalPrice;
    private static TextView total;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DetailedOrderHistoryFragment(ArrayList<CartItem> cartItemsList, String totalPriceInput) {
        // Required empty public constructor
        cartItems = cartItemsList;
        totalPrice = totalPriceInput;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailedOrderHistoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailedOrderHistoryFragment newInstance(String param1, String param2) {
        DetailedOrderHistoryFragment fragment = new DetailedOrderHistoryFragment(cartItems, totalPrice);
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        View view = inflater.inflate(R.layout.fragment_detailed_order_history, container, false);

        total = view.findViewById(R.id.order_history_detailed_total);
        total.setText(totalPrice);

        RecyclerView detailedHistoryRecyclerView = view.findViewById(R.id.order_history_cart_recyclerView);
        detailedHistoryRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        detailedHistoryRecyclerView.setAdapter(new DetailedOrderHistoryAdapter(cartItems,getParentFragmentManager()));
        return view;
    }
}