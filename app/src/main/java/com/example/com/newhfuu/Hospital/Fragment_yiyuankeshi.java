package com.example.com.newhfuu.Hospital;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.com.newhfuu.R;

/**
 * Created by Creat on 2016/4/27.
 */
public class Fragment_yiyuankeshi extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_yiyuankeshi,null);
        Button btn_fuchanke = (Button) view.findViewById(R.id.btn_fuchanke);
        Button btn_neike = (Button) view.findViewById(R.id.btn_neike);
        Button btn_erke = (Button) view.findViewById(R.id.btn_erke);
        Button btn_wuguanke = (Button) view.findViewById(R.id.btn_wuguanke);
        Button btn_waike = (Button) view.findViewById(R.id.btn_waike);
        Button btn_qita = (Button) view.findViewById(R.id.btn_qita);
        Button btn_zhongyike = (Button) view.findViewById(R.id.btn_zhongyike);
        Button btn_zhongliuke = (Button) view.findViewById(R.id.btn_zhongliuke);

        btn_fuchanke.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        android.app.FragmentManager fragmentManager = getFragmentManager();
       android.app.FragmentTransaction beginTransaction=  fragmentManager.beginTransaction();
        switch (v.getId()){
            //医院科室点击事件
            case R.id.btn_fuchanke:
                beginTransaction.replace(R.id.ll_layout4,new Fragment_fuchanke());

                break;

            case R.id.btn_neike:
                beginTransaction.replace(R.id.ll_layout4,new Fragment_neike());
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