package com.example.com.newhfuu;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.com.newhfuu.registration.Consult_doctorActivity;
import com.example.com.newhfuu.registration.GynecologicalActivity;
import com.example.com.newhfuu.registration.RegistrationActivity;
import com.example.com.newhfuu.registration.Sickness_advanceActivity;
import com.example.com.newhfuu.registration.Subsequent_visitActivity;

/**
 * Created by Creat on 2016/4/23.
 */
public class RegistrationFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


//        预约挂号的点击事件
        View view = inflater.inflate(R.layout.fragment_registration,null);

           view.findViewById(R.id.ll_yuyueguahao).setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(getActivity(), RegistrationActivity.class);
                   startActivity(intent);
               }
           });


//        咨询医生的点击事件
            view.findViewById(R.id.rl_zixunyisheng).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), Consult_doctorActivity.class);
                    startActivity(intent);
                }
            });

//        疾病导诊点击事件
        view.findViewById(R.id.tv_jbdz).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Sickness_advanceActivity.class);
                startActivity(intent);
            }
        });

//        预约复诊的点击事件

        view.findViewById(R.id.tv_yyfz).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Subsequent_visitActivity.class);
                startActivity(intent);
            }
        });

//        热门科室的点击事件
        Button btn_gynecological = (Button) view.findViewById(R.id.btn_gynecological);             //妇科
        Button btn_obstetrics = (Button) view.findViewById(R.id.btn_obstetrics);                   //产科
        Button btn_pediatrics = (Button) view.findViewById(R.id.btn_pediatrics);                   //儿科
        Button btn_TCM = (Button) view.findViewById(R.id.btn_TCM);                                  //中医科
        Button btn_gastroenterology = (Button) view.findViewById(R.id.btn_gastroenterology);      //消化内科
        Button btn_ophthalmic = (Button) view.findViewById(R.id.btn_ophthalmic);                   //眼科
        Button btn_dermatology = (Button) view.findViewById(R.id.btn_dermatology);                //皮肤科
        Button btn_other = (Button) view.findViewById(R.id.btn_other);                             //其他

        btn_gynecological.setOnClickListener(this);
        btn_obstetrics.setOnClickListener(this);
        btn_pediatrics.setOnClickListener(this);
        btn_TCM.setOnClickListener(this);
        btn_gastroenterology.setOnClickListener(this);
        btn_ophthalmic.setOnClickListener(this);
        btn_dermatology.setOnClickListener(this);
        btn_other.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_gynecological:
                Intent intent = new Intent(getActivity(), GynecologicalActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_obstetrics:
                Intent intent1 = new Intent(getActivity(), GynecologicalActivity.class);
                startActivity(intent1);
                break;

            case R.id.btn_pediatrics:
                Intent intent2 = new Intent(getActivity(), GynecologicalActivity.class);
                startActivity(intent2);
                break;

            case R.id.btn_TCM:
                Intent intent3= new Intent(getActivity(), GynecologicalActivity.class);
                startActivity(intent3);
                break;

            case R.id.btn_gastroenterology:
                Intent intent4 = new Intent(getActivity(), GynecologicalActivity.class);
                startActivity(intent4);
                break;

            case R.id.btn_ophthalmic:
                Intent intent5 = new Intent(getActivity(), GynecologicalActivity.class);
                startActivity(intent5);
                break;

            case R.id.btn_dermatology:
                Intent intent6 = new Intent(getActivity(), GynecologicalActivity.class);
                startActivity(intent6);
                break;

            case R.id.btn_other:
                Intent intent7 = new Intent(getActivity(), GynecologicalActivity.class);
                startActivity(intent7);
                break;

            default:

                break;
        }

    }
}
