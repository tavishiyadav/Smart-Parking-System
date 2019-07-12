package com.example.smartparkingsystem.Activities;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smartparkingsystem.Data.DatabaseHandler;
import com.example.smartparkingsystem.Model.Parking;
import com.example.smartparkingsystem.R;



public class LoginActivity extends AppCompatActivity {

    //View view = View.inflate(this, R.layout.login, null);
    private Button loginButton;
    private EditText UserName;
    private EditText PassWord;
    Context ctx;
    DatabaseHandler db = new DatabaseHandler(this);
    Parking user= new Parking();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        //db.addUser(user);
        UserName = (EditText) findViewById(R.id.usernameID);
        final String username = UserName.getText().toString();
        PassWord = (EditText) findViewById(R.id.passwordID);
        final String password = PassWord.getText().toString();
        loginButton = (Button) findViewById(R.id.loginButton);
       // db.addUser(user);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(db.verifyUser(username,password))
                {
                    //db.addUser(user);
                    Intent intent= new Intent(LoginActivity.this, Book.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LoginActivity.this, "User Not Found", Toast.LENGTH_LONG).show();
                }
            }
        });

    }


}
