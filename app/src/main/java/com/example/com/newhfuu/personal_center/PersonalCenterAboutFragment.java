package com.example.com.newhfuu.personal_center;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.com.newhfuu.R;

/**
 * Created by woshi on 2016/4/25.
 */
public class PersonalCenterAboutFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal_center_about,null);
        return view;
    }
}
