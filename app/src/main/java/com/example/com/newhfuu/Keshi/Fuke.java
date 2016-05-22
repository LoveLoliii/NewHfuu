package com.example.com.newhfuu.Keshi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.com.newhfuu.Doctor.DoctorActivity;
import com.example.com.newhfuu.R;

public class Fuke extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuke);

        TextView tv_hah02 = (TextView) findViewById(R.id.tv_hah02);
        tv_hah02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Fuke.this,DoctorActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.tv_hah01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Fuke.this, DoctorActivity.class);
                startActivity(intent);
            }
        });
    }
}
