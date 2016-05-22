package com.example.com.newhfuu.Doctor;

import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

import com.example.com.newhfuu.R;

public class DoctorActivity extends AppCompatActivity implements View.OnClickListener {
    private PopupWindow popupWindow;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        Button btn_guahao = (Button) findViewById(R.id.btn_guahao);
        Button btn_zixun = (Button) findViewById(R.id.btn_zixun);

        btn_guahao.setOnClickListener(this);
        btn_guahao.performClick();
        btn_zixun.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        android.app.FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();

        switch (v.getId()) {
            case R.id.btn_guahao:
                beginTransaction.replace(R.id.ll_layout5, new Fragment_guaohao());
                break;

            case R.id.btn_zixun:
                beginTransaction.replace(R.id.ll_layout5, new Fragment_zixun());
                break;


            default:
                break;
        }
        beginTransaction.commit();
    }
    }
