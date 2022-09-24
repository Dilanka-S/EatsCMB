package lk.sliiti.eatscmb.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import lk.sliiti.eatscmb.R;
import lk.sliiti.eatscmb.database.data.UserData;
import lk.sliiti.eatscmb.database.model.User;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {
    private EditText username, password;
    private ImageButton loginButton, loginToRegButton;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
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
        UserData.initialise();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_login, container, false);

        loginToRegButton = view.findViewById(R.id.login_to_reg_btn);
        loginToRegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction().replace(R.id.fragment_container_view,
                        new RegisterFragment()).addToBackStack("Login to Register").commit();
            }
        });
        loginButton = view.findViewById(R.id.login_menu_login_btn);
        username = view.findViewById(R.id.login_username);
        password = view.findViewById(R.id.login_password);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameString = username.getText().toString();
                String passwordString = password.getText().toString();

                //Toast.makeText(getContext(),usernameString,Toast.LENGTH_SHORT).show();

                if(UserData.getUser(usernameString)!=null){
                    User user = UserData.getUser(usernameString);
                    //Toast.makeText(getContext(),user.getName(),Toast.LENGTH_SHORT).show();
                    if(passwordString.equals(user.getPassword())){
                        user.setLogStatus("true");
                        Toast.makeText(getContext(),"Successfull Login!",Toast.LENGTH_SHORT).show();
                        getParentFragmentManager().beginTransaction().replace(R.id.fragment_container_view,new MainViewFragment()).addToBackStack("Login to MainView").commit();
                    }else{
                        Toast.makeText(getContext(),"Invalid Password!",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getContext(),"Invalid Username!",Toast.LENGTH_SHORT).show();
                }


            }
        });

        return view;
    }
}