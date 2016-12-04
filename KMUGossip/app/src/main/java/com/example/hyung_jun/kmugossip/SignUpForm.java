package com.example.hyung_jun.kmugossip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by Hyung-Jun on 2015-07-22.
 */
public class SignUpForm extends Activity {
    EditText userId_edit;
    EditText userPwd_edit;
    EditText userNick_edit;
    AutoCompleteTextView userMajor_auto;
    RadioGroup userGender_radioGroup;
    RadioButton man_radio;
    RadioButton woman_radio;
    RadioGroup userState_radioGroup;
    RadioButton undergraduate_radio;
    RadioButton postgraduate_radio;
    RadioButton graduate_radio;
    RadioButton another_radio;
    ImageButton signUp_btn;
    //서버로 보낼 정보들.
    String userId, userPwd, userNick, userMajor, userGender, userState;
    //Radio Check 안될 시 알려줌.
    boolean genderChk = false;
    boolean stateChk= false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signupform_layout);
        userId_edit = (EditText)findViewById(R.id.signUserId_edit);
        userPwd_edit = (EditText)findViewById(R.id.signUserPwd_edit);
        userNick_edit = (EditText)findViewById(R.id.userNick_edit);
        userMajor_auto = (AutoCompleteTextView)findViewById(R.id.userMajor_auto);
        userGender_radioGroup = (RadioGroup)findViewById(R.id.userGender_radioGroup);
        man_radio = (RadioButton)findViewById(R.id.man_radio);
        woman_radio = (RadioButton)findViewById(R.id.woman_radio);
        userState_radioGroup = (RadioGroup)findViewById(R.id.userState_radioGroup);
        undergraduate_radio = (RadioButton)findViewById(R.id.undergraduate_radio);
        postgraduate_radio = (RadioButton)findViewById(R.id.postgraduate_radio);
        graduate_radio = (RadioButton)findViewById(R.id.graduate_radio);
        another_radio = (RadioButton)findViewById(R.id.another_radio);
        signUp_btn = (ImageButton)findViewById(R.id.signUp_btn);
        //userId 변수에 EditText 입력값 입력하기.
        userId = userId_edit.getText().toString();
        //userPwd 변수에 EditText 입력값 입력하기.
        userPwd = userPwd_edit.getText().toString();
        //userNick 변수에 EditText 입력값 입력하기.
        userNick = userNick_edit.getText().toString();
        //userGender 변수에 man or woman 입력하기.
        userGender_radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.man_radio){
                    userGender="man";
                    genderChk = true;
                }
                else if(checkedId==R.id.woman_radio){
                    userGender="woman";
                    genderChk = true;
                }
            }
        });
        //userState 변수에 상태 입력하기.
        userState_radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.undergraduate_radio){
                    userState="학부생";
                    stateChk = true;
                }
                else if(checkedId==R.id.postgraduate_radio){
                    userState="대학원생";
                    stateChk = true;
                }
                else if(checkedId==R.id.another_radio){
                    userState="타대생";
                    stateChk = true;
                }
            }
        });

        //AutoCompleteTextView에 필요한 전공
        String[] majorList={
                //문과대학
                "국어국문학과","영어영문학과","중어중문학과","국사학과","교육학과",
                //사회과학대학
                "행정정책학부","정치외교학과","사회학과","언론정보학부","국제학부",
                //법과대학
                "법합부","기업융합법학과",
                //경상대학
                "경제학과","국제통상학과",
                //공과대학
                "신소재공학부","기계시스템공학부","건설시스템공학부",
                //조형대학
                "공업디자인학과","시각디자인학과","금속공예학과","도자공예학과","의상디자인학과","실내디자인학과","영상디자인학과","자동차운송디자인학과",
                //삼림과학대학
                "산림환경시스템학과","임산생명공학과",
                //자연과학대학
                "나노전자물리학과","생명나노화학과","수학과","식품영양학과","바이오발효융합학과",
                //예술대학
                "음악학부","미술학부","공연예술학부",
                //체육대학
                "체육학부",
                //경영대학
                "경영학부","기업경영학부","경영정보학부","KIS","파이낸스보험경영학과",
                //전자정보통신대학
                "전자공학부","컴퓨터공학부",
                //건축대학
                "건축학부",
                //자동차융합대학
                "자동차공학과","자동차IT융합학과",
                //대학원 인문사회계열
                "국어국문학과(대학원)","영어영문학과(대학원)","중어중문학과(대학원)","국사학과(대학원)","교육학과(대학원)","행정학과(대학원)","정치외교학과(대학원)","사회학과(대학원)","언론정보학과(대학원)","국제지역학과(대학원)","법학과(대학원)","경제학과(대학원)","국제통상학과(대학원)","경영학과(대학원)","회계학과(대학원)","데이터사이언스학과(대학원)",
                //대학원 자연과학계열
                "수학과(대학원)","물리학과(대학원)","화학과(대학원)","식품영양학과(대학원)","바이오발효융합학과(대학원)","산림자원학과(대학원)","임산생명공학과(대학원)","산림과학과(대학원)",
                //대학원 공학계열
                "신소재공학과(대학원)","기계공학과(대학원)","기계설계학과(대학원)","건설시스템공학과(대학원)","전자공학과(대학원)","컴퓨터공학과(대학원)","건축학과(대학원)",
                //대학원 예체능계열
                "도예학과(대학원)","금속공예학과(대학원)","공간디자인학과(대학원)","영상디자인학과(대학원)","커뮤니케이션 디자인학과(대학원)","음악학과(대학원)","미술학과(대학원)","공연예술학과(대학원)","체육학과(대학원)",
                //학과간 협동과정
                "문화교차학협동과정(대학원)","금융정보보안학과(대학원)","보안-스마트전기자동차학과(대학원)","나노과학기술협동과정(대학원)","응용정보기술학과(대학원)","문화재보존학과(대학원)","의생명융합학과(대학원)","스포츠공학융합학과(대학원)"
        };
        //회원가입 버튼 누르면 서버DB에 등록되게 하기.
        signUp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpForm.this, MainView.class);
                startActivity(intent);
                finish();
            }
        });
    }
}