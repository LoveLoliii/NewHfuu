package com.example.com.newhfuu.personal_center;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.example.com.newhfuu.R;

/**
 * Created by woshi on 2016/4/26.
 */
public class PersonalClicker implements View.OnClickListener {
    private Activity activity;
    public PersonalClicker(Activity activity){
        this.activity = activity;
    }
    @Override

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.About:

                Intent intent = new Intent(activity,AboutActivity.class);
                activity.startActivity(intent);
//                activity.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                break;
            case R.id.Account:
                 intent = new Intent(activity,AccountActivity.class);
                activity.startActivity(intent);
//                activity.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                break;
            case R.id.C_Recorder:
                intent = new Intent(activity,RecorderHistoryActivity.class);
                activity.startActivity(intent);
                break;
            case R.id.N_Recorder:
                intent = new Intent(activity,RecorderNowActivity.class);
                activity.startActivity(intent);
                break;
            case R.id.J_Manage:
                intent = new Intent(activity,ManageActivity.class);
                activity.startActivity(intent);
                break;
            default:
                break;
        }

    }
}
