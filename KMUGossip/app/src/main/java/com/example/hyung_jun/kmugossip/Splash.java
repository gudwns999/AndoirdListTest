package com.example.hyung_jun.kmugossip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;

/**
 * Created by Hyung-Jun on 2015-07-22.
 */
public class Splash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);


//00초 후에 자동으로 넘어가기
        android.os.Handler handler = new android.os.Handler() {
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                startActivity(new Intent(Splash.this, LoginForm.class));
                finish();
            }
        };
        handler.sendEmptyMessageDelayed(0, 1000);}
    }


