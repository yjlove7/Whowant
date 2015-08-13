package com.girls.team9.whowant;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by hyemi on 2015-08-14.
 */
public class DetailAtivity extends AppCompatActivity{
    Intent intent;

    TextView price;
    TextView name;

    Button add_basket;
    Button buy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("상세 페이지");

        intent = getIntent();

        name = (TextView)findViewById(R.id.name);
        price = (TextView)findViewById(R.id.price);
        add_basket = (Button)findViewById(R.id.add_basket);
        buy = (Button)findViewById(R.id.buy);

        name.setText(intent.getStringExtra("name"));
        price.setText(intent.getStringExtra("price"));

        add_basket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_basket.setText("장바구니 해제");
                Toast.makeText(getApplicationContext(), "상품이 장바구니에 담겼습니다.", Toast.LENGTH_SHORT).show();


            }
        });//add_basket.setOnClickListener


        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });//buy.setOnClickListener


    }

}//class
