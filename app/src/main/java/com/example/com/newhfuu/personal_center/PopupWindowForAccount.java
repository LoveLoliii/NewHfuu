package com.example.com.newhfuu.personal_center;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.com.newhfuu.R;

/**
 * Created by woshi on 2016/5/10.
 */
public class PopupWindowForAccount {
    private Context context;
    private Activity activity;
    private TextView popupTitle,popupContent,popupBtn;
    private PopupWindowBtnDispose popupWindowBtnDispose;
    public PopupWindowForAccount(Context context) {

        this.context = context;
    }

    /**
     * 显示popupWindow
     * @param title
     */
    public void showPopwindow(final String title) {

       activity = (Activity) context;
        // 利用layoutInflater获得View
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.account_pop_window, null);

        popupTitle = (TextView) view.findViewById(R.id.popupTitle);
        popupTitle.setText(title);


        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()

        final PopupWindow window = new PopupWindow(view,
                WindowManager.LayoutParams.FIRST_SUB_WINDOW,
                WindowManager.LayoutParams.WRAP_CONTENT);

        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window.setFocusable(true);


        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xbbfbfbf);
        window.setBackgroundDrawable(dw);


        // 设置popWindow的显示和消失动画
        window.setAnimationStyle(R.style.popwindow_anim_style);
        // 在底部显示
        window.showAtLocation(activity.findViewById(R.id.account_save),//若findViewById寻找的id不在所寻找的view上 会报 a null object reference （空指针引用）
                Gravity.CENTER, 0, 0);

       // 设置背景颜色变暗
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = 0.5f;
        activity.getWindow().setAttributes(lp);
        // 这里检验popWindow里的button是否可以点击
        popupBtn = (TextView) view.findViewById(R.id.popupBtn);
        popupBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                System.out.println("第一个按钮被点击了");
                popupWindowBtnDispose = new PopupWindowBtnDispose(title,context);
                window.dismiss();
            }
        });

        //popWindow消失监听方法
        window.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                //恢复颜色
                WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
                lp.alpha = 1f;
                activity.getWindow().setAttributes(lp);
                System.out.println("popWindow消失");
            }
        });
    }
    }
