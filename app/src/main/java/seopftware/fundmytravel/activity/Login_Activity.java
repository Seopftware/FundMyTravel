package seopftware.fundmytravel.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seopftware.fundmytravel.R;

public class Login_Activity extends AppCompatActivity implements Button.OnClickListener {

    // 로그인 버튼
    Button btn_login_phone;
    Button btn_login_google;
    Button btn_login_naver;

    // 이용약관
    TextView tv_terms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 버튼 선언
        btn_login_phone = (Button) findViewById(R.id.btn_login_phone); // 폰 로그인
        btn_login_google = (Button) findViewById(R.id.btn_login_google); // 구글 로그인
        btn_login_naver = (Button) findViewById(R.id.btn_login_naver); // 네이버 로그인

        // 클릭 이벤트를 위해 버튼에 클릭 리스너 달아주기
        btn_login_phone.setOnClickListener(this);
        btn_login_google.setOnClickListener(this);
        btn_login_naver.setOnClickListener(this);

        // Terms & Conditions 링크걸기
        tv_terms = (TextView) findViewById(R.id.tv_terms);
        String terms = "by signing up you agree to our ToS and Privacy Policy";
        tv_terms.setText(terms);

        Linkify.TransformFilter transform = new Linkify.TransformFilter() {
            @Override
            public String transformUrl(Matcher matcher, String s) {
                return "";
            }
        };

        Pattern pattern1 = Pattern.compile("ToS");
        Pattern pattern2 = Pattern.compile("Privacy Policy");
        Linkify.addLinks(tv_terms, pattern1, "http://blog.naver.com/manadra", null, transform);
        Linkify.addLinks(tv_terms, pattern2, "http://blog.naver.com/manadra", null, transform);

    }

    // =========================================================================================================
    // 버튼 리스너
    // =========================================================================================================
    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btn_login_phone : // 폰으로 로그인
                Intent intent=new Intent(getApplicationContext(), Home_Activity.class);
                startActivity(intent);
                finish();
                break;

            case R.id.btn_login_google : // 구글로 로그인
                Intent intent1=new Intent(getApplicationContext(), Home_Activity.class);
                startActivity(intent1);
                finish();
                break;

            case R.id.btn_login_naver : // 네이버 로그인
                Intent intent2=new Intent(getApplicationContext(), Home_Activity.class);
                startActivity(intent2);
                finish();
                break;
        }
    }






}