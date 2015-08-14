package com.girls.team9.whowant;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseUser;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by eugene on 2015-08-14.
 */
public class LoginActivity extends AppCompatActivity {
    EditText id_text;
    EditText pass_text;
    Button login_btn;
    Button signup_btn;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signup_btn= (Button) findViewById(R.id.signup_btn);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("로그인");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        id_text= (EditText) findViewById(R.id.id_text);
        pass_text= (EditText) findViewById(R.id.pass_text);
        login_btn= (Button) findViewById(R.id.login_btn);
        signup_btn= (Button) findViewById(R.id.signup_btn);
        progressBar=(ProgressBar)findViewById(R.id.progressbar);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setVisibility(View.VISIBLE);
                                ParseUser.logInInBackground(String.valueOf(id_text.getText()), String.valueOf(pass_text.getText()), new LogInCallback() {
                                    @Override
                                    public void done(ParseUser user, ParseException e) {
                                        if (user != null) {
                                            progressBar.setVisibility(View.GONE);
                                            finish();
                                        } else {
                                            progressBar.setVisibility(View.GONE);
                                            Toast.makeText(getApplicationContext(), "틀렸습니다.", Toast.LENGTH_SHORT).show();
                                        }


                                    }
                                });
                            }
                        });
                    }
                }).start();

            }
        });

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
            }
        });
    }
}
