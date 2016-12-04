package com.example.hyung_jun.kmugossip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by admin on 2015-08-04.
 */
public class SlideMenu extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slidemenu_layout);

        Button out_btn = (Button)findViewById(R.id.Out_btn);
        Button nickNameChange=(Button)findViewById(R.id.nickNameChange_btn);
        Button logOut_btn=(Button)findViewById(R.id.logOut_btn);

        logOut_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent goToLogin=new Intent(SlideMenu.this,LoginForm.class);
                startActivity(goToLogin);
            }
        });

        out_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intentMain=new Intent(SlideMenu.this,MainView.class);

                startActivity(intentMain);
            }
        });

        nickNameChange.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intentNickChange=new Intent(SlideMenu.this, NickNameChange.class);
                startActivity(intentNickChange);
            }
        });
    }
}



