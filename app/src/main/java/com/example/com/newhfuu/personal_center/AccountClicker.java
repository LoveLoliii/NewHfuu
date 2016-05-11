package com.example.com.newhfuu.personal_center;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.com.newhfuu.R;

/**
 * Created by woshi on 2016/5/11.
 */
public class AccountClicker implements View.OnClickListener {
    Activity activity;
    Context context;
    TextView account_tv_name;



    public AccountClicker(Context context){
        this.context =context;
    }
    @Override
    public void onClick(View v) {

        PopupWindowForAccount p = new PopupWindowForAccount(context);
        switch (v.getId()){
            case R.id.account_name:
                account_tv_name= (TextView) v.findViewById(R.id.account_tv_name);
                String a = account_tv_name.getText().toString();
                p.showPopwindow(a);
        }

    }
}
