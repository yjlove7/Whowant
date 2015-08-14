package com.girls.team9.whowant;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    Toolbar toolbar;

    FragmentTransaction fragmentTransaction;
    Fragment cur_fragment=new MainFragment();

    Boolean isvisible=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "L2yes9VmFrSxAwKDU942H4CUPyJCvAdV8uwdw6nN", "QT3lxiZv63TzWK47RPeh4uTFm3T42hIx8APbvrvU");
        ParseInstallation.getCurrentInstallation().saveInBackground();


        startActivity(new Intent(this, SplashActivity.class));

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setUpNavDrawer();

        fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container, cur_fragment);
        fragmentTransaction.commit();
        drawerLayout=(DrawerLayout)findViewById(R.id.drawerlayout);

        navigationView=(NavigationView)findViewById(R.id.navigationView);

        TextView user_name = (TextView) navigationView.findViewById(R.id.user_name);
        ParseUser user = ParseUser.getCurrentUser();
        if(user == null) {
            user_name.setText("로그인을 해주세요.");
        } else {
            user_name.setText(user.getString("name")+"님 환영합니다.");
        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                if (menuItem.getGroupId() == R.id.group_a) {
                    navigationView.getMenu().setGroupCheckable(R.id.group_b, false, true);
                    navigationView.getMenu().setGroupCheckable(R.id.group_a, true, true);
                    navigationView.getMenu().setGroupCheckable(R.id.group_c, false, true);
                } else if (menuItem.getGroupId() == R.id.group_b) {
                    navigationView.getMenu().setGroupCheckable(R.id.group_a, false, true);
                    navigationView.getMenu().setGroupCheckable(R.id.group_b, true, true);
                    navigationView.getMenu().setGroupCheckable(R.id.group_c, false, true);
                }else if (menuItem.getGroupId() == R.id.group_c) {
                    navigationView.getMenu().setGroupCheckable(R.id.group_a, false, true);
                    navigationView.getMenu().setGroupCheckable(R.id.group_b, false, true);
                    navigationView.getMenu().setGroupCheckable(R.id.group_c, true, true);
                }


                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                menuItem.setChecked(true);
                switch (menuItem.getItemId()) {
                    case R.id.main:
                        getSupportActionBar().setTitle("추천 상품");

                        cur_fragment = new MainFragment();
                        fragmentTransaction.replace(R.id.container, cur_fragment);
                        fragmentTransaction.commit();
                        drawerLayout.closeDrawers();
                        isvisible = true;
                        invalidateOptionsMenu();
                        return true;

                    case R.id.my:
//                        getSupportActionBar().setTitle("로그인");
                        if(ParseUser.getCurrentUser() != null) {
                            Toast.makeText(getApplicationContext(), "로그인이 필요합니다.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this, LoginActivity.class));
                            drawerLayout.closeDrawers();
                            isvisible = true;
                            invalidateOptionsMenu();
                            return true;
                        } else {
                            startActivity(new Intent(MainActivity.this, LoginActivity.class));
                            drawerLayout.closeDrawers();
                            isvisible = true;
                            invalidateOptionsMenu();
                            return true;
                        }

                    case R.id.basket:
//                        getSupportActionBar().setTitle("장바구니");
                        startActivity(new Intent(MainActivity.this, BasketActivity.class));
                        drawerLayout.closeDrawers();
                        isvisible = true;
                        invalidateOptionsMenu();
                        return true;

                    case R.id.setting:
//                        getSupportActionBar().setTitle("설정");
                        startActivity(new Intent(MainActivity.this, SettingActivity.class));
                        drawerLayout.closeDrawers();
                        isvisible = false;
                        invalidateOptionsMenu();
                        return true;

                    case R.id.request:
//                        getSupportActionBar().setTitle("판매참여신청");
//                        drawerLayout.closeDrawers();
                        Toast.makeText(getApplicationContext(), "준비중입니다.", Toast.LENGTH_SHORT).show();

                    case R.id.donation:
//                        getSupportActionBar().setTitle("기부행사안내");
//                        drawerLayout.closeDrawers();
                        Toast.makeText(getApplicationContext(), "준비중입니다.", Toast.LENGTH_SHORT).show();

                }
                return true;
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                if (drawerLayout.isDrawerOpen(navigationView))
                    drawerLayout.closeDrawers();
                else {
                    moveTaskToBack(true);
                    finish();
                }//end else
                break;
        }//end switch

        return true;
    }

    private void setUpNavDrawer() {
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("WhoWant");
        toolbar.setNavigationIcon(R.drawable.drawericon);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }//setUpNavDrawer

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}//class
