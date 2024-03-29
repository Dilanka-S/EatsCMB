package lk.sliiti.eatscmb.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import lk.sliiti.eatscmb.R;
import lk.sliiti.eatscmb.adapters.CartAdapter;
import lk.sliiti.eatscmb.adapters.FoodSelectionAdapter;
import lk.sliiti.eatscmb.database.data.CartItemData;
import lk.sliiti.eatscmb.database.data.FoodItemData;
import lk.sliiti.eatscmb.database.data.OrderHistoryData;
import lk.sliiti.eatscmb.database.data.UserData;
import lk.sliiti.eatscmb.database.model.OrderHistoryItem;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class CartFragment extends Fragment {
    private TextView grandTotal;
    private Button checkoutButton;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CartFragment() {
        // Required empty public constructor
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
        View view =  inflater.inflate(R.layout.fragment_cart, container, false);
        grandTotal = view.findViewById(R.id.checkout_total);

        checkoutButton = view.findViewById(R.id.checkoutbtn);


        RecyclerView cartRecyclerView = view.findViewById(R.id.checkout_recyclerView);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        CartAdapter cartAdapter=new CartAdapter(CartItemData.getCartItemDataArrayList(),getParentFragmentManager());
        cartRecyclerView.setAdapter(cartAdapter);

        int tempTotal = CartItemData.getTotal();
        String total="";
        grandTotal.setText(total.concat("LKR "+tempTotal));


        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (UserData.findLoggedInUser()!=null){
                    Date date = new Date();
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
                    String stringdate = format.format(date);

                    LocalTime time = LocalTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                    String stringtime = time.format(formatter);

                    OrderHistoryItem orderHistoryItem = new OrderHistoryItem(OrderHistoryData.getNewOrderID(), UserData.findLoggedInUser().getUsername(),stringdate, stringtime,CartItemData.getCartItemDataArrayList(),tempTotal);
                    OrderHistoryData.addOrder(orderHistoryItem);
                    CartItemData.clearCart();
                    cartAdapter.notifyDataSetChanged();

                    Toast.makeText(getContext(),"You have successfully Checked out this order!",Toast.LENGTH_SHORT).show();


                }else{
                    Toast.makeText(getContext(),"Please Login to Checkout!",Toast.LENGTH_SHORT).show();
                }




            }
        });
        return view;
    }
}