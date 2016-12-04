package com.example.hyung_jun.kmugossip;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TabHost;
public class MainView extends TabActivity implements TabHost.OnTabChangeListener{
    //색상 선언
    String colorRed = "FF0000"; String colorYellow="FFFF00"; String colorPurple ="#800080";
    String colorDarkgreen ="006400";
    //탭뷰 배경에 쓸 Color 선언
    String colorOfView00,colorOfView01,colorOfView02,colorOfView03;
    //검색&글쓰기 에디트 텍스트 누르면 글쓰기 액티비티로 넘어갈꺼임. 그 첫번째 변수 선언!
    EditText search_edit;
    //웹뷰를 활성화 시킬 버튼
    ImageButton plus_btn;
    //슬라이드뷰 활성화 시킬 버튼
    ImageButton slide_imgbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainview_layout);
        //다른 class로 넘어가기 위한 Intent선언.
        Intent intent;
        //탭뷰 선언.
        TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);
        TabHost.TabSpec spec1,spec2,spec3,spec4;
        //tabHost = getTabHost();
        colorOfView00 = colorRed;
        colorOfView01 = colorYellow;
        colorOfView02 = colorPurple;
        colorOfView03 = colorDarkgreen;
        //탭뷰 선택시 해당 class로 이동.
        intent = new Intent().setClass(MainView.this, AList.class);
        spec1 = tabHost.newTabSpec("Love").setIndicator("연애",getResources().getDrawable(R.drawable.loveicon)).setContent(intent);
      //  tabHost.setBackgroundResource(R.drawable.loveicon);
        intent = new Intent().setClass(MainView.this, BList.class);
        spec2 = tabHost.newTabSpec("Trade").setIndicator("교류",getResources().getDrawable(R.drawable.tradeicon)).setContent(intent);
        intent = new Intent().setClass(MainView.this, CList.class);
        spec3 = tabHost.newTabSpec("Study").setIndicator("학업/취업",getResources().getDrawable(R.drawable.studyicon)).setContent(intent);
        intent = new Intent().setClass(MainView.this, DList.class);
        spec4 = tabHost.newTabSpec("Gossip").setIndicator("GOSSIP",getResources().getDrawable(R.drawable.gossipicon)).setContent(intent);
       //탭을 TabHost에 추가한다.
        tabHost.addTab(spec1);
        tabHost.addTab(spec2);
        tabHost.addTab(spec3);
        tabHost.addTab(spec4);
        //글쓰기
        search_edit = (EditText)findViewById(R.id.search_edit);
        search_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainView.this, SearchAndWrite.class);
                startActivity(intent1);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                //finish();
            }
        });
        //Tab에 배경 색 지정.
//        tabHost.getTabWidget().getChildAt(0).setBackgroundColor(Color.parseColor(colorOfView00));
//        tabHost.getTabWidget().getChildAt(1).setBackgroundColor(Color.parseColor(colorOfView01));
//        tabHost.getTabWidget().getChildAt(2).setBackgroundColor(Color.parseColor(colorOfView02));
//        tabHost.getTabWidget().getChildAt(3).setBackgroundColor(Color.parseColor(colorOfView03));

        //플러스 버튼 누르면 웹뷰로 넘어감.
        plus_btn = (ImageButton)findViewById(R.id.plus_btn);
        plus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainView.this, WebPlus.class);
                startActivity(intent1);
                //finish();
            }
        });
        //슬라이드 뷰 나옴.
        slide_imgbtn = (ImageButton)findViewById(R.id.slide_imgbtn);
        slide_imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainView.this, SlideMenu.class);
                startActivity(intent2);
            }
        });
    }
    //탭 뷰 눌렀을 시 색상 변하게 하기
    @Override
    public void onTabChanged(String tabId){
        //색상 정하기.
   /*     colorOfView00 = colorRed;
        colorOfView01 = colorYellow;
        colorOfView02 = colorPurple;
        colorOfView03 = colorDarkgreen;
        //Tab에 배경 색 지정.
        tabHost.getTabWidget().getChildAt(0).setBackgroundColor(Color.parseColor(colorOfView00));
        tabHost.getTabWidget().getChildAt(1).setBackgroundColor(Color.parseColor(colorOfView01));
        tabHost.getTabWidget().getChildAt(2).setBackgroundColor(Color.parseColor(colorOfView02));
        tabHost.getTabWidget().getChildAt(3).setBackgroundColor(Color.parseColor(colorOfView03));

        tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundColor(Color.parseColor("#ffffff"));*/
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mainview_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
