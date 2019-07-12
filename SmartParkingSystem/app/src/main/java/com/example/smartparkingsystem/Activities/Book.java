package com.example.smartparkingsystem.Activities;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.view.View;

import com.example.smartparkingsystem.Data.DatabaseHandler;
import com.example.smartparkingsystem.Model.Parking;
import com.example.smartparkingsystem.R;


public class Book extends AppCompatActivity implements View.OnClickListener {
    LinearLayout ll;
    boolean i;
    Button but, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;
    DatabaseHandler db = new DatabaseHandler(this);
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_activity);

        b1 = (Button) findViewById(R.id.b2);
        b2 = (Button) findViewById(R.id.b3);
        b3 = (Button) findViewById(R.id.b4);
        b4 = (Button) findViewById(R.id.b5);
        b5 = (Button) findViewById(R.id.b6);
        b6 = (Button) findViewById(R.id.b7);
        b7 = (Button) findViewById(R.id.b8);
        b8 = (Button) findViewById(R.id.b9);
        b9 = (Button) findViewById(R.id.b10);
        b10 = (Button) findViewById(R.id.b1);
        but = (Button) findViewById(R.id.button);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b10.setOnClickListener(this);

        Parking parking = new Parking();


        b1.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        b1.setBackgroundColor(Color.RED);
                        db.updatestatus(1);


                    }
                }
        );

        b2.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        b2.setBackgroundColor(Color.RED);
                        db.updatestatus(2);

                    }
                }
        );
        b3.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        b3.setBackgroundColor(Color.RED);
                        db.updatestatus(3);

                    }
                }
        );
        b4.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        b4.setBackgroundColor(Color.RED);
                        db.updatestatus(4);

                    }
                }
        );
        b5.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        b5.setBackgroundColor(Color.RED);
                        db.updatestatus(5);

                    }
                }
        );
        b6.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        b6.setBackgroundColor(Color.RED);
                        db.updatestatus(6);

                    }
                }
        );
        b7.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        b7.setBackgroundColor(Color.RED);
                        db.updatestatus(7);

                    }
                }
        );
        b8.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        b8.setBackgroundColor(Color.RED);
                        db.updatestatus(8);

                    }
                }
        );
        b9.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        b9.setBackgroundColor(Color.RED);
                        db.updatestatus(9);

                    }
                }
        );
        b10.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        b10.setBackgroundColor(Color.RED);
                        db.updatestatus(10);

                    }
                }
        );


        but.setOnClickListener(this);


    }



    @Override
    public void onClick(View v) {
        Intent intent= new Intent(Book.this, DetailsActivity.class);
        startActivity(intent);
    }
}


