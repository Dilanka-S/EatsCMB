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

import java.util.Objects;

import lk.sliiti.eatscmb.fragments.MainViewFragment;
import lk.sliiti.eatscmb.uvindu.adapter.PicksAdapter;
import lk.sliiti.eatscmb.uvindu.adapter.RestaurantAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView picksForYouRecycler, restaurantRecycler;
    PicksAdapter picksForYouAdapter;
    RestaurantAdapter restaurantAdapter;
    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Button shoppingCart;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_EatsCMB);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);

//        Button loginBtn = findViewById(R.id.loginBtn);
//        shoppingCart = findViewById(R.id.mainCart);
//
//        loginBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this,LogInActivity.class));
//            }
//        });

        //configureLogIn();
        ;

        FragmentManager fragmentManager = getSupportFragmentManager();

        MainViewFragment mainViewFragment = new MainViewFragment();
        fragmentManager.beginTransaction().add(R.id.fragment_container_view,new MainViewFragment()).commit();

    }


    /*private void configureLogIn()
    {
        loginBtn = (Button) findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogInActivity(new Intent(MainActivity.this,LogInActivity.class));
            }
        });


    }*/









}