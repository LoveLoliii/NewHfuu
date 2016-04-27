package com.example.com.newhfuu;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.com.newhfuu.personal_center.PersonalClicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//    public static final int NUM_ITEMS = 10;
//    private TextView About;
//    private PersonalClicker pClicker;
//    private TextView C_Recorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_registration = (Button) findViewById(R.id.btn_registration);
        Button btn_consult = (Button) findViewById(R.id.btn_consult);
        Button btn_find = (Button) findViewById(R.id.btn_find);
        Button btn_personal_center = (Button) findViewById(R.id.btn_personal_center);
        View personalPage = View.inflate(MainActivity.this,R.layout.fragment_personal_center,null);
//        this.About = (TextView) personalPage.findViewById(R.id.About);
//        this.C_Recorder = (TextView)  personalPage.findViewById(R.id.C_Recorder);
//        pClicker = new PersonalClicker(this);
        btn_registration.setOnClickListener(this);
        btn_consult.setOnClickListener(this);
        btn_find.setOnClickListener(this);
        btn_personal_center.setOnClickListener(this);
//        About.setOnClickListener(pClicker);
//        C_Recorder.setOnClickListener(pClicker);
    }

    @Override
    public void onClick(View v) {

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Log.i("aboutclicker","通过");

        switch (v.getId()) {
            case R.id.btn_registration:
                beginTransaction.replace(R.id.ll_layout, new RegistrationFragment());
                break;

            case R.id.btn_consult:
                beginTransaction.replace(R.id.ll_layout, new ConsultFragment());
                break;

            case R.id.btn_find:

                break;

            case R.id.btn_personal_center:
                beginTransaction.replace(R.id.ll_layout, new PersonalCenterFragment());
                break;
            default:
                break;
        }
        beginTransaction.commit();
    }



}
