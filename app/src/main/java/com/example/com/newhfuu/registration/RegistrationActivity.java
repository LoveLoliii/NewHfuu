package com.example.com.newhfuu.registration;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.com.newhfuu.Hospital.Hospital01;
import com.example.com.newhfuu.R;


public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Button btn_allcity = (Button) findViewById(R.id.btn_allcity);
        Button btn_zhpx = (Button) findViewById(R.id.btn_zhpx);
        Button btn_shuaixuan = (Button) findViewById(R.id.btn_shuaixuan);

        RelativeLayout rl_yiyuan01 = (RelativeLayout) findViewById(R.id.rl_yiyuan01);
        rl_yiyuan01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this, Hospital01.class);
                startActivity(intent);
            }
        });


        btn_allcity.setOnClickListener(this);
        btn_zhpx.setOnClickListener(this);
        btn_shuaixuan.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction beginTransaction =fragmentManager.beginTransaction();

                switch (v.getId()) {
            case R.id.btn_allcity:
                beginTransaction.replace(R.id.ll_layout2, new Quancheng());
                break;

            case R.id.btn_zhpx:
                beginTransaction.replace(R.id.ll_layout2, new Zonghepaixu());
                break;

            case R.id.btn_shuaixuan:
                beginTransaction.replace(R.id.ll_layout2, new Shuaixuan());
                break;

            default:
                break;
        }
        beginTransaction.commit();
    }

}
