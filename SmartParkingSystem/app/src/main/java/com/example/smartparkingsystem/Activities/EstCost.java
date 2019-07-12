package com.example.smartparkingsystem.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartparkingsystem.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.time.OffsetTime;

public class EstCost extends AppCompatActivity implements OnClickListener {
    Button b;
    TextView input1;
    TextView input2;
    private IntentIntegrator qrScan;
    public String outTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estimated_cost);
        b = (Button) findViewById(R.id.exitScanButton);
        OffsetTime offset = OffsetTime.now();
        int cur_hr = offset.getHour();
        int cur_m = offset.getMinute();
        b.setOnClickListener(this);
        input1 = (TextView) findViewById(R.id.timeID);
        input2 = (TextView) findViewById(R.id.estimatedCostID);
        int cost;
        int fin_time;
        int fin_hr,fin_min,in_hr,in_min;

        Bundle intime=getIntent().getExtras();

        String inTime=intime.getString("inTime");

        String[] words =inTime.split("\\s+");

        in_hr=Integer.parseInt(words[0]);
        in_min=Integer.parseInt(words[1]);

        fin_hr=cur_hr-in_hr;
        if(fin_hr<0)
            fin_hr+=24;
        fin_min=cur_m-in_min;
        if(fin_min<0)
            fin_min+=60;
        input1.setText(fin_hr+" Hrs "+fin_min+" Mins");
        if(fin_min>0)
            fin_hr++;
        fin_time=fin_hr;
        cost=fin_time*50;
        input2.setText("Rs. "+cost);


        qrScan = new IntentIntegrator(this);

        //attaching onclick listener
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qrScan.initiateScan();
            }
        });
    }


    public void onClick (View b)
    {
        Intent i = new Intent(getApplicationContext(), ScanOutActivity.class);
        startActivity(i);
        setContentView(R.layout.estimated_cost);
    }


    //Getting the scan results
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            //if qrcode has nothing in it
            if (result.getContents() == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            } else {
                //if qr contains data

                outTime=result.getContents();
                String str= "Out time is "+ outTime;
                Intent intent= new Intent(this, Payment.class);
                intent.putExtra("outTime",outTime);
                startActivity(intent);
                //textViewHeader.setText(str);

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
