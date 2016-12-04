package com.example.hyung_jun.kmugossip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Hyung-Jun on 2015-07-22.
 */
public class LoginForm extends Activity {
    EditText userId_edit;
    EditText userPwd_edit;
    ImageButton login_btn;
    TextView signUp_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginform_layout);
        userId_edit = (EditText)findViewById(R.id.loginUserId_edit);
        userPwd_edit = (EditText)findViewById(R.id.loginUserPwd_edit);
        login_btn = (ImageButton)findViewById(R.id.login_btn);
        signUp_text = (TextView)findViewById(R.id.signUp_text);
        //E-Mail 입력시.

        //PASSWORD 입력시.

        //Login버튼 눌렀을 때. (ID와 PWD가 Null이 아니며 서버DB에 정보와 비교해 보아야 한다.)
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //MainView로 넘어감.
                Intent intent = new Intent(LoginForm.this, MainView.class);
                startActivity(intent);
                finish();
            }
        });
        //SignUp Text 눌렀을때. 가입화면으로 넘어감.
        signUp_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //MainView로 넘어감.
                Intent intent = new Intent(LoginForm.this, SignUpForm.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
