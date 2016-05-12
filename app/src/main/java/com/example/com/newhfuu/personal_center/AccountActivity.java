package com.example.com.newhfuu.personal_center;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.com.newhfuu.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class AccountActivity extends AppCompatActivity {
    LinearLayout accout_photo, account_name, account_sex, account_IDtype, account_IDnum, account_mobile,
            account_bloodtype, account_marriage, account_occupation, account_birth, account_SIN,account_where;
    AccountClicker ac;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);//显示actionbar上的返回箭头

        setContentView(R.layout.activity_personal_center_account);
        init();
        clicker();
//        getSupportActionBar().hide();

    }

    private void clicker() {
        account_name.setOnClickListener(ac);
       account_birth.setOnClickListener(ac);
        account_sex.setOnClickListener(ac);
        account_IDnum.setOnClickListener(ac);
        account_mobile.setOnClickListener(ac);
        account_where.setOnClickListener(ac);
        account_SIN.setOnClickListener(ac);
    }

    private void init() {
        /*Context context = getBaseContext();*/
        ac = new AccountClicker(this);
        accout_photo = (LinearLayout) findViewById(R.id.accout_photo);
        account_name = (LinearLayout) findViewById(R.id.account_name);
        account_sex = (LinearLayout) findViewById(R.id.account_sex);
        account_IDtype = (LinearLayout) findViewById(R.id.account_IDtype);
        account_IDnum = (LinearLayout) findViewById(R.id.account_IDnum);
        account_mobile = (LinearLayout) findViewById(R.id.account_mobile);
        account_bloodtype = (LinearLayout) findViewById(R.id.account_bloodtype);
        account_marriage = (LinearLayout) findViewById(R.id.account_marriage);
        account_occupation = (LinearLayout) findViewById(R.id.account_occupation);
        account_birth = (LinearLayout) findViewById(R.id.account_birth);
        account_SIN = (LinearLayout) findViewById(R.id.account_SIN);
        account_where = (LinearLayout) findViewById(R.id.account_where);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_account, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.account_save:
                Toast.makeText(AccountActivity.this, "Seleted the account_save", Toast.LENGTH_SHORT).show();
                return true;
            case android.R.id.home:

                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}
