package lk.sliiti.eatscmb.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import lk.sliiti.eatscmb.R;
import lk.sliiti.eatscmb.adapters.PicksOfTheDayAdapter;
import lk.sliiti.eatscmb.adapters.RestaurantsAdapter;
import lk.sliiti.eatscmb.database.EatsCMBDBHelper;
import lk.sliiti.eatscmb.database.data.FoodItemData;
import lk.sliiti.eatscmb.database.data.RestaurantData;
import lk.sliiti.eatscmb.database.data.UserData;
import lk.sliiti.eatscmb.database.dbModels.EatsCMBDBModel;
import lk.sliiti.eatscmb.database.model.FoodItem;
import lk.sliiti.eatscmb.database.model.Restaurant;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class MainViewFragment extends Fragment {

    private Button logINButton, cartButton;
    private TextView restaurantName;
    private ImageButton profileButton;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MainViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        //EatsCMBDBHelper database = new EatsCMBDBHelper(getApplicationContext());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        EatsCMBDBModel eatsCMBDBModel = new EatsCMBDBModel();
        eatsCMBDBModel.load(getContext());

        ArrayList<Restaurant> restaurantArrayList = eatsCMBDBModel.getAllRestaurants();
//        logINButton.findViewById(R.id.loginBtn);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_view, container, false);


        RecyclerView recyclerView = view.findViewById(R.id.restaurant_recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2,RecyclerView.HORIZONTAL,false));
        recyclerView.setAdapter(new RestaurantsAdapter(restaurantArrayList,getParentFragmentManager()));
        //RestaurantData.getRestaurants()

//        ArrayList<FoodItem> foodItemArrayList = eatsCMBDBModel.getAllFoodItems();
//        for (int i = 0; i < foodItemArrayList.size(); i++) {
//
//        }
//        ArrayList<FoodItem> picksOfTheDayList = EatsCMBDBModel.getPicksOfTheDay(foodItemArrayList);

        RecyclerView pfyRecyclerView = view.findViewById(R.id.picksRecycler);
        pfyRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        pfyRecyclerView.setAdapter(new PicksOfTheDayAdapter(FoodItemData.getPicksOfTheDay(),getParentFragmentManager()));


        cartButton = view.findViewById(R.id.mainCart);

        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction().replace(R.id.fragment_container_view,new CartFragment()).addToBackStack("mainViewFrag to Cart").commit();
            }
        });

        logINButton = view.findViewById(R.id.loginBtn);

        logINButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction().replace(R.id.fragment_container_view,new LoginFragment()).addToBackStack("mainView to Login").commit();
            }
        });

        profileButton = view.findViewById(R.id.userProfile_icon);

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (UserData.findLoggedInUser()!=null){
                    getParentFragmentManager().beginTransaction().replace(R.id.fragment_container_view, new UserProfileFragment()).addToBackStack("mainView to User Profle").commit();
                }else{
                    Toast.makeText(getContext(),"Cannot find a logged in user!",Toast.LENGTH_SHORT).show();
                }
            }
        });


        return view;

    }
}