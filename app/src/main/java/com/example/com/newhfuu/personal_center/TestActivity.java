package com.example.com.newhfuu.personal_center;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.com.newhfuu.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by woshi on 2016/5/21.
 */

public class TestActivity extends AppCompatActivity {

    final static int connT=1;
    private static final int SUCCESS = 1;
    private EditText editText = null ;
    private Button  search     = null;
    private TextView textView = null;

    private String BaseUrl = "http://fanyi.youdao.com/openapi.do";
    private String KeyFrom ="1qqqqq1";
    private String Key      = "414029423";
    private String Type     ="data";
    private String doctype  ="json";
    private String Version  ="1.1";



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);//显示actionbar上的返回箭头
        setContentView(R.layout.activity_test_api);
        init();


    }
    private void init() {
        editText = (EditText) findViewById(R.id.api_et);
        search  = (Button) findViewById(R.id.api_s_btn);
        search.setOnClickListener(new sListener());
        textView = (TextView) findViewById(R.id.api_tv);
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
             switch (msg.what){
                 case SUCCESS:
                     String s = msg.obj.toString();
                     //TODO: UI 更新
                     Dispose(s);
                     break;
                 default:
                     break;
             }

        }};

    private void Dispose(String s) {
       // Toast.makeText(this,s,Toast.LENGTH_SHORT).show();

        JSONObject object =null;
        try{
             object = new JSONObject(s);
            JSONArray jsonArray = new JSONArray("[" + s + "]");

        String message = null;
        for (int i = 0; i < jsonArray.length(); i++)
        {
             object = jsonArray.getJSONObject(i);
            if (object != null)
            {
                String errorCode = object.getString("errorCode");
                if (errorCode.equals("20"))
                {
                    Toast.makeText(getApplicationContext(), "要翻译的文本过长", Toast.LENGTH_SHORT);
                }
                else if (errorCode.equals("30 "))
                {
                    Toast.makeText(getApplicationContext(), "无法进行有效的翻译", Toast.LENGTH_SHORT);
                }
                else if (errorCode.equals("40"))
                {
                    Toast.makeText(getApplicationContext(), "不支持的语言类型", Toast.LENGTH_SHORT);
                }
                else if (errorCode.equals("50"))
                {
                    Toast.makeText(getApplicationContext(), "无效的key", Toast.LENGTH_SHORT);
                }
                else
                {
                    // 要翻译的内容
                    String query = object.getString("query");
                    message = query;
                    // 翻译内容
                    String translation = object.getString("translation");
                    message += "\t" + translation;
                    // 有道词典-基本词典
                    if (object.has("basic"))
                    {
                        JSONObject basic = object.getJSONObject("basic");
                        if (basic.has("phonetic"))
                        {
                            String phonetic = basic.getString("phonetic");
                            message += "\n\t" + phonetic;
                        }
                        if (basic.has("phonetic"))
                        {
                            String explains = basic.getString("explains");
                            message += "\n\t" + explains;
                        }
                    }
                    // 有道词典-网络释义
                    if (object.has("web"))
                    {
                        String web = object.getString("web");
                        JSONArray webString = new JSONArray("[" + web + "]");
                        message += "\n网络释义：";
                        JSONArray webArray = webString.getJSONArray(0);
                        int count = 0;
                        while(!webArray.isNull(count)){

                            if (webArray.getJSONObject(count).has("key"))
                            {
                                String key = webArray.getJSONObject(count).getString("key");
                                message += "\n\t<"+(count+1)+">" + key;
                            }
                            if (webArray.getJSONObject(count).has("value"))
                            {
                                String value = webArray.getJSONObject(count).getString("value");
                                message += "\n\t   " + value;
                            }
                            count++;
                        }
                    }

        }
        textView.setText(message);
    }
    else
    {
        Toast.makeText(getApplicationContext(), "提取异常", Toast.LENGTH_SHORT);

    }}

        }catch (Exception e){
            e.printStackTrace();
        }

        }

    private class sListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            try {
                // 开启一个子线程，进行网络操作，等待有返回结果，使用handler通知UI
                new Thread(networkTask).start();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    /**
     * 网络操作相关的子线程
     */
    Runnable networkTask = new Runnable() {

        @Override
        public void run() {
            //TODO 进行 http request.网络请求相关操作
            try{
            String Content = editText.getText().toString().trim();
            Content = URLEncoder.encode(Content,"utf-8");//设置centent中文部分的编码
            String FullUrl = BaseUrl+"?keyfrom="+KeyFrom+"&key="+Key+"&type="+Type+"&doctype="+doctype+"&version="+Version+"&q="+Content;
            String encoding="UTF-8";
            //建立一个URL对象

            URL url = new URL(FullUrl);
            //得到打开的链接对象
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            //设置请求超时与请求方式
            conn.setReadTimeout(5*1000);
            conn.setRequestMethod("GET");
            InputStream is = conn.getInputStream();
            String result = StreamTool.readMyInputStream(is);

                Message msg = new Message();
                msg.obj = result;
                msg.what = SUCCESS;
            handler.sendMessage(msg);
              }catch (Exception e){
            e.printStackTrace();}

        }





   /* private void HindleJson(String fullUrl) throws Exception{
        String encoding="UTF-8";
        //建立一个URL对象
        URL url = new URL(fullUrl);
        //得到打开的链接对象
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        //设置请求超时与请求方式
        conn.setReadTimeout(5*1000);
        conn.setRequestMethod("GET");
        //从链接中获取一个输入流对象
        InputStream inStream = conn.getInputStream();
        //调用数据流处理方法
        byte[] data = StreamTool.readInputStream(inStream);
        System.out.print(data);
        String json = new String(data);
    }*/
};



}
