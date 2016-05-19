package com.example.com.newhfuu.personal_center;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.com.newhfuu.R;

import java.util.Calendar;
import java.util.Locale;

/**
 * Created by woshi on 2016/5/11.
 */
public class AccountClicker implements View.OnClickListener {
   private Activity activity;
    private Context context;
    private TextView   account_tv_name, account_tv_sex, account_tv_IDtype, account_tv_IDnum, account_tv_mobile,
            account_tv_bloodtype, account_tv_marriage, account_tv_occupation, account_tv_birth, account_tv_SIN,account_tv_where;
    private String birth;
    private CliclkerDispose cliclkerDispose;
    private AccountAlertDialog accountAlertDialog;


    public AccountClicker(Context context){
        this.context =context;
    }
    @Override
    public void onClick(View v) {

        PopupWindowForAccount p = new PopupWindowForAccount(context);
        switch (v.getId()){
            case R.id.account_name:
                account_tv_name= (TextView) v.findViewById(R.id.account_tv_name);
                String title = account_tv_name.getText().toString();
                p.showPopwindow(title);
                break;

            case R.id.account_sex:
                account_tv_sex= (TextView) v.findViewById(R.id.account_tv_sex);
                title = account_tv_sex.getText().toString();
                accountAlertDialog = new AccountAlertDialog(context,title);
                accountAlertDialog.shouwzlistDialog();
               // p.showPopwindow(title);
                break;
            case R.id.account_bloodtype:
                account_tv_bloodtype= (TextView) v.findViewById(R.id.account_tv_bloodtype);
                title = account_tv_bloodtype.getText().toString();
                accountAlertDialog = new AccountAlertDialog(context,title);
                accountAlertDialog.shouwzlistDialog();
              //  p.showPopwindow(title);
                break;
            case R.id.account_marriage:
                account_tv_marriage = (TextView) v.findViewById(R.id.account_tv_marriage);
                title = account_tv_marriage.getText().toString();
                accountAlertDialog = new AccountAlertDialog(context,title);
                accountAlertDialog.shouwzlistDialog();
               // p.showPopwindow(title);
                break;
            case R.id.account_occupation:
                account_tv_occupation = (TextView) v.findViewById(R.id.account_tv_occupation);
                title = account_tv_occupation.getText().toString();
                accountAlertDialog = new AccountAlertDialog(context,title);
                accountAlertDialog.shouwzlistDialog();
               // p.showPopwindow(title);
                break;
//                account_tv_IDtype   选择
            case R.id.account_IDnum:   //填写 正则表达式验证？
                account_tv_IDnum = (TextView) v.findViewById(R.id.account_tv_IDnum);
                title = account_tv_IDnum.getText().toString();
                p.showPopwindow(title);
                break;
            case   R.id.account_mobile:     //填写？
                account_tv_mobile = (TextView) v.findViewById(R.id.account_tv_mobile);
                title = account_tv_mobile.getText().toString();
                p.showPopwindow(title);
                break;
            case  R.id.account_SIN:
                account_tv_SIN = (TextView) v.findViewById(R.id.account_tv_SIN);
                title = account_tv_SIN.getText().toString();
                p.showPopwindow(title);
                break;
            case  R.id.account_where:
                account_tv_where = (TextView) v.findViewById(R.id.account_tv_where);
                title = account_tv_where.getText().toString();
                p.showPopwindow(title);
                break;
            case R.id.account_birth:
                /*  代码参考
                *   http://www.cnblogs.com/plokmju/p/android_DatePiceker.html
                */  Calendar c = Calendar.getInstance(Locale.CHINA);
                DatePickerDialog datePicker=new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {

                                           @Override
                                   public void onDateSet(DatePicker view, int year, int monthOfYear,
                                                        int dayOfMonth) {
                                          // TODO Auto-generated method stub
//                                           Toast.makeText(context, year+"year "+(monthOfYear+1)+"month "+dayOfMonth+"day", Toast.LENGTH_SHORT).show();
//                                                birth = year+","+(monthOfYear+1)+","+dayOfMonth;

                                               String title="生日";
                                               String b =year+","+(monthOfYear+1)+","+dayOfMonth;
                                               cliclkerDispose = new CliclkerDispose(title,context, b);    //传指到处理程序。

                                        }
                               }, c.get(Calendar.YEAR)

               , c.get(Calendar.MONTH),  c.get(Calendar.DAY_OF_MONTH));
                           datePicker.show();



                           break;

            default:
                    break;

        }

    }
}
