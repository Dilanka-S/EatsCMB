package lk.sliiti.eatscmb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Objects;

import lk.sliiti.eatscmb.database.data.FoodItemData;
import lk.sliiti.eatscmb.database.data.RestaurantData;
import lk.sliiti.eatscmb.database.data.UserData;
import lk.sliiti.eatscmb.database.dbModels.EatsCMBDBModel;
import lk.sliiti.eatscmb.database.model.FoodItem;
import lk.sliiti.eatscmb.database.model.Restaurant;
import lk.sliiti.eatscmb.database.model.User;
import lk.sliiti.eatscmb.fragments.MainViewFragment;
import lk.sliiti.eatscmb.uvindu.adapter.PicksAdapter;
import lk.sliiti.eatscmb.uvindu.adapter.RestaurantAdapter;

public class MainActivity extends AppCompatActivity {






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_EatsCMB);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);

        EatsCMBDBModel eatsCMBDBModel = new EatsCMBDBModel();
        eatsCMBDBModel.load(getApplicationContext());

        ArrayList<Restaurant> restaurantArrayList = RestaurantData.getRestaurants();

        for (int i = 0; i < restaurantArrayList.size(); i++) {
            eatsCMBDBModel.addRestaurants(restaurantArrayList.get(i));
        }

//        ArrayList<FoodItem> foodItemArrayList = FoodItemData.getFoodItems();
//
//        for (int i = 0; i < foodItemArrayList.size(); i++) {
//            eatsCMBDBModel.addFoodItems(foodItemArrayList.get(i));
//        }

        ArrayList<User> userArrayList = UserData.getUserDataArrayList();

        for (int i = 0; i < userArrayList.size(); i++) {
            eatsCMBDBModel.addUsers(userArrayList.get(i));
        }

        FragmentManager fragmentManager = getSupportFragmentManager();

        MainViewFragment mainViewFragment = new MainViewFragment();
        fragmentManager.beginTransaction().add(R.id.fragment_container_view,new MainViewFragment()).commit();

    }











}