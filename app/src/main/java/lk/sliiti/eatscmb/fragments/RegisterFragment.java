package lk.sliiti.eatscmb.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import lk.sliiti.eatscmb.R;
import lk.sliiti.eatscmb.database.data.UserData;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {
    private TextView name, password, username;
    private ImageButton registerBtn, backToLoginBtn, backBtn;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RegisterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegisterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
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
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        name = view.findViewById(R.id.register_name);
        username = view.findViewById(R.id.register_username);
        password = view.findViewById(R.id.register_password);
        registerBtn = view.findViewById(R.id.register_btn);
        backToLoginBtn = view.findViewById(R.id.register_goToLoginBtn);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameString = name.getText().toString();
                String usernameString = username.getText().toString();
                String passwordString = password.getText().toString();

                if(UserData.userAlreadyExists(usernameString)){
                    Toast.makeText(getContext(),"This username is already taken!",Toast.LENGTH_SHORT).show();
                }else{
                    UserData.addUser(nameString,usernameString,passwordString,"no");
                    String popUp="";
                    Toast.makeText(getContext(),popUp.concat("Username "+usernameString+" has been successfully added!"),Toast.LENGTH_SHORT).show();
                }
            }
        });

        backToLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction().replace(R.id.fragment_container_view,
                        new LoginFragment()).addToBackStack("Login to Register").commit();
            }
        });


        return view;
    }
}