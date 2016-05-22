package com.example.com.newhfuu.Doctor;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.com.newhfuu.R;

/**
 * Created by Creat on 2016/5/21.
 */
public class Fragment_guaohao extends Fragment implements View.OnClickListener {
    private PopupWindow popWindow;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_guahao, null);
        Button btn_yuyue = (Button) view.findViewById(R.id.btn_yuyue);
        Button btn_yuyue2 = (Button) view.findViewById(R.id.btn_yuyue2);

        btn_yuyue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow();
            }
        });

        btn_yuyue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow();
            }
        });
        return view;
    }

    private void showPopupWindow() {
        //设置contentView
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.popwindow_layout, null);
        PopupWindow mPopupWindow = new PopupWindow(view, 400, LinearLayoutCompat.LayoutParams.WRAP_CONTENT);
        // mPopupWindow.setBackgroundDrawable(new
        // BitmapDrawable());//必须设置background才能消失
        mPopupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg2));
//        mPopupWindow.setOutsideTouchable(true);

        Button button1 = (Button) view.findViewById(R.id.button1);
        Button button2 = (Button) view.findViewById(R.id.button2);
        Button button3 = (Button) view.findViewById(R.id.button3);
        Button button4 = (Button) view.findViewById(R.id.button4);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

        // 自定义动画
        // mPopupWindow.setAnimationStyle(R.style.PopupAnimation);
        // 使用系统动画
        mPopupWindow.setAnimationStyle(android.R.style.Animation_Dialog);
        mPopupWindow.update();
        mPopupWindow.setTouchable(true);
        mPopupWindow.setFocusable(true);

        if (!mPopupWindow.isShowing()) {
            // mPopupWindow.showAsDropDown(view,0,0);
//            mPopupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
            mPopupWindow.showAsDropDown(view);
        }//显示 popupwindow
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1: {
                Intent intent = new Intent(getActivity(),SureinfoActivity.class);
                startActivity(intent);
            }
            break;

            case R.id.button2:{
                Toast.makeText(getActivity(),"您预约在下午",Toast.LENGTH_SHORT).show();
            }
            break;

            case R.id.button3:{
                Toast.makeText(getActivity(),"您预约在上午",Toast.LENGTH_SHORT).show();
            }
            break;

            case R.id.button4:{
                Toast.makeText(getActivity(),"您预约在下午",Toast.LENGTH_SHORT).show();
            }
            break;
        }
    }
}
