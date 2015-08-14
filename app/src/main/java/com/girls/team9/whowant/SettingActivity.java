package com.girls.team9.whowant;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.parse.ParseUser;

import java.io.File;

/**
 * Created by eugene on 2015-08-14.
 */
public class SettingActivity extends AppCompatActivity {
    CoordinatorLayout setup_container;
    Button logout;
    Switch swc_notice;
    Button btn_aboutpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("설정");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        logout = (Button) findViewById(R.id.logout);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser currentUser = ParseUser.getCurrentUser();
                if (currentUser != null) {

                    Toast.makeText(getApplicationContext(), "로그아웃되었습니다", Toast.LENGTH_SHORT).show();
                    currentUser.logOut();
                    startActivity(new Intent(getApplicationContext(), SplashActivity.class));
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "로그인정보를 확인하세요", Toast.LENGTH_SHORT).show();
                }//end else
            }
        });//OnClickListener

    }
}
