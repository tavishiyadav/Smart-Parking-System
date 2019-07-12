package com.example.smartparkingsystem.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.smartparkingsystem.Data.DatabaseHandler;
import com.example.smartparkingsystem.Model.Parking;
import com.example.smartparkingsystem.R;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    Context ctx;
    DatabaseHandler db = new DatabaseHandler(this);
    Parking user = new Parking();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //db.addUser(user);


        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), LoginActivity.class);

                    startActivity(intent);

            }
        });

    }
}
