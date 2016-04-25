package com.example.com.newhfuu;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.com.newhfuu.registration.RegistrationActivity;

/**
 * Created by Creat on 2016/4/23.
 */
public class RegistrationFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_registration,null);

           view.findViewById(R.id.ll_yuyueguahao).setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(getActivity(), RegistrationActivity.class);
                   startActivity(intent);
               }
           });


        return view;
    }
}
