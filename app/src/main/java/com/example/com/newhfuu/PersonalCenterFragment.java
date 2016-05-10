package com.example.com.newhfuu;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.com.newhfuu.personal_center.PersonalClicker;

/**
 * Created by woshi on 2016/4/24.
 */
public class PersonalCenterFragment extends Fragment{

    View view;
    LinearLayout account,about,manage,recorderHistory,recorderNow;
    PersonalClicker personalClicker;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.fragment_personal_center,null);
        init();
        onClick();
        return view;
    }

    private void onClick() {
        about.setOnClickListener(personalClicker);
        account.setOnClickListener(personalClicker);
        recorderHistory.setOnClickListener(personalClicker);
        recorderNow.setOnClickListener(personalClicker);
        manage.setOnClickListener(personalClicker);
    }

    private void init() {
        personalClicker = new PersonalClicker(getActivity());
        about = (LinearLayout) view.findViewById(R.id.About);
        account = (LinearLayout) view.findViewById(R.id.Account);
        recorderHistory = (LinearLayout) view.findViewById(R.id.N_Recorder);
        recorderNow = (LinearLayout) view.findViewById(R.id.C_Recorder);
        manage = (LinearLayout) view.findViewById(R.id.J_Manage);



    }

}
