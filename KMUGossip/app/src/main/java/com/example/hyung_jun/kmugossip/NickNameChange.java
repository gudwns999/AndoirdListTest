package com.example.hyung_jun.kmugossip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by admin on 2015-08-05.
 */
public class NickNameChange extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nicknamechange_layout);

        Button repeatButton_btn=(Button)findViewById(R.id.repeatButton_btn);
        Button goToMain_btn=(Button)findViewById(R.id.goToMain_btn);
        repeatButton_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText newNickEdit=(EditText)findViewById(R.id.newNick_edit);
                String newNick=newNickEdit.getText().toString();

                if(newNick.length()>10)
                    Toast.makeText(NickNameChange.this,"별명은 한글로 10글자 이내 입니다!",Toast.LENGTH_SHORT).show();
                else if(newNick.length()==0)
                    Toast.makeText(NickNameChange.this,"별명 칸이 공백입니다. 다시 입력해주세요!",Toast.LENGTH_SHORT).show();
            }
        });

        goToMain_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent goToMain=new Intent(NickNameChange.this,MainView.class);
                startActivity(goToMain);
            }
        });
    }

}
