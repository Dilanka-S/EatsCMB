package lk.sliiti.eatscmb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

import lk.sliiti.eatscmb.database.DBHelper;

public class LogInActivity extends AppCompatActivity {

    EditText username, password, nextPass;
    Button logInBtn,registerBtn,backBtn;
    DBHelper testDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.log_in);

        username = (EditText)findViewById(R.id.userNameTxt);
        password = (EditText)findViewById(R.id.password);
        nextPass = (EditText)findViewById(R.id.nextPass);

        logInBtn = (Button) findViewById(R.id.login_btn_2);
        registerBtn = (Button) findViewById(R.id.register_btn2);

        backBtn = (Button) findViewById(R.id.backBtn);

        testDB = new DBHelper(this);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String nPass = nextPass.getText().toString();


                if(user.equals("")||pass.equals("")||nPass.equals(""))
                {
                    Toast.makeText(LogInActivity.this,"Username or Password Missing",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(pass.equals(nPass))
                    {
                        Boolean userResult = testDB.checkUser(user);
                        if(userResult==false)
                        {
                            Boolean regResult = testDB.insertData(user,pass);
                            if(regResult==true)
                            {
                                Toast.makeText(LogInActivity.this,"ACCOUNT SUCCESSFULLY CREATED",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),UserProfileActivity.class);
                            }
                            else
                            {
                                Toast.makeText(LogInActivity.this,"REGISTRATION FAILED",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(LogInActivity.this,"Username Already Exists",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(LogInActivity.this,"Username and Password Does Not Match",Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),UserProfileActivity.class);
                startActivity(intent);
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("") || pass.equals(""))
                {
                    Toast.makeText(LogInActivity.this,"Enter Credentials.",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean result = testDB.checkUserPassword(user,pass);
                    if(result==false)
                    {
                        Toast.makeText(LogInActivity.this,"Invalid Username or Password",Toast.LENGTH_SHORT).show();


                    }
                    else
                    {
                        Intent intent1 = new Intent(getApplicationContext(),UserProfileActivity.class);
                        startActivity(intent1);

                    }

                }

            }
        });
    }
}