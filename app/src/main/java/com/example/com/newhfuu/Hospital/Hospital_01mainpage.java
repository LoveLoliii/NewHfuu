package com.example.com.newhfuu.Hospital;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.com.newhfuu.R;

public class Hospital_01mainpage extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_01mainpage);
       Button btn_yiyuankeshi = (Button) findViewById(R.id.btn_yiyuankeshi);
       Button btn_yiyuanfuwu = (Button) findViewById(R.id.btn_yiyuanfuwu);
       Button btn_yiyuanjianjie = (Button) findViewById(R.id.btn_yiyuanjianjie);

        btn_yiyuankeshi.setOnClickListener(this);
        btn_yiyuanfuwu.setOnClickListener(this);
        btn_yiyuanjianjie.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        android.app.FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction beginTransaction =fragmentManager.beginTransaction();

        switch (v.getId()){
            case R.id.btn_yiyuankeshi:
                beginTransaction.replace(R.id.ll_layout4,new Fragment_yiyuankeshi());
                break;

            case R.id.btn_yiyuanfuwu:
                beginTransaction.replace(R.id.ll_layout4,new Fragment_yiyuanfuwu());
                break;

            case R.id.btn_yiyuanjianjie:
                beginTransaction.replace(R.id.ll_layout4,new Fragment_yiyuanjianjie());
                break;

            default:
                break;
        }
        beginTransaction.commit();

    }
}
