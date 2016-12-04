package com.example.hyung_jun.kmugossip;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Hyung-Jun on 2015-08-04.
 */
public class SearchAndWrite extends Activity {
    EditText writeSomething_edit;
    Button sendPost_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchandwrite_layout);
        writeSomething_edit = (EditText)findViewById(R.id.writeSomething_edit);
        sendPost_btn = (Button)findViewById(R.id.sendPost_btn);
        //버튼 누르면 서버DB에 글이 입력됨.
        sendPost_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SendPost().execute();
                Toast.makeText(getApplicationContext(),"됐다 섹스야",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class SendPost extends AsyncTask<Void, Void, String> {
        protected String doInBackground(Void...unused){
            String content = executeClient();
            return content;
        }
        protected void onPostExecute(String result){
            //모든 작업을 마치고 실행할 일.
        }
        //실제 전송하는 부분
        public String executeClient(){
            String tmp = "test";
            ArrayList<NameValuePair> post = new ArrayList<NameValuePair>();
            post.add(new BasicNameValuePair("b_id", "티키타카툐"));
            post.add(new BasicNameValuePair("b_mail", "gudwns999@naver.com"));
            post.add(new BasicNameValuePair("b_title", "세상에서 가장 재밌는 글"));
            post.add(new BasicNameValuePair("b_content", writeSomething_edit.getText().toString()));
            post.add(new BasicNameValuePair("b_date", "15_08_06_19:15"));
            post.add(new BasicNameValuePair("b_view", "알라뷰"));
            post.add(new BasicNameValuePair("b_pwd", "안알랴줌"));
            post.add(new BasicNameValuePair("b_ref", "1"));
            post.add(new BasicNameValuePair("b_relevel", "1"));
            post.add(new BasicNameValuePair("b_restep", "1"));


            HttpClient client = new DefaultHttpClient();
            // 객체 연결 설정 부분, 연결 최대시간 등등
            HttpParams params = client.getParams();
            HttpConnectionParams.setConnectionTimeout(params, 5000);
            HttpConnectionParams.setSoTimeout(params, 5000);

            // Post객체 생성
            HttpPost httpPost = new HttpPost("http://10.30.126.246/KMU/writeDB.php");

            try {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(post, "UTF-8");
                httpPost.setEntity(entity);
                client.execute(httpPost);
                return EntityUtils.getContentCharSet(entity);
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
