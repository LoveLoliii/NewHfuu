package com.example.com.newhfuu.Login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.com.newhfuu.R;

import daoImpl.LoginDispose;
import entity.PatientBaseInfo;

/**
 * 登录功能：
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView forgetPwd,register;
    private EditText phoneEdit,pwdEdit;
    private Button loginButton;
    private Intent intent;
    String phoneEditText,pwdEditText;
    LoginDispose loginDispose = new LoginDispose(this);
    PatientBaseInfo patientBaseInfo;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.arg1){
                case 111:
                    patientBaseInfo = (PatientBaseInfo) msg.obj;
                    System.out.println(patientBaseInfo.getPatient_phone());
                    loginAction(patientBaseInfo);
                    break;
            }
        }
    };

    //执行登录成功 或失败的动作 左手右手一个慢动作~

    private void loginAction(PatientBaseInfo patientBaseInfo) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);//显示actionbar上的返回箭头
        setContentView(R.layout.activity_login);
        init();

    }

    private void validation() {                                       /*  输入框验证处理*/
        phoneEditText = phoneEdit.getText().toString().trim();
        pwdEditText = pwdEdit.getText().toString().trim();
        if (!phoneEditText.equals("") && !pwdEditText.equals("")){
            loginButton.setBackgroundColor(getResources().getColor(R.color.green));
            loginButton.setEnabled(true);
        }else{
            loginButton.setBackgroundColor(getResources().getColor(R.color.gray2));
            loginButton.setEnabled(false);
        }
    }

    private void init() {
        forgetPwd = (TextView) findViewById(R.id.forgetPwd);        /*忘记密码*/
        register = (TextView) findViewById(R.id.register);         /* 注册*/
        loginButton  = (Button) findViewById(R.id.login);       /*登录按钮*/
        phoneEdit = (EditText) findViewById(R.id.phoneEdit);        /*手机号码输入框*/
        pwdEdit = (EditText) findViewById(R.id.pwdEdit);            /*密码输入框*/

        forgetPwd.setOnClickListener(this);
        register.setOnClickListener(this);
        loginButton.setOnClickListener(this);
        phoneEdit.addTextChangedListener(new TextWatcherUser());       /* 为输入框添加事件*/
        pwdEdit.addTextChangedListener(new TextWatcherUser());
        loginButton.setEnabled(false);         /* 默认设置登录按钮为不可点击*/

        //add for mobile


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.forgetPwd:             /* 忘记密码事件*/
                intent = new Intent(this,ForgetPwdActivity.class);
                startActivity(intent);
                break;
            case R.id.register:                 /*注册事件*/
                intent = new Intent(this,RegisteredActivity.class);
                startActivity(intent);
                break;
            case R.id.login:                    /*登录事件*/
                patientBaseInfo = new PatientBaseInfo();
                loginDispose.login(handler);

               // Log.i("onFinishReturn",patientBaseInfo.getPatient_name());
               /*if(patientBaseInfo.isPatient_login_state()==true){
                   // TODO: 2016/5/24  登录成功操作
                   Log.i("login success",patientBaseInfo.getPatient_name().toString());
               }else {
                   // TODO: 2016/5/24  登录失败操作
                   Log.i("login failed",patientBaseInfo.getPatient_name().toString());
                   Log.i("login failed",patientBaseInfo.getPatient_phone().toString());
               }*/
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case android.R.id.home:

                this.finish();
                //overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                return true;
            default:
                return super.onOptionsItemSelected(item);}
    }


    private class TextWatcherUser implements TextWatcher{          /* 内部类  输入框事件*/
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            validation();                /*输入框验证*/
        }
    }
}
