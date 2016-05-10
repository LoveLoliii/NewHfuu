package com.example.com.newhfuu.personal_center;

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
import android.widget.Toast;

import com.example.com.newhfuu.R;

public class AccountActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
              ActionBar mActionBar = getSupportActionBar();
              mActionBar.setDisplayHomeAsUpEnabled(true);//显示actionbar上的返回箭头

        setContentView(R.layout.activity_personal_center_account);

//        getSupportActionBar().hide();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_account,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.account_save:
                PopupWindowForAccount p = new PopupWindowForAccount(this);
                p.showPopwindow();
                Toast.makeText(AccountActivity.this, "Seleted the account_save", Toast.LENGTH_SHORT).show();
                return true;
            case android.R.id.home:

                this.finish();
                return true;
            default:
        return super.onOptionsItemSelected(item);}
    }




}
