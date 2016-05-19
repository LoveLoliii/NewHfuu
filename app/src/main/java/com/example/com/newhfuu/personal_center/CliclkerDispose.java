package com.example.com.newhfuu.personal_center;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by woshi on 2016/5/12.
 * 处理popupWindow点击按钮后的后台操作
 */
public class CliclkerDispose {
    public CliclkerDispose(String title, Context context, String b) {

    switch (title){
        case "姓名":
            Toast.makeText(context,"姓名 点击 处理 ",Toast.LENGTH_SHORT).show();

            break;
        case "职业":
            Toast.makeText(context,"点击了"+b,Toast.LENGTH_SHORT).show();
            break;
        case "性别":
            Toast.makeText(context,"点击了"+b,Toast.LENGTH_SHORT).show();
            break;
        case "血型":
            Toast.makeText(context,"点击了"+b,Toast.LENGTH_SHORT).show();
        case "婚姻状况":
            Toast.makeText(context,"点击了"+b,Toast.LENGTH_SHORT).show();
        case "生日":
            Toast.makeText(context,"点击了"+b,Toast.LENGTH_SHORT).show();
            break;
        case "证件号":
            Toast.makeText(context,"证件号 点击 处理 ",Toast.LENGTH_SHORT).show();
            break;
        case "手机号码":
            Toast.makeText(context,"手机号码 点击 处理 ",Toast.LENGTH_SHORT).show();
            break;
        case "社保卡":
            Toast.makeText(context,"社保卡 点击 处理 ",Toast.LENGTH_SHORT).show();
            break;
        case "居住地":
            Toast.makeText(context,"居住地 点击 处理 ",Toast.LENGTH_SHORT).show();
            break;

    }
    }
/*
    public void disposeBirth(String birth, Context context) {
        Toast.makeText(context,"生日 处理 "+birth,Toast.LENGTH_SHORT).show();
    }*/
}
